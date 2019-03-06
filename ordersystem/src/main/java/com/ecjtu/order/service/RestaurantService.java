package com.ecjtu.order.service;

import com.ecjtu.order.bean.Restaurant;

import java.util.List;

/**
 * Desc: 餐馆信息管理service
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.service
 * ProjectName: order
 * Date: 2019/2/15 21:38
 */
public interface RestaurantService
{
    /**
     * 根据id删除餐厅
     *
     * @param restaurId 餐馆id
     * @return 整数
     */
    int deleteByPrimaryKey(Integer restaurId);

    /**
     * 插入餐厅信息
     *
     * @param restaurant 餐馆对象
     * @return 整数
     */
    int insert(Restaurant restaurant);

    /**
     * 根据id查询餐厅信息
     *
     * @param restaurId 餐馆id
     * @return 餐馆对象信息
     */
    Restaurant selectByPrimaryKey(Integer restaurId);

    /**
     * 查询所有餐厅信息
     *
     * @return 餐馆对象集合
     */
    List<Restaurant> selectAll();

    /**
     * 更新餐厅信息
     *
     * @param restaurant 餐馆对象
     * @return 整数
     */
    int updateByPrimaryKey(Restaurant restaurant);

    /**
     * 根据restaurName和restaurAddress查询餐厅信息
     *
     * @param restaurName    餐馆名字
     * @param restaurAddress 餐馆地址
     * @return 餐馆对象集合
     */
    List<Restaurant> selectByNA(String restaurName, String restaurAddress);

    /**
     * 根据多字段进行模糊查询
     *
     * @param restaurName    餐馆名字
     * @param restaurAddress 餐馆地址
     * @return 餐馆对象集合
     */
    List<Restaurant> selectByMany(String restaurName, String restaurAddress);
}
