package com.lunzn.artist.service;

import java.util.List;

import com.lunzn.artist.controller.req.QueryDataDicEvt;
import com.lunzn.artist.model.DataDicBean;

/**
 * 字典信息服务
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月15日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface DataDicService
{
    /**
     * 查询字典信息
     * @param evt 入参
     * @return list 数据
     * @throws Exception 异常
     * @see [类、类#方法、类#成员] 
     */
    public List<DataDicBean> queryDataDic(QueryDataDicEvt evt)
        throws Exception;
}
