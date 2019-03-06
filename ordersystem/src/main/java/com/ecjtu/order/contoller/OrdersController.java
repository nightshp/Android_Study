package com.ecjtu.order.contoller;

import com.ecjtu.order.bean.Address;
import com.ecjtu.order.bean.Orders;
import com.ecjtu.order.service.AddressService;
import com.ecjtu.order.service.OrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Desc: 订单管理controller
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.contoller
 * ProjectName: order1
 * Date: 2019/2/18 14:51
 */
@Controller
public class OrdersController
{
    @Autowired
    OrdersService ordersService;
    @Autowired
    AddressService addressService;
    //插入订单
    @RequestMapping("/insertOrder")
    @ResponseBody
    public String insertOrder(Integer userId, Orders orders){
        Address address=addressService.selectDefU(1,userId);
        String send_addr=address.getAreaAddress()+" "+address.getDetaAddress();
        String ordername=address.getRecName();
        orders.setUserId(userId);
        orders.setSendAddr(send_addr);
        orders.setOrderName(ordername);
//        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        orders.setOrderStatus(1);
        if(ordersService.insert(orders)>0){
            return "ok";
        }else{
            return "error";
        }
    }
    //查询出用户的所有订单
    @RequestMapping("/selectOrders")
    public String selectOrders(Integer userId, Model model){
        List<Orders> orders=ordersService.selectAll(userId);
        model.addAttribute("orders",orders);
        return "afterapp/book";
    }
    //删除订单
    @RequestMapping("/deleteOrder")
    @ResponseBody
    public String deleteOrder(Integer orderId){
        return ordersService.deleteByPrimaryKey(orderId)> 0 ? "ok" : "error";
    }
    //查询出所有订单并分页
    @RequestMapping("/selectall")
    public String aelectall(Integer page, Model model){
        PageHelper.startPage(page, 3);          //传入页码以及每页的大小
        List<Orders> orders = ordersService.selectall();
        PageInfo pageinfo = new PageInfo(orders);        //使用pageinfo包装结果集，只需将pageinfo交给页面
        model.addAttribute("pageinfo", pageinfo);
        return "admin/ordermanager";
    }
    //根据用户id查询出用户的所有订单/后台
    @RequestMapping("/selectByUser")
    public String selectByUser(Integer userId, Model model){
        System.out.println(userId);
//            PageHelper.startPage(page, 3);          //传入页码以及每页的大小
        List<Orders> orders = ordersService.selectAll(userId);
        System.out.println(orders.size());
//            PageInfo pageinfo = new PageInfo(orders);        //使用pageinfo包装结果集，只需将pageinfo交给页面
        model.addAttribute("orders", orders);
        return "admin/showorder";
    }

}
