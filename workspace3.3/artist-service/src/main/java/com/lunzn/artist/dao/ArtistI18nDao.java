package com.lunzn.artist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lunzn.artist.controller.req.DeleteArtistInfoListEvt;
import com.lunzn.artist.model.ArtistI18nBean;

/**
 * 多语言信息dao
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月15日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Mapper
public interface ArtistI18nDao
{
    /**
     * 增加多语言信息
     * @param artistI18nBeans 多语言对象
     * @return 整数
     * @see [类、类#方法、类#成员]
     */
    int insert(@Param("artistI18nBeans") List<ArtistI18nBean> artistI18nBeans);
    
    /**
     * 删除多语言信息
     * @param evt 入参
     * @return 整数
     * @see [类、类#方法、类#成员]
     */
    int delete(DeleteArtistInfoListEvt evt);
    
    /**
     * 更新多语言信息
     * @param artistI18nBeans 多语言对象
     * @return 整数
     * @see [类、类#方法、类#成员]
     */
    int update(List<ArtistI18nBean> artistI18nBeans);
    
}
