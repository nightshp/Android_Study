package com.lunzn.artist.model;

/**
 * 
 * 字典信息
 * @author  suhongpeng
 * @version  [版本号, 2018年10月12日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class DataDicBean
{
    /**
     * 字典编码
     */
    private String dictionaryCode;
    
    /**
     * 字典名称
     */
    private String dictionaryName;
    
    /**
     * 字典项编码
     */
    private String dicitemCode;
    
    /**
     * 字典项名称（中文）
     */
    private String dicitemNameZh;
    
    /**
     * 字典项名称（英文）
     */
    private String dicitemNameEn;
    
    public String getDictionaryCode()
    {
        return dictionaryCode;
    }
    
    public void setDictionaryCode(String dictionaryCode)
    {
        this.dictionaryCode = dictionaryCode;
    }
    
    public String getDictionaryName()
    {
        return dictionaryName;
    }
    
    public void setDictionaryName(String dictionaryName)
    {
        this.dictionaryName = dictionaryName;
    }
    
    public String getDicitemCode()
    {
        return dicitemCode;
    }
    
    public void setDicitemCode(String dicitemCode)
    {
        this.dicitemCode = dicitemCode;
    }
    
    public String getDicitemNameZh()
    {
        return dicitemNameZh;
    }
    
    public void setDicitemNameZh(String dicitemNameZh)
    {
        this.dicitemNameZh = dicitemNameZh;
    }
    
    public String getDicitemNameEn()
    {
        return dicitemNameEn;
    }
    
    public void setDicitemNameEn(String dicitemNameEn)
    {
        this.dicitemNameEn = dicitemNameEn;
    }
    
}
