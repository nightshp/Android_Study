package com.lunzn.artist.controller.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lunzn.artist.exception.InnerException;
import com.lunzn.artist.log.InterfaceLogEvt;
import com.lunzn.artist.log.InterfaceServiceLogEvt;
import com.lunzn.artist.log.LogUtil;
import com.lunzn.artist.message.req.IMsgRequest;
import com.lunzn.artist.message.req.IMsgRequestData;
import com.lunzn.artist.message.resp.IResponse;

/**
 * Action业务逻辑抽象父类
 * <功能详细描述>
 * 
 * @author  longguofei
 * @param <REQ> request请求公共参数
 * @param <DATA> request请求参数
 * @param <RESP> 返回数据
 * @version  [版本号, 2017年10月19日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public abstract class HttpBaseAction<REQ extends IMsgRequest, DATA extends IMsgRequestData, RESP extends IResponse>
{
    /**
     * 通用的接口日志结构体
     */
    private InterfaceLogEvt logEvt;
    
    /**
     * service接口日志结构体
     */
    private InterfaceServiceLogEvt serviceLogEvt;
    
    /**
     * 具体的动作
     * <一句话功能简述>
     * <功能详细描述>
     * @param paramREQ request请求公共参数
     * @param paramREQD request请求参数
     * @param paramRESP 返回数据
     * @see [类、类#方法、类#成员]
     */
    protected abstract void action(REQ paramREQ, DATA paramREQD, RESP paramRESP);
    
    /**
     * 执行
     * <一句话功能简述>
     * <功能详细描述>
     * @param baseRequest request请求公共参数
     * @param requestData request请求参数
     * @param response 返回数据
     * @see [类、类#方法、类#成员]
     */
    public void execute(REQ baseRequest, DATA requestData, RESP response)
    {
        action(baseRequest, requestData, response);
    }
    
    /**
     * 获取数据
     * <一句话功能简述>
     * <功能详细描述>
     * @param paramREQD request请求参数
     * @param paramRESP 返回数据
     * @return 获取数据
     * @see [类、类#方法、类#成员]
     */
    protected abstract Map<String, Object> getDataMap(DATA paramREQD, RESP paramRESP);
    
    /**
     * 记录接口日志
     * <功能详细描述>
     * @param request 请求对象
     * @see [类、类#方法、类#成员]
     */
    public abstract void recordInterfaceLog(HttpServletRequest request);
    
    /**
     * 用于记录接口服务的接口日志
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    public void recordServieInterfaceLog()
    {
        // 记录接口日志
        LogUtil.printInterfaceLog(this.getServiceLogEvt());
    }
    
    /**
     * 执行之后执行
     * <一句话功能简述>
     * <功能详细描述>
     * @param baseRequest request请求公共参数
     * @param requestData request请求参数
     * @param response 返回数据]
     * @param uri 接口名称
     * @throws InnerException 内部异常
     * @see [类、类#方法、类#成员]
     */
    public abstract void beforeExecute(REQ baseRequest, DATA requestData, RESP response, String uri)
        throws InnerException;
    
    /**
     * 获取服务名称
     * <功能详细描述>
     * @return String 服务名称
     * @see [类、类#方法、类#成员]
     */
    public abstract String getActionServiceName();
    
    /**
     * 开始记录日志
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    public void doStartLog()
    {
        // 初始化日志体
        this.logEvt = new InterfaceLogEvt();
        this.serviceLogEvt = new InterfaceServiceLogEvt();
    }
    
    /** 
     * 其他操作
     * <功能详细描述>
     * @param request request请求对象
     * @param response response响应对象
     * @param baseRequest request请求公共参数
     * @param requestData request请求参数
     * @param resp 返回数据
     * @see [类、类#方法、类#成员]
     */
    public void doOthers(HttpServletRequest request, HttpServletResponse response, REQ baseRequest, DATA requestData,
        RESP resp)
    {
    }
    
    /**
     * 结束记录日志
     * <一句话功能简述>
     * <功能详细描述>
     * @param baseRequest request请求公共参数
     * @param requestData request请求参数
     * @param response 返回数据
     * @see [类、类#方法、类#成员]
     */
    protected void doEndLog(REQ baseRequest, DATA requestData, RESP response)
    {
    }
    
    public InterfaceLogEvt getLogEvt()
    {
        return logEvt;
    }
    
    public void setLogEvt(InterfaceLogEvt logEvt)
    {
        this.logEvt = logEvt;
    }
    
    public InterfaceServiceLogEvt getServiceLogEvt()
    {
        return serviceLogEvt;
    }
    
    public void setServiceLogEvt(InterfaceServiceLogEvt serviceLogEvt)
    {
        this.serviceLogEvt = serviceLogEvt;
    }
    
}
