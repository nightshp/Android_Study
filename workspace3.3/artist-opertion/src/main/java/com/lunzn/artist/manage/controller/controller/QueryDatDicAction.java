package com.lunzn.artist.manage.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lunzn.artist.controller.req.QueryDataDicEvt;
import com.lunzn.artist.controller.resp.QueryDataDicResp;
import com.lunzn.artist.manage.controller.service.QueryDatDicService;

/**
 * 查询字典信息action
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月24日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
public class QueryDatDicAction
{
    /**
     * 查询字典信息
     * @param dictionaryCode 入参
     * @return QueryDataDicResp
     * @throws Exception 异常
     * @see [类、类#方法、类#成员]
     */
    @ResponseBody
    @RequestMapping("/queryDataDic")
    public QueryDataDicResp queryDatDic(@RequestBody String dictionaryCode)
        throws Exception
    {
        
        QueryDataDicEvt evt = new QueryDataDicEvt();
        evt.setDictionaryCode(JSON.parse(dictionaryCode).toString());
        
        QueryDatDicService queryDatDicService = new QueryDatDicService();
        
        return queryDatDicService.queryDataDic(evt);
        
    }
}
