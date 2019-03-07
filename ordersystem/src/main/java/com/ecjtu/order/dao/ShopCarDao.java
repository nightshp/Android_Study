package com.ecjtu.order.dao;

import com.ecjtu.order.bean.ShopCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Desc: 购物车Dao
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.dao
 * ProjectName: order
 * Date: 2019/2/15 20:47
 */
@Mapper
public interface ShopCarDao
{
    /**
     * 根据id删除商品信息
     *
     * @param shopcarId 购物车id
     * @return 整数
     */
    int deleteByPrimaryKey(Integer shopcarId);

    /**
     * 插入商品信息
     *
     * @param shopcar 购物车对象
     * @return 整数
     */
    int insert(ShopCar shopcar);

    /**
     * 根据id查询商品信息
     *
     * @param shopcarId 购物车id
     * @return 购物车对象
     */
    ShopCar selectByPrimaryKey(Integer shopcarId);

    /**
     * 查询所有商品
     *
     * @return 商品对象集合
     */
    List<ShopCar> selectAll();

    /**
     * 修改商品信息
     *
     * @param shopcar 商品对象
     * @return 整数
     */
    int updateByPrimaryKey(ShopCar shopcar);

    /**
     * 根据用户id查出购物车信息
     *
     * @param userId 用户id
     * @return 商品对象集合
     */
    List<ShopCar> selectShops(Integer userId);

    /**
     * 计算总价格
     *
     * @param userId 用户id
     * @return 整数
     */
    int calcuPric(@Param(value = "userId") Integer userId);

    /**
     * 根据用户id删除购物车中所有商品
     *
     * @param userId 用户id
     * @return 整数
     */
    int deleteAllShop(@Param(value = "userId") Integer userId);
}