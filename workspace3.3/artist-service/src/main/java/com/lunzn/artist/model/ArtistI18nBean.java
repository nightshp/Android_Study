package com.lunzn.artist.model;

/**
 * 
 * 多语言信息
 * @author  suhongpeng
 * @version  [版本号, 2018年10月12日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ArtistI18nBean

{
    
    /**
     * 语言
     */
    private String lang;
    
    /**
     * 艺术家编号
     */
    private String artistCode;
    
    /**
     * 艺术家名称
     */
    private String name;
    
    /**
     * 艺术家简介
     */
    private String des;
    
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
     * 操作状态
     */
    private String operationStatus;
    
    public String getLang()
    {
        return lang;
    }
    
    public void setLang(String lang)
    {
        this.lang = lang;
    }
    
    public String getArtistCode()
    {
        return artistCode;
    }
    
    public void setArtistCode(String artistCode)
    {
        this.artistCode = artistCode;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getDes()
    {
        return des;
    }
    
    public void setDes(String des)
    {
        this.des = des;
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
    
    public String getOperationStatus()
    {
        return operationStatus;
    }
    
    public void setOperationStatus(String operationStatus)
    {
        this.operationStatus = operationStatus;
    }
    
}
