package com.lunzn.artist.model;

import java.sql.Date;
import java.util.List;

/**
 * 艺人详细信息bean
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年11月2日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ArtistDetaileInfoBean
{
    /**
     * 多语言信息list
     */
    private List<ArtistI18nBean> artistI18nBeans;
    
    /**
     * 艺术家编码
     */
    private String artistCode;
    
    /**
     * 默认语言信息
     */
    private String defaultLanguage;
    
    /**
     * 职业
     */
    private String artistType;
    
    /**
     * 艺术家性别
     */
    private String sex;
    
    /**
     * 生日
     */
    private String birthday;
    
    /**
     * 国籍
     */
    private String nationAlity;
    
    /**
     * 血型
     */
    private String bloodGroup;
    
    /**
     * 星座
     */
    private String constellation;
    
    /**
     * 身高
     */
    private Integer height;
    
    /**
     * 体重
     */
    private Integer weight;
    
    /**
     * 是否团队组合
     */
    private Integer isTeam;
    
    /**
     * 名 
     */
    private String firstName;
    
    /**
     * 姓
     */
    private String lastName;
    
    /**
     * 艺术家检索名
     */
    private String searchName;
    
    /**
     * 归属地
     */
    private String zone;
    
    /**
     * 艺术家首字母
     */
    private String firstLetter;
    
    /**
     * 姓
     */
    private String lastname;
    
    /**
     * 艺术家所属公司名称
     */
    private String companyName;
    
    /**
     * 艺术家出道时间
     */
    private String buildTime;
    
    /**
     * 艺术家签约公司时间
     */
    private String joinInTime;
    
    /**
     * 教育程度
     */
    private String education;
    
    /**
     * 爱好
     */
    private String favorite;
    
    /**
     * 母语
     */
    private String motherTongue;
    
    /**
     * 婚姻状态
     */
    private Integer marriage;
    
    /**
     * 操作状态
     */
    private String operationStatus;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 最后修改时间
     */
    private Date updateTime;
    
    /**
     * 头像图片地址
     */
    private String headIimg;
    
    public String getArtistCode()
    {
        return artistCode;
    }
    
    public void setArtistCode(String artistCode)
    {
        this.artistCode = artistCode;
    }
    
    public String getDefaultLanguage()
    {
        return defaultLanguage;
    }
    
    public void setDefaultLanguage(String defaultLanguage)
    {
        this.defaultLanguage = defaultLanguage;
    }
    
    public String getArtistType()
    {
        return artistType;
    }
    
    public void setArtistType(String artistType)
    {
        this.artistType = artistType;
    }
    
    public String getSex()
    {
        return sex;
    }
    
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    
    public String getBirthday()
    {
        return birthday;
    }
    
    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }
    
    public String getNationAlity()
    {
        return nationAlity;
    }
    
    public void setNationAlity(String nationAlity)
    {
        this.nationAlity = nationAlity;
    }
    
    public String getBloodGroup()
    {
        return bloodGroup;
    }
    
    public void setBloodGroup(String bloodGroup)
    {
        this.bloodGroup = bloodGroup;
    }
    
    public String getConstellation()
    {
        return constellation;
    }
    
    public void setConstellation(String constellation)
    {
        this.constellation = constellation;
    }
    
    public Integer getHeight()
    {
        return height;
    }
    
    public void setHeight(Integer height)
    {
        this.height = height;
    }
    
    public Integer getWeight()
    {
        return weight;
    }
    
    public void setWeight(Integer weight)
    {
        this.weight = weight;
    }
    
    public Integer getIsTeam()
    {
        return isTeam;
    }
    
    public void setIsTeam(Integer isTeam)
    {
        this.isTeam = isTeam;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public String getSearchName()
    {
        return searchName;
    }
    
    public void setSearchName(String searchName)
    {
        this.searchName = searchName;
    }
    
    public String getZone()
    {
        return zone;
    }
    
    public void setZone(String zone)
    {
        this.zone = zone;
    }
    
    public String getFirstLetter()
    {
        return firstLetter;
    }
    
    public void setFirstLetter(String firstLetter)
    {
        this.firstLetter = firstLetter;
    }
    
    public String getLastname()
    {
        return lastname;
    }
    
    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }
    
    public String getCompanyName()
    {
        return companyName;
    }
    
    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }
    
    public String getBuildTime()
    {
        return buildTime;
    }
    
    public void setBuildTime(String buildTime)
    {
        this.buildTime = buildTime;
    }
    
    public String getJoinInTime()
    {
        return joinInTime;
    }
    
    public void setJoinInTime(String joinInTime)
    {
        this.joinInTime = joinInTime;
    }
    
    public String getEducation()
    {
        return education;
    }
    
    public void setEducation(String education)
    {
        this.education = education;
    }
    
    public String getFavorite()
    {
        return favorite;
    }
    
    public void setFavorite(String favorite)
    {
        this.favorite = favorite;
    }
    
    public String getMotherTongue()
    {
        return motherTongue;
    }
    
    public void setMotherTongue(String motherTongue)
    {
        this.motherTongue = motherTongue;
    }
    
    public Integer getMarriage()
    {
        return marriage;
    }
    
    public void setMarriage(Integer marriage)
    {
        this.marriage = marriage;
    }
    
    public String getOperationStatus()
    {
        return operationStatus;
    }
    
    public void setOperationStatus(String operationStatus)
    {
        this.operationStatus = operationStatus;
    }
    
    public Date getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    
    public Date getUpdateTime()
    {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }
    
    public String getHeadIimg()
    {
        return headIimg;
    }
    
    public void setHeadIimg(String headIimg)
    {
        this.headIimg = headIimg;
    }
    
    public List<ArtistI18nBean> getArtistI18nBeans()
    {
        return artistI18nBeans;
    }
    
    public void setArtistI18nBeans(List<ArtistI18nBean> artistI18nBeans)
    {
        this.artistI18nBeans = artistI18nBeans;
    }
}
