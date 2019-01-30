package com.lunzn.artist.controller.req;

import com.lunzn.artist.constants.NumberKeys;
import com.lunzn.artist.constants.ParamRegex;
import com.lunzn.artist.controller.BaseQueryEvt;
import com.lunzn.artist.message.annotations.Location;
import com.lunzn.artist.validator.Param;

/**
 *查询艺人信息列表请求参数
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月17日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Location(module = "", uri = "/artistInfo/queryArtistList")
public class QueryArtistInfoListEvt extends BaseQueryEvt
{
    /**
     * 艺人名称
     */
    private String name;
    
    /**
     * 艺术家编号
     */
    private String artistCode;
    
    /**
     * 出生地，归属地
     */
    private String homeTown;
    
    /**
     * 别名
     */
    private String alias;
    
    /**
     * 外文名
     */
    private String foreignName;
    
    /**
     * 职业
     */
    private String artistType;
    
    /**
     * 国籍
     */
    private String nationAlity;
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_128, regex = ParamRegex.NAME_REGEX)
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_64)
    public String getArtistCode()
    {
        return artistCode;
    }
    
    public void setArtistCode(String artistCode)
    {
        this.artistCode = artistCode;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_128)
    public String getHomeTown()
    {
        return homeTown;
    }
    
    public void setHomeTown(String homeTown)
    {
        this.homeTown = homeTown;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_128, regex = ParamRegex.NAME_REGEX)
    public String getAlias()
    {
        return alias;
    }
    
    public void setAlias(String alias)
    {
        this.alias = alias;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_128, regex = ParamRegex.VARCHAR_REGEX)
    public String getForeignName()
    {
        return foreignName;
    }
    
    public void setForeignName(String foreignName)
    {
        this.foreignName = foreignName;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_64)
    public String getArtistType()
    {
        return artistType;
    }
    
    public void setArtistType(String artistType)
    {
        this.artistType = artistType;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_256)
    public String getNationAlity()
    {
        return nationAlity;
    }
    
    public void setNationAlity(String nationAlity)
    {
        this.nationAlity = nationAlity;
    }
    
}
