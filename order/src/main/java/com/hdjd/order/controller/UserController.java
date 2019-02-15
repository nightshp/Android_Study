package com.hdjd.order.controller;

import com.hdjd.order.bean.User;
import com.hdjd.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Desc: TODO
 * <p>
 * Author: suhongpeng
 * PackageName: com.hdjd.order.controller
 * ProjectName: order
 * Date: 2019/2/15 11:39
 */
@Controller
@RequestMapping("/userInfo")
public class UserController
{
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public List<User> queryAll()
    {
        return userService.queryAllUser();
    }

    @RequestMapping("/hello")
    public String hello()
    {
        return "index";
    }
}
