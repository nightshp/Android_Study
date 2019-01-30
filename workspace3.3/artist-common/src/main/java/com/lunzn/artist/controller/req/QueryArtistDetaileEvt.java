package com.lunzn.artist.controller.req;

import com.lunzn.artist.constants.NumberKeys;
import com.lunzn.artist.message.annotations.Location;
import com.lunzn.artist.message.req.BaseRequestData;
import com.lunzn.artist.validator.Param;

/**
 * 查询艺人详细信息入参
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月30日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Location(module = "", uri = "/artistInfo/queryDetaileArtist")
public class QueryArtistDetaileEvt extends BaseRequestData
{
    /**
     * 艺术家编码
     */
    private String artistCode;
    
    @Param(canBlank = false, maxLength = NumberKeys.NUM_64)
    public String getArtistCode()
    {
        return artistCode;
    }
    
    public void setArtistCode(String artistCode)
    {
        this.artistCode = artistCode;
    }
    
}
