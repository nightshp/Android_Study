package com.lunzn.artist.model;

/**
 * 艺人信息列表bean
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年11月2日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ArtistInfoListBean
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
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getArtistCode()
    {
        return artistCode;
    }
    
    public void setArtistCode(String artistCode)
    {
        this.artistCode = artistCode;
    }
    
    public String getHomeTown()
    {
        return homeTown;
    }
    
    public void setHomeTown(String homeTown)
    {
        this.homeTown = homeTown;
    }
    
    public String getAlias()
    {
        return alias;
    }
    
    public void setAlias(String alias)
    {
        this.alias = alias;
    }
    
    public String getForeignName()
    {
        return foreignName;
    }
    
    public void setForeignName(String foreignName)
    {
        this.foreignName = foreignName;
    }
    
    public String getArtistType()
    {
        return artistType;
    }
    
    public void setArtistType(String artistType)
    {
        this.artistType = artistType;
    }
    
    public String getNationAlity()
    {
        return nationAlity;
    }
    
    public void setNationAlity(String nationAlity)
    {
        this.nationAlity = nationAlity;
    }
    
}
