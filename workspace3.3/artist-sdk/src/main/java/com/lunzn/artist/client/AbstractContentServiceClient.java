package com.lunzn.artist.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.lunzn.artist.exception.InnerException;
import com.lunzn.artist.message.MsgSendServiceImpl;
import com.lunzn.artist.message.annotations.Location;
import com.lunzn.artist.message.req.BaseRequestData;
import com.lunzn.artist.message.resp.BaseResponse;

/**
 * 聚合数据服务Client父类
 * 
 * @author  longguofei
 * @version  [版本号, 2017年11月21日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public abstract class AbstractContentServiceClient
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractContentServiceClient.class);
    
    private static MsgSendServiceImpl msgSendService = null;
    
    /**
     * 向远程服务发送请求
     * <功能详细描述>
     * @param evt 请求对象
     * @param respClass 响应对象类型
     * @param <T> 返回
     * @return 响应对象
     * @throws InnerException 框架自定义异常
     * @see [类、类#方法、类#成员]
     */
    protected static <T extends BaseResponse> T send(BaseRequestData evt, Class<T> respClass)
        throws InnerException
    {
        if (getMsgSendService() == null)
        {
            setMsgSendService(new MsgSendServiceImpl("contentservice"));
        }
        // 组装请求体参数
        // 发送请求
        long startTime = System.currentTimeMillis();
        T resp = msgSendService.sendLzMsg(evt, respClass);
        Location location = evt.getClass().getAnnotation(Location.class);
        LOGGER.info("Interface:{}, spendTime:{}, msg:{}, resp:{}",
            location.uri(),
            System.currentTimeMillis() - startTime,
            JSONObject.toJSONString(evt),
            JSONObject.toJSONString(resp));
        return resp;
    }
    
    public static MsgSendServiceImpl getMsgSendService()
    {
        return msgSendService;
    }
    
    public static void setMsgSendService(MsgSendServiceImpl msgSendService)
    {
        AbstractContentServiceClient.msgSendService = msgSendService;
    }
    
}
