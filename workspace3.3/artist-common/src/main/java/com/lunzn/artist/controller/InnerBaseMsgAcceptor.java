package com.lunzn.artist.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.IOUtils;
import com.lunzn.artist.constants.NumberKeys;
import com.lunzn.artist.controller.action.HttpBaseAction;
import com.lunzn.artist.enums.ResultCode;
import com.lunzn.artist.exception.InnerException;
import com.lunzn.artist.log.InterfaceLogEvt;
import com.lunzn.artist.log.LogUtil;
import com.lunzn.artist.message.req.IMsgRequest;
import com.lunzn.artist.message.req.IMsgRequestData;
import com.lunzn.artist.message.req.InnerBaseRequest;
import com.lunzn.artist.message.req.InnerServiceBaseRequest;
import com.lunzn.artist.message.resp.BaseResponse;
import com.lunzn.artist.message.resp.IResponse;
import com.lunzn.artist.system.exception.ValidateException;
import com.lunzn.artist.util.ParameterUtil;

/**
 * Http请求接收、校验、分发类
 * <功能详细描述>
 * 
 * @author  longguofei
 * @version  [版本号, 2017年10月19日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class InnerBaseMsgAcceptor
{
    private static final Logger LOGGER = LoggerFactory.getLogger(InnerBaseMsgAcceptor.class);
    
    private static Map<String, HttpBaseAction<IMsgRequest, IMsgRequestData, IResponse>> actions =
        new HashMap<String, HttpBaseAction<IMsgRequest, IMsgRequestData, IResponse>>();
    
    /**
     * 注册action
     * <一句话功能简述>
     * <功能详细描述>
     * @param uri 接口
     * @param action 具体执行对象
     * @see [类、类#方法、类#成员]
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void registerAction(String uri, HttpBaseAction action)
    {
        LOGGER.info("registerAction:[uri:{}]", uri);
        actions.put(uri, action);
    }
    
    /**
     * action分发入口
     * <功能详细描述>
     * @param request 请求体
     * @param response 响应体
     * @throws IOException IO异常
     * @see [类、类#方法、类#成员]
     */
    @SuppressWarnings("unchecked")
    public void doAction(HttpServletRequest request, HttpServletResponse response)
        throws ValidateException
    {
        IResponse resp = new BaseResponse();
        String uri = request.getRequestURI();
        // 用于区分管理台和接口服务的标识
        String serviceId = null;
        HttpBaseAction<IMsgRequest, IMsgRequestData, IResponse> action = actions.get(uri);
        if (action == null)
        {
            resp = new BaseResponse(ResultCode.NATIVE_SERVICE_NOT_FOUND);
            LOGGER.error("This action not be register, uri:{}", uri);
            writeOutputStream(response, resp, serviceId);
            return;
        }
        // 初始化日志体
        action.doStartLog();
        
        //业务逻辑处理开始时间
        long startTime = System.currentTimeMillis();
        // 具体的异常消息
        String exceptionMsg = "";
        //初始化请求参数
        JSONObject json = new JSONObject();
        //请求参数关键字
        String paramKey = "";
        try
        {
            ParameterizedType type = (ParameterizedType)action.getClass().getAnnotatedSuperclass().getType();
            Type[] arguments = type.getActualTypeArguments();
            Class<IMsgRequest> baseReqClass = (Class<IMsgRequest>)arguments[0];
            Class<IMsgRequestData> baseReqDataClass = (Class<IMsgRequestData>)arguments[1];
            Class<IResponse> baseRespClass = (Class<IResponse>)arguments[2];
            //服务名称(为了兼容管理台代码)
            serviceId = action.getActionServiceName();
            paramKey = serviceId.equals("operation") ? "data" : "param";
            // 收集参数
            json = ParameterUtil.newInstance().collectParamJson(request);
            if ("data".equals(paramKey))
            {
                String userId = (String)request.getSession().getAttribute("userId");
                JSONObject data = json.getJSONObject(paramKey);
                if (data == null)
                {
                    data = new JSONObject();
                    
                }
                data.put("userId", userId);
                json.put(paramKey, data);
            }
            
            // 请求体的所有参数
            IMsgRequest req = JSON.toJavaObject(json, baseReqClass);
            IMsgRequestData reqData = null;
            if (serviceId.equals("operation"))
            {
                // 请求参数中的业务相关参数(data)
                InnerBaseRequest baseReq = new InnerBaseRequest();
                if (baseReqClass.isAssignableFrom(InnerBaseRequest.class))
                {
                    baseReq = (InnerBaseRequest)req;
                }
                reqData = JSON.toJavaObject(baseReq.getData(), baseReqDataClass);
            }
            else
            {
                // 请求参数中的业务相关参数(data)
                InnerServiceBaseRequest baseReq = new InnerServiceBaseRequest();
                if (baseReqClass.isAssignableFrom(InnerServiceBaseRequest.class))
                {
                    baseReq = (InnerServiceBaseRequest)req;
                }
                reqData = JSONObject.parseObject(baseReq.getParam(), baseReqDataClass);
            }
            
            // 响应结果
            resp = baseRespClass.newInstance();
            
            // 签名校验 //公共参数校验
            action.beforeExecute(req, reqData, resp, uri);
            // 执行固定请求参数校验
            //Validator.getInstance().validate(baseReqClass, req);
            // 执行业务参数校验
            // Validator.getInstance().validate(baseReqDataClass, reqData);
            /**因为业务action依赖ip，所以在此存放ip  start**/
            InterfaceLogEvt evt = new InterfaceLogEvt();
            action.setLogEvt(evt);
            //设置来源ip
            String ip = LogUtil.getIP(request);
            evt.setSource(ip);
            /**因为业务action依赖ip，所以在此存放ip  end**/
            // 执行业务逻辑
            action.execute(req, reqData, resp);
            //执行其他操作
            action.doOthers(request, response, req, reqData, resp);
        }
        catch (InnerException e)
        {
            resp = new BaseResponse(e);
            exceptionMsg = e.getMessage();
            LOGGER.error("内部异常", e);
        }
        catch (Exception e)
        {
            resp = new BaseResponse(ResultCode.INNER_ERROR);
            exceptionMsg = e.getMessage();
            LOGGER.error("内部异常", e);
        }
        finally
        {
            //设置参数
            action.getServiceLogEvt().setParam(json.getString(paramKey));
            //设置开始时间
            action.getLogEvt().setStartTime(startTime);
            long endTime = System.currentTimeMillis();
            //接口执行时间
            action.getServiceLogEvt().setTime(String.valueOf(endTime - startTime));
            /*-------------------------------接口日志---------------------------------------------*/
            action.getServiceLogEvt().setAction(uri);
            // 填充日志数据
            buildLogEvt(action, request, resp, json, exceptionMsg);
            // 记录开发日志
            action.recordInterfaceLog(request);
            // 记录接口日志
            action.recordServieInterfaceLog();
            
        }
        writeOutputStream(response, resp, serviceId);
    }
    
    /**
     * 构建日志数据
     * <功能详细描述>
     * @param action 业务逻辑处理类
     * @param request 请求体
     * @param resp 响应体
     * @param json 业务参数
     * @param exceptionMsg 异常信息
     * @see [类、类#方法、类#成员]
     */
    private void buildLogEvt(HttpBaseAction<IMsgRequest, IMsgRequestData, IResponse> action, HttpServletRequest request,
        IResponse resp, JSONObject json, String exceptionMsg)
    {
        String level = resp.getRetCode() == NumberKeys.NUM_0 ? LogLevel.INFO.name() : LogLevel.WARN.name();
        String ip = LogUtil.getIP(request);
        //long endTime = System.currentTimeMillis();
        /*-------------------------------开发日志---------------------------------------------*/
        //action.getLogEvt().setDest(uri);
        action.getLogEvt().setSource(ip);
        //action.getLogEvt().setStartTime(startTime);
        action.getLogEvt().setTransactionId(UUID.randomUUID().toString());
        action.getLogEvt().setResultCode(resp.getRetCode());
        action.getLogEvt().setExceptionMsg(resp.getRetMsg() + ":" + exceptionMsg);
        action.getLogEvt().setLogLevel(level);
        
        /*-------------------------------接口日志---------------------------------------------*/
        //action.getServiceLogEvt().setAction(uri);
        //接口执行时间
        //action.getServiceLogEvt().setTime(String.valueOf(endTime - startTime));
        //设置参数
        //action.getServiceLogEvt().setParam(json.getString(paramKey));
        //设置version
        action.getServiceLogEvt().setVersion(json.getString("version"));
        //设置sn
        action.getServiceLogEvt().setSn(json.getString("client_id"));
        action.getServiceLogEvt().setLogLevel(level);
    }
    
    /**
     * 响应结果输出
     * <功能详细描述>
     * @param response 响应对象
     * @param resp 响应结果
     * @throws IOException IO异常
     * @see [类、类#方法、类#成员]
     */
    private void writeOutputStream(HttpServletResponse response, IResponse resp, String serviceId)
    {
        // 文件流无需写返回
        if ("application/octet-stream;charset=utf-8".equalsIgnoreCase(response.getContentType()))
        {
            return;
        }
        
        PrintWriter out = null;
        try
        {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            out = response.getWriter();
            // 兼容公共返回字段
            if ("service".equals(serviceId))
            {
                // 接口服务返回英文提示
                resp.setRetMsg(ResultCode.getItem(resp.getRetCode()).getResultMsgEn());
                // 保留为null的节点
                String withStr = JSON.toJSONString(resp);
                //                if (resp.getClass().isAssignableFrom(LocationResp.class))
                //                {
                //                    // 获取客户端位置接口特殊处理
                //                    out.print(withStr.replaceAll("\\\\u", "\\u"));
                //                }
                //                else if (resp.getClass().isAssignableFrom(QueryIrcodeResp.class))
                //                {
                //                    String withNullStr = JSON.toJSONString(resp, SerializerFeature.WriteMapNullValue);
                //                    // 获取红外编码列表 (剔除为null但不需要返回的节点)
                //                   // out.print(ResponseHelper.getInstance().hideNullValue(withNullStr, resp));
                //                }
                //                else
                //                {
                //                    out.print(withStr);
                //                }
            }
            else
            {
                // 管理台用retCode和retMsg
                JSONObject jsonObj = JSON.parseObject(JSON.toJSONString(resp));
                int ret = jsonObj.getInteger("ret");
                String retMsg = jsonObj.getString("ret_msg");
                jsonObj.put("retCode", ret);
                jsonObj.put("retMsg", retMsg);
                jsonObj.remove("ret");
                jsonObj.remove("ret_msg");
                out.print(jsonObj.toJSONString());
            }
            out.flush();
        }
        catch (IOException e)
        {
            LOGGER.error("write msg error.", e);
        }
        finally
        {
            IOUtils.close(out);
        }
    }
    
}
