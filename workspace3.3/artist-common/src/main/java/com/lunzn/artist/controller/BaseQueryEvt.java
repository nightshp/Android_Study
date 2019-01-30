package com.lunzn.artist.controller;

import com.lunzn.artist.message.req.BaseRequestData;

/**
 * 要分页面查询请求
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  tianqiuming
 * @version  [版本号, 2017年10月24日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class BaseQueryEvt extends BaseRequestData
{
    private Integer offset;
    
    private Integer pageSize;
    
    public Integer getOffset()
    {
        return offset;
    }
    
    public void setOffset(Integer offset)
    {
        this.offset = offset;
    }
    
    public Integer getPageSize()
    {
        return pageSize;
    }
    
    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }
    
}
