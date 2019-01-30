package com.lunzn.artist.controller.action;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 404错误处理
 * 
 * @author  Administrator
 * @version  [版本号, 2018年11月12日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
public class HttpErrorController implements ErrorController
{
    
    private static final String ERROR_PATH = "/error";
    
    @RequestMapping(value = ERROR_PATH)
    public String handleError()
    {
        return "artist/404";
    }
    
    @Override
    public String getErrorPath()
    {
        return ERROR_PATH;
    }
    
}
