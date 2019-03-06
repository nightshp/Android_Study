package com.ecjtu.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class OrderApplication extends WebMvcConfigurerAdapter
{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        // 配置文件映射路径 映射到D盘的upload文件夹下
        registry.addResourceHandler("/upload/**").addResourceLocations("file:/D:/upload/");
        super.addResourceHandlers(registry);
    }

    public static void main(String[] args)
    {
        SpringApplication.run(OrderApplication.class, args);
    }



}
