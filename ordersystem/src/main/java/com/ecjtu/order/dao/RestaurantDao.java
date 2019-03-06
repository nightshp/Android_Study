package com.ecjtu.order.dao;

import com.ecjtu.order.bean.Restaurant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Desc: 餐馆Dao
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.dao
 * ProjectName: order
 * Date: 2019/2/15 20:47
 */
@Mapper
public interface RestaurantDao
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
    List<Restaurant> selectByNA(@Param(value = "restaurName") String restaurName,
        @Param(value = "restaurAddress") String restaurAddress);

    /**
     * 根据多字段进行模糊查询
     *
     * @param restaurName    餐馆名字
     * @param restaurAddress 餐馆地址
     * @return 餐馆对象集合
     */
    List<Restaurant> selectByMany(@Param(value = "restaurName") String restaurName,
        @Param(value = "restaurAddress") String restaurAddress);
}
