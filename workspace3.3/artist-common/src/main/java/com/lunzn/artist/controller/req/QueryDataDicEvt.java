package com.lunzn.artist.controller.req;

import com.lunzn.artist.constants.NumberKeys;
import com.lunzn.artist.message.annotations.Location;
import com.lunzn.artist.message.req.BaseRequestData;
import com.lunzn.artist.validator.Param;

/**
 * 
 * 查询字典请求入参
 * @author  suhongpeng
 * @version  [版本号, 2018年10月23日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Location(module = "", uri = "/dataDic/queryDataDic")
public class QueryDataDicEvt extends BaseRequestData
{
    //字典编码
    private String dictionaryCode;
    
    @Param(canBlank = false, maxLength = NumberKeys.NUM_64)
    public String getDictionaryCode()
    {
        return dictionaryCode;
    }
    
    public void setDictionaryCode(String dictionaryCode)
    {
        this.dictionaryCode = dictionaryCode;
    }
}
