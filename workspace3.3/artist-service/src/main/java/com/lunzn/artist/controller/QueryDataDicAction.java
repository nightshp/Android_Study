package com.lunzn.artist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lunzn.artist.controller.req.QueryDataDicEvt;
import com.lunzn.artist.controller.resp.QueryDataDicResp;
import com.lunzn.artist.model.DataDicBean;
import com.lunzn.artist.service.DataDicService;

/**
 * 查询字典信息action
 * @author  suhongpeng
 * @version  [版本号, 2018年10月24日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
@RequestMapping("/dataDic")
public class QueryDataDicAction
{
    @Autowired
    private DataDicService dataDicService;
    
    /**
     * 查询字典信息
     * @param dataEvt 入参
     * @return QueryDataDicResp
     * @throws Exception 异常
     * @see [类、类#方法、类#成员]
     */
    @ResponseBody
    @RequestMapping("/queryDataDic")
    public QueryDataDicResp queryDataDic(@RequestBody String dataEvt)
        throws Exception
    {
        
        QueryDataDicResp resp = new QueryDataDicResp();
        //获取字典信息列表
        List<DataDicBean> dataDicBeans = dataDicService
            .queryDataDic(JSONObject.toJavaObject(JSONObject.parseObject(dataEvt), QueryDataDicEvt.class));
        resp.setRows(dataDicBeans);
        
        return resp;
        
    }
}
