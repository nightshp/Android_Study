package com.ecjtu.order.service.impl;

import com.ecjtu.order.bean.Deliver;
import com.ecjtu.order.dao.DeliverDao;
import com.ecjtu.order.service.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc: 配送员信息管理service实现类
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.service.impl
 * ProjectName: order
 * Date: 2019/2/15 21:50
 */
@Service
public class DeliverServiceImpl implements DeliverService
{
    @Autowired
    DeliverDao deliverDao;

    @Override
    public int deleteByPrimaryKey(Integer deliverId)
    {
        return deliverDao.deleteByPrimaryKey(deliverId);
    }

    @Override
    public int insert(Deliver record)
    {
        return deliverDao.insert(record);
    }

    @Override
    public Deliver selectByPrimaryKey(Integer deliverId)
    {
        return deliverDao.selectByPrimaryKey(deliverId);
    }

    @Override
    public List<Deliver> selectAll()
    {
        return deliverDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Deliver record)
    {
        return deliverDao.updateByPrimaryKey(record);
    }
}
