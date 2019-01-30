package com.lunzn.artist.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lunzn.artist.exception.InnerException;

@RestController
@RequestMapping("/advice1")
public class AdviceController
{
    @RequestMapping(value = "/test1")
    public String test1()
        throws InnerException
    {
        throw new InnerException("advice1 - exception2");
    }
    
    @RequestMapping(value = "/test2")
    public String test2()
        throws InnerException
    {
        throw new InnerException("advice1 - exception2");
    }
    
}
