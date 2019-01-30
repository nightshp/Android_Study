package com.lunzn.artist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lunzn.artist.controller.req.QueryArtistInfoListEvt;
import com.lunzn.artist.model.ArtistDetaileInfoBean;
import com.lunzn.artist.model.ArtistInfoListBean;

/**
 * 艺人信息dao
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月16日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Mapper
public interface ArtistInfosDao
{
    /**
     * 艺术家列表信息数据
     * @param evt 入参
     * @return list 艺人列表数据
     * @see [类、类#方法、类#成员]
     */
    List<ArtistInfoListBean> queryArtistInfoList(QueryArtistInfoListEvt evt);
    
    /**
     * 查看详细信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param artistCode 入参
     * @return list 艺人详情数据
     * @see [类、类#方法、类#成员]
     */
    ArtistDetaileInfoBean queryDetaile(@Param("artistCode") String artistCode);
    
    /**
     * 查询总数
     * @param evt 入参
     * @return total 列表总数
     * @see [类、类#方法、类#成员]
     */
    int queryTotal(QueryArtistInfoListEvt evt);
}
