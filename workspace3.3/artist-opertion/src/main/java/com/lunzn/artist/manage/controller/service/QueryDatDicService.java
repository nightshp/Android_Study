package com.lunzn.artist.manage.controller.service;

import org.springframework.stereotype.Service;

import com.lunzn.artist.client.DataDicClient;
import com.lunzn.artist.controller.req.QueryDataDicEvt;
import com.lunzn.artist.controller.resp.QueryDataDicResp;
import com.lunzn.artist.validator.Validator;

/**
 * 
 * 查询字典信息服务
 * @author  suhongpeng
 * @version  [版本号, 2018年10月31日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
public class QueryDatDicService
{
    
    /**
     * 查询字典信息
     * @param evt 入参
     * @return QueryDataDicResp 出参
     * @throws Exception 异常
     * @see [类、类#方法、类#成员]
     */
    public QueryDataDicResp queryDataDic(QueryDataDicEvt evt)
        throws Exception
    {
        
        //Validator工具类校验参数
        Validator.getInstance().validate(QueryDataDicEvt.class, evt);
        
        return DataDicClient.queryDataDic(evt);
        
    }
}
