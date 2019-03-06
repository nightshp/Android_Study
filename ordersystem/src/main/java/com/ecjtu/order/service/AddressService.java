package com.ecjtu.order.service;

import com.ecjtu.order.bean.Address;

import java.util.List;

/**
 * Desc: 地址信息管理service
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.service
 * ProjectName: order
 * Date: 2019/2/15 21:27
 */
public interface AddressService
{
    /**
     * 根据id删除地址
     *
     * @param addressId id
     * @return 整数
     */
    int deleteByPrimaryKey(Integer addressId);

    /**
     * 插入地址
     *
     * @param address 地址对象
     * @return 整数
     */
    int insert(Address address);

    /**
     * 根据id查询地址
     *
     * @param addressId 地址id
     * @return 地址对象
     */
    Address selectByPrimaryKey(Integer addressId);

    /**
     * 根据用户id查询所有地址
     *
     * @param userId 用户id
     * @return 地址信息集合
     */
    List<Address> selectAll(Integer userId);

    /**
     * 更新地址
     *
     * @param address 地址对象
     * @return 整数
     */
    int updateByPrimaryKey(Address address);

    /**
     * 根据isdefault设置默认地址：1为默认
     *
     * @param addressId 地址id
     * @param isdefault 是否为默认
     * @return 整数
     */
    int updateDefault(Integer addressId, Integer isdefault);

    /**
     * 查出除默认地址外其他地址
     *
     * @param userId    用户id
     * @param addressId 地址id
     * @return 地址信息集合
     */
    List<Address> selectNotDefault(Integer userId, Integer addressId);

    /**
     * 根据isdefault和userid查出地址信息
     *
     * @param isdefault 是否为默认
     * @param userId    用户id
     * @return 地址对象
     */
    Address selectDefU(Integer isdefault, Integer userId);
}
