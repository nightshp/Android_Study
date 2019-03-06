package com.ecjtu.order.contoller;

import com.ecjtu.order.bean.Admin;
import com.ecjtu.order.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Desc: 后台管理controller
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.contoller
 * ProjectName: ordersystem
 * Date: 2019/2/18 14:48
 */
@Controller
public class AdminController
{
    @Autowired
    private AdminService adminService;
    @RequestMapping("/loginAdmin")
    @ResponseBody
    public  String loginAdmin(@RequestParam(value = "adminName") String adminName, @RequestParam(value = "adminPassword") String adminPassword, Model model){
        Admin admin= adminService.selectByAP(adminName,adminPassword);
        model.addAttribute("admin",admin);
        if(admin!=null){
            return "ok";
        }
        return "error";
    }
    @RequestMapping("/logoutAdmin")
    public String logout(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "admin/login";
    }
}
