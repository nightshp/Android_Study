package com.lunzn.artist.controller.resp;

import com.lunzn.artist.message.resp.BaseResponse;
import com.lunzn.artist.model.ArtistDetaileInfoBean;

/**
 * 查看艺人详细信息出参
 * 
 * @author  Administrator
 * @version  [版本号, 2018年11月5日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class QueryArtistDetileResp extends BaseResponse
{
    /**
     * 详细信息响应实体
     */
    private ArtistDetaileInfoBean artistDetaileInfoBean;
    
    public ArtistDetaileInfoBean getArtistDetaileInfoBean()
    {
        return artistDetaileInfoBean;
    }
    
    public void setArtistDetaileInfoBean(ArtistDetaileInfoBean artistDetaileInfoBean)
    {
        this.artistDetaileInfoBean = artistDetaileInfoBean;
    }
    
}
