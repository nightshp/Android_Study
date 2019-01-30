package com.lunzn.artist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunzn.artist.controller.req.QueryDataDicEvt;
import com.lunzn.artist.dao.DataDicDao;
import com.lunzn.artist.enums.ResultCode;
import com.lunzn.artist.model.DataDicBean;
import com.lunzn.artist.service.DataDicService;
import com.lunzn.artist.system.exception.InnerException;
import com.lunzn.artist.util.StringUtil;

/**
 * 字典信息服务实现类
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月24日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
public class DataDicServiceImpl implements DataDicService
{
    
    @Autowired
    private DataDicDao dataDicDao;
    
    @Override
    public List<DataDicBean> queryDataDic(QueryDataDicEvt evt)
        throws Exception
    {
        if (StringUtil.isEmpty(evt.getDictionaryCode()))
        {
            throw new InnerException(ResultCode.INVALID_PARAM.getResultCode(), ResultCode.INVALID_PARAM.getResultMsg());
        }
        else
        {
            return dataDicDao.queryDataDic(evt);
        }
        
    }
    
}
