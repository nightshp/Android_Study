package com.lunzn.artist.dao;

import org.apache.ibatis.annotations.Mapper;

import com.lunzn.artist.controller.req.AddArtistInfosEvt;
import com.lunzn.artist.controller.req.DeleteArtistInfoListEvt;
import com.lunzn.artist.controller.req.EditArtistInfosEvt;
import com.lunzn.artist.model.ArtistInfoBean;

/**
 * 艺人详细信息管理dao
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月15日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Mapper
public interface ArtistInfoDao
{
    /**
     * 新增艺人基本信息
     * @param evt 入参
     * @return 整数
     * @see [类、类#方法、类#成员]
     */
    int insert(AddArtistInfosEvt evt);
    
    /**
     * 删除艺人基本信息
     * @param evt 入参
     * @return 整数
     * @see [类、类#方法、类#成员]
     */
    int delete(DeleteArtistInfoListEvt evt);
    
    /**
     * 更新艺人基本信息
     * @param evt 基本信息对象
     * @return 整数
     * @see [类、类#方法、类#成员]
     */
    int update(EditArtistInfosEvt evt);
    
    /**
     * 检查artistcode是否重复
     * @param artistInfoBean 基本信息对象
     * @return 整数
     * @see [类、类#方法、类#成员]
     */
    int checkArtistCode(ArtistInfoBean artistInfoBean);
    
}
