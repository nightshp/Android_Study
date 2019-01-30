package com.lunzn.artist.system.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lunzn.artist.enums.ResultCode;
import com.lunzn.artist.message.resp.BaseResponse;

/**
 * 全局处理异常类
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年11月2日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@ControllerAdvice
public class GobelExecption
{
    private final static Logger logger = LoggerFactory.getLogger(GobelExecption.class);
    
    @ExceptionHandler(value = ValidateException.class)
    @ResponseBody
    public BaseResponse handleValidateException(ValidateException e)
    {
        BaseResponse response = new BaseResponse();
        logger.info("{},{}", ((ValidateException)e).getErrorDesc(), ((ValidateException)e).getContent());
        //参数校验异常处理
        response.setRetCode(((ValidateException)e).getErrorCode());
        response.setRetMsg(((ValidateException)e).getMessage());
        
        return response;
    }
    
    @ExceptionHandler(value = InnerException.class)
    @ResponseBody
    public BaseResponse handleInnerException(InnerException e)
    {
        BaseResponse response = new BaseResponse();
        
        logger.info("{}", ((InnerException)e).getErrorDesc());
        //系统内部异常处理
        response.setRetCode(((InnerException)e).getErrorCode());
        response.setRetMsg(((InnerException)e).getErrorDesc());
        
        return response;
        
    }
    
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse handleException(Exception e)
    {
        BaseResponse response = new BaseResponse();
        
        response.setRetCode(ResultCode.INVALID_PARAM.getResultCode());
        response.setRetMsg(ResultCode.INVALID_PARAM.getResultMsg());
        
        return response;
    }
    
}
