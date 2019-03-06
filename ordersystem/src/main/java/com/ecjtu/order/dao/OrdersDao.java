package com.ecjtu.order.dao;

import com.ecjtu.order.bean.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Desc: 订单Dao
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.dao
 * ProjectName: order
 * Date: 2019/2/15 20:46
 */
@Mapper
public interface OrdersDao
{
    /**
     * 根据订单id删除订单
     *
     * @param orderId 订单id
     * @return 整数
     */
    int deleteByPrimaryKey(Integer orderId);

    /**
     * 插入订单信息
     *
     * @param orders 订单对象
     * @return 整数
     */
    int insert(Orders orders);

    /**
     * 根据id查询订单信息
     *
     * @param orderId 订单id
     * @return 订单对象信息
     */
    Orders selectByPrimaryKey(Integer orderId);

    /**
     * 根据用户id查询出所有订单
     *
     * @param userId 用户id
     * @return 订单对象集合
     */
    List<Orders> selectAll(@Param(value = "userId") Integer userId);

    /**
     * 更像订单
     *
     * @param orders 订单对象
     * @return 整数
     */
    int updateByPrimaryKey(Orders orders);

    /**
     * 查询出所有订单
     *
     * @return 订单对象集合
     */
    List<Orders> selectall();
}
