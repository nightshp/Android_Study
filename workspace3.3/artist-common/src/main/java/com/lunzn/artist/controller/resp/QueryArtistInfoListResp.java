package com.lunzn.artist.controller.resp;

import java.util.List;

import com.lunzn.artist.message.resp.BaseResponse;
import com.lunzn.artist.model.ArtistInfoListBean;

/**
 * 查询艺人列表信息出参
 * 
 * @author  Administrator
 * @version  [版本号, 2018年10月17日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class QueryArtistInfoListResp extends BaseResponse
{
    /**
     * 艺人列表信息实体
     */
    private List<ArtistInfoListBean> rows;
    
    /**
     * 查询数据总数
     */
    private Integer total;
    
    public List<ArtistInfoListBean> getRows()
    {
        return rows;
    }
    
    public void setRows(List<ArtistInfoListBean> rows)
    {
        this.rows = rows;
    }
    
    public Integer getTotal()
    {
        return total;
    }
    
    public void setTotal(Integer total)
    {
        this.total = total;
    }
    
}
