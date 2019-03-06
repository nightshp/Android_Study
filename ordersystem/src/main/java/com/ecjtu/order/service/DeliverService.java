package com.ecjtu.order.service;

import com.ecjtu.order.bean.Deliver;

import java.util.List;

/**
 * Desc: 配送员service
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.service
 * ProjectName: order
 * Date: 2019/2/15 21:34
 */
public interface DeliverService
{
    /**
     * 根据id删除配送员信息
     *
     * @param deliverId 配送员id
     * @return 整数
     */
    int deleteByPrimaryKey(Integer deliverId);

    /**
     * 插入配送员信息
     *
     * @param record 配送员对象
     * @return 整数
     */
    int insert(Deliver record);

    /**
     * 根据id查询配送员信息
     *
     * @param deliverId 配送员id
     * @return 配送员对象
     */
    Deliver selectByPrimaryKey(Integer deliverId);

    /**
     * 查询所有配送员信息
     *
     * @return 配送员对象集合
     */
    List<Deliver> selectAll();

    /**
     * 更新配送员信息
     *
     * @param record 配送员对象
     * @return 整数
     */
    int updateByPrimaryKey(Deliver record);
}
