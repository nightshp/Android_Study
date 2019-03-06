package com.ecjtu.order.service.impl;

import com.ecjtu.order.bean.Address;
import com.ecjtu.order.dao.AddressDao;
import com.ecjtu.order.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc: 地址信息管理service实现类
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.service.impl
 * ProjectName: order
 * Date: 2019/2/15 21:46
 */
@Service
public class AddressServiceImpl implements AddressService
{
    @Autowired
    AddressDao addressDao;

    @Override
    public int deleteByPrimaryKey(Integer addressId)
    {
        return addressDao.deleteByPrimaryKey(addressId);
    }

    @Override
    public int insert(Address address)
    {
        return addressDao.insert(address);
    }

    @Override
    public Address selectByPrimaryKey(Integer addressId)
    {
        return addressDao.selectByPrimaryKey(addressId);
    }

    @Override
    public List<Address> selectAll(Integer userId)
    {
        return addressDao.selectAll(userId);
    }

    @Override
    public int updateByPrimaryKey(Address address)
    {
        return addressDao.updateByPrimaryKey(address);
    }

    @Override
    public int updateDefault(Integer addressId, Integer isdefault)
    {
        return addressDao.updateDefault(addressId, isdefault);
    }

    @Override
    public List<Address> selectNotDefault(Integer userId, Integer addressId)
    {
        return addressDao.selectNotDefault(userId, addressId);
    }

    @Override
    public Address selectDefU(Integer isdefault, Integer userId)
    {
        return addressDao.selectDefU(isdefault, userId);
    }
}
