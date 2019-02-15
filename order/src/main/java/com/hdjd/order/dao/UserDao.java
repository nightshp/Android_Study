package com.hdjd.order.dao;

import com.hdjd.order.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Desc: TODO
 * <p>
 * Author: suhongpeng
 * PackageName: com.hdjd.order.dao
 * ProjectName: order
 * Date: 2019/2/15 11:24
 */
@Mapper
public interface UserDao
{
    List<User> queryAllUser();
}
