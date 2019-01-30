package com.lunzn.artist.log;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * aop实现接口日志的打印
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年11月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Aspect
@Component
public class LogAspect
{
    
    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger("logger.interface.service");
    
    /**
     * 开始时间
     */
    private ThreadLocal<Long> startTime = new ThreadLocal<>();
    
    /**
     * java对象转json结构
     */
    private final ObjectMapper mapper;
    
    /**
     * 
     * <默认构造函数>
     * @param mapper 参数
     */
    public LogAspect(ObjectMapper mapper)
    {
        this.mapper = mapper;
    }
    
    /**
     * 
     * 指明哪些地方需要切入
     * @see [类、类#方法、类#成员]
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    //    @Pointcut("execution(public * com.lunzn.artist.controller..*.*(..))")
    public void webLog()
    {
    }
    
    /**
     * 切入方法前打印参数
     * @param joinPoint 切入点
     * @see [类、类#方法、类#成员]
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint)
    {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        
        startTime.set(System.currentTimeMillis());
        logger.info("uri :{}, classPath:{}, request parameter :{}",
            request.getRequestURL().toString(),
            joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName(),
            Arrays.toString(joinPoint.getArgs()));
        
    }
    
    /**
     * 方法返回后，打印返回参数
     * @param response 入参
     * @throws Throwable 异常
     * @see [类、类#方法、类#成员]
     */
    @AfterReturning(returning = "response", pointcut = "webLog()")
    public void doAfterReturning(Object response)
        throws Throwable
    {
        
        logger.info("spendtime:{},response parameter{}",
            System.currentTimeMillis() - startTime.get(),
            mapper.writeValueAsString(response));
        
    }
}
