package com.lunzn.artist.controller.resp;

import java.util.List;

import com.lunzn.artist.message.resp.BaseResponse;
import com.lunzn.artist.model.DataDicBean;

/**
 * 查询字典请求出参
 * 
 * @author  Administrator
 * @version  [版本号, 2018年10月23日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class QueryDataDicResp extends BaseResponse
{
    /**
     * 字典信息实体
     */
    private List<DataDicBean> rows;
    
    public List<DataDicBean> getRows()
    {
        return rows;
    }
    
    public void setRows(List<DataDicBean> rows)
    {
        this.rows = rows;
    }
    
}
