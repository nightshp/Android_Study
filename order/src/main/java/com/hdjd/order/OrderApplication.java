package com.hdjd.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.hdjd.order.dao")
@SpringBootApplication
public class OrderApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(OrderApplication.class, args);
    }

}

