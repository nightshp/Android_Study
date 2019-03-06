package com.ecjtu.order.dao;

import com.ecjtu.order.bean.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Desc: 管理员Dao
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.dao
 * ProjectName: order
 * Date: 2019/2/15 20:46
 */
@Mapper
public interface AdminDao
{
    /**
     * 根据id删除管理员信息
     *
     * @param adminId 管理员id
     * @return 整数
     */
    int deleteByPrimaryKey(Integer adminId);

    /**
     * 插入管理与信息
     *
     * @param admin 管理员对象
     * @return 整数
     */
    int insert(Admin admin);

    /**
     * 根据id查询管理员信息
     *
     * @param adminId
     * @return
     */
    Admin selectByPrimaryKey(Integer adminId);

    /**
     * 查询所有管理员信息
     *
     * @return 管理员信息对像集合
     */
    List<Admin> selectAll();

    /**
     * 更新管理员信息
     *
     * @param admin 管理员对象
     * @return 整数
     */
    int updateByPrimaryKey(Admin admin);

    /**
     * 根据用户名和密码查找admin
     *
     * @param adminName     用户名
     * @param adminPassword 密码
     * @return 用户对象
     */
    Admin selectByAP(@Param(value = "adminName") String adminName,
        @Param(value = "adminPassword") String adminPassword);
}
