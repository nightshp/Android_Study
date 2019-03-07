package com.ecjtu.order.dao;

import com.ecjtu.order.bean.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Desc: 菜单Dao
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.dao
 * ProjectName: order
 * Date: 2019/2/15 20:46
 */
@Mapper
public interface MenuDao
{
    /**
     * 根据id删除菜肴
     *
     * @param dishId 菜肴id
     * @return 整数
     */
    int deleteByPrimaryKey(Integer dishId);

    /**
     * 插入菜肴信息
     *
     * @param menu 菜肴对象
     * @return 整数
     */
    int insert(Menu menu);

    /**
     * 根据id查询菜肴
     *
     * @param dishId 菜肴id
     * @return 菜肴对象
     */
    Menu selectByPrimaryKey(Integer dishId);

    /**
     * 查询出所有的菜肴
     *
     * @return 菜肴对象集合
     */
    List<Menu> selectAll();

    /**
     * 更新菜单
     *
     * @param menu 菜肴对象
     * @return 整数
     */
    int updateByPrimaryKey(Menu menu);

    /**
     * 根据restaur_id查出某个餐厅的所有菜肴
     *
     * @param restaurId 餐馆id
     * @return 菜肴对象集合
     */
    List<Menu> selectMenus(@Param(value = "restaurId") Integer restaurId);

    /**
     * 查询出所有restaurant的id
     *
     * @return 餐馆id数组
     */
    int[] selectRestaurId();

    /**
     * 根据菜名和种类实现模糊查询
     *
     * @param dishName  菜肴名称
     * @param dishClass 所属类别
     * @return 菜肴对象集合
     */
    List<Menu> selectByNC(@Param(value = "dishName") String dishName, @Param(value = "dishClass") String dishClass);
}