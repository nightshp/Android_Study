package com.lunzn.artist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lunzn.artist.controller.req.QueryDataDicEvt;
import com.lunzn.artist.model.DataDicBean;

/**
 * 字典信息dao
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月15日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Mapper
public interface DataDicDao
{
    /**
     * 查询字典信息
     * @param evt 入参
     * @return 列表信息
     * @see [类、类#方法、类#成员]
     */
    List<DataDicBean> queryDataDic(QueryDataDicEvt evt);
}
