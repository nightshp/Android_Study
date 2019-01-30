package com.lunzn.artist.model;

import java.sql.Date;

import com.lunzn.artist.constants.NumberKeys;
import com.lunzn.artist.constants.ParamRegex;
import com.lunzn.artist.message.req.IMsgRequestData;
import com.lunzn.artist.validator.Param;

/**
 * 
 * 艺人基本信息bean
 * @author  suhongpeng
 * @version  [版本号, 2018年10月12日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ArtistInfoBean implements IMsgRequestData
{
    
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
    
    @Param(canBlank = false, maxLength = NumberKeys.NUM_64)
    public String getArtistCode()
    {
        return artistCode;
    }
    
    public void setArtistCode(String artistCode)
    {
        this.artistCode = artistCode;
    }
    
    @Param(canBlank = true)
    public String getDefaultLanguage()
    {
        return defaultLanguage;
    }
    
    public void setDefaultLanguage(String defaultLanguage)
    {
        this.defaultLanguage = defaultLanguage;
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
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_8)
    public String getSex()
    {
        return sex;
    }
    
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_14)
    public String getBirthday()
    {
        return birthday;
    }
    
    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
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
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_10)
    public String getBloodGroup()
    {
        return bloodGroup;
    }
    
    public void setBloodGroup(String bloodGroup)
    {
        this.bloodGroup = bloodGroup;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_10)
    public String getConstellation()
    {
        return constellation;
    }
    
    public void setConstellation(String constellation)
    {
        this.constellation = constellation;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_1000, regex = ParamRegex.DIGIT)
    public Integer getHeight()
    {
        return height;
    }
    
    public void setHeight(Integer height)
    {
        this.height = height;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_1000, regex = ParamRegex.DIGIT)
    public Integer getWeight()
    {
        return weight;
    }
    
    public void setWeight(Integer weight)
    {
        this.weight = weight;
    }
    
    @Param(canBlank = true)
    public Integer getIsTeam()
    {
        return isTeam;
    }
    
    public void setIsTeam(Integer isTeam)
    {
        this.isTeam = isTeam;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_128)
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_128)
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_128)
    public String getSearchName()
    {
        return searchName;
    }
    
    public void setSearchName(String searchName)
    {
        this.searchName = searchName;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_256)
    public String getZone()
    {
        return zone;
    }
    
    public void setZone(String zone)
    {
        this.zone = zone;
    }
    
    @Param(canBlank = true)
    public String getFirstLetter()
    {
        return firstLetter;
    }
    
    public void setFirstLetter(String firstLetter)
    {
        this.firstLetter = firstLetter;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_128)
    public String getCompanyName()
    {
        return companyName;
    }
    
    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_14)
    public String getBuildTime()
    {
        return buildTime;
    }
    
    public void setBuildTime(String buildTime)
    {
        this.buildTime = buildTime;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_14)
    public String getJoinInTime()
    {
        return joinInTime;
    }
    
    public void setJoinInTime(String joinInTime)
    {
        this.joinInTime = joinInTime;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_128)
    public String getEducation()
    {
        return education;
    }
    
    public void setEducation(String education)
    {
        this.education = education;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_256)
    public String getFavorite()
    {
        return favorite;
    }
    
    public void setFavorite(String favorite)
    {
        this.favorite = favorite;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_256)
    public String getMotherTongue()
    {
        return motherTongue;
    }
    
    public void setMotherTongue(String motherTongue)
    {
        this.motherTongue = motherTongue;
    }
    
    @Param(canBlank = true)
    public Integer getMarriage()
    {
        return marriage;
    }
    
    public void setMarriage(Integer marriage)
    {
        this.marriage = marriage;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_16)
    public String getOperationStatus()
    {
        return operationStatus;
    }
    
    public void setOperationStatus(String operationStatus)
    {
        this.operationStatus = operationStatus;
    }
    
    @Param(canBlank = true)
    public Date getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    
    @Param(canBlank = true)
    public Date getUpdateTime()
    {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }
    
    @Param(canBlank = true, maxLength = NumberKeys.NUM_512)
    public String getHeadIimg()
    {
        return headIimg;
    }
    
    public void setHeadIimg(String headIimg)
    {
        this.headIimg = headIimg;
    }
    
}
