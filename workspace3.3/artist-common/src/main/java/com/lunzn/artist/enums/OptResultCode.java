package com.lunzn.artist.enums;

/**
 * 公共返回码
 * <功能详细描述>
 * 
 * @author  longguofei
 * @version  [版本号, 2017年10月19日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public enum OptResultCode
{
    
    /**
     *  序号已经存在
     */
    PROVINCE_ID_EXIST(400001, "省份序号已经存在"),
    
    /**
     *  省份名已经存在
     */
    PROVINCE_NAME_EXIST(400002, "省份名已经存在"),
    
    /**
     *  记录被关联在,不能删除
     */
    RECORD_HAS_BEEN_RELATED(400003, "记录被关联在,不能删除"),
    
    /**
     *  艺人编号已经存在
     */
    ARTIST_CODE_EXIST(400004, "艺人编号已经存在"),
    
    /**
     *  序号已经存在
     */
    CHANNEL_ID_EXIST(400005, "频道序号已经存在"),
    
    /**
     *  省份名已经存在
     */
    CHANNEL_NAME_EXIST(400006, "频道名已经存在"),
    /**
     *  渠道类型已经存在
     */
    CLINET_TYPE_EXIST(400007, "渠道类型已经存在"),
    
    /**
     * 用户名或者密码不正确
     */
    INVALID_USER_PWD(400008, "用户名或者密码不正确"),
    
    /**
     *  红外设备类型已经存在
     */
    IRCODE_TYPE_EXIST(400009, "红外设备类型已经存在"),
    /**
     * 密码错误
     */
    INVALID_PWD(400010, "密码错误"),
    
    /**
     * 运营商名称已经存在
     */
    SP_NAME_EXIST(400011, "运营商名称已经存在"),
    
    /**
     *  品牌名已经存在
     */
    VENDOR_NAME_EXIST(400012, "品牌名已经存在"),
    
    /**
     *  终端名已经存在
     */
    DEVICE_NAME_EXIST(400013, "终端名已经存在"),
    /**
     *  系统账户不容许操作
     */
    ADMIN_ACCT(400014, "系统账户不容许操作"),
    
    /**
     *  文件上传失败
     */
    FILE_UPLOAD_ERROR(400015, "文件上传失败"),
    /**
     *  原始密码错误
     */
    INVALID_PWD_OLD(400016, "原密码错误"),
    /**
     *  超级管理员必须拥有权限管理菜单权限
     */
    INVALID_PERMIMSSION_OPERTION(400017, "超级管理员必须拥有权限管理菜单权限");
    /**
     * 错误码
     */
    private final int resultCode;
    
    /**
     * 错误消息
     */
    private final String resultMsg;
    
    /**
     * <默认构造函数>
      * @param resultCode 错误码
      * @param resultMsg 错误消息
     */
    OptResultCode(int resultCode, String resultMsg)
    {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }
    
    public int getResultCode()
    {
        return this.resultCode;
    }
    
    public String getResultMsg()
    {
        return this.resultMsg;
    }
}
