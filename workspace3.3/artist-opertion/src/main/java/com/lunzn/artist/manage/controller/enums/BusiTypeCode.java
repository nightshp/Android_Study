package com.lunzn.artist.manage.controller.enums;

/**
 * 操作类型交易码
 * <功能详细描述>
 * 
 * @author  yangshu
 * @version  [版本号, 2017年11月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public enum BusiTypeCode
{
    
    /**
     * 未知业务
     */
    UNKONW("未知", "-1", false),
    /**
     *  查询所有菜单
     */
    QUERY_ALL_MENU("查询所有菜单", "127", false),
    
    /**
     *  查询系统日志
     */
    QUERY_SYS_LOG("查询系统日志", "126", false),
    
    /**
     * 修改菜单权限
     */
    MODIFY_MENU("修改菜单权限", "125", true),
    /**
     * 查询菜单
     */
    QUERY_MENU("查询菜单", "124", false),
    /**
     * sp查询接口
     */
    QUERY_SP("sp查询", "123", false),
    /**
     * STB查询接口
     */
    QUERY_STB("STB查询", "122", false),
    /**
     *  查询渠道接口
     */
    QUERY_CHANNEL_SP("查询频道数据", "121", false),
    /**
     *  查询省份
     */
    QUERY_PROVINCE("查询省份", "120", false),
    /**
     * 新增省份
     */
    ADD_PROVINCE("新增省份", "119", true),
    /**
     * 编辑省份
     */
    EDIT_PROVINCE("编辑省份", "118", true),
    /**
     * 删除省份
     */
    DEL_PROVINCE("删除省份", "117", true),
    /**
     * 查询城市
     */
    QUERY_CITY("查询城市", "116", false),
    /**
     * 查询城市名称
     */
    QUERY_CITY_NAME("查询城市名称", "115", false),
    /**
     * 新增城市
     */
    ADD_CITY("新增城市", "114", true),
    /**
     * 编辑城市
     */
    EDIT_CITY("编辑城市", "113", true),
    /**
     * 删除城市
     */
    DEL_CITY("删除城市", "112", true),
    /**
     * 查询操作业务类型
     */
    QUERY_BUSITYPE_DIC("查询操作业务类型", "111", false),
    /**
     * "查询系统用户信息列表"
     */
    QUERY_USERINFO("查询系统用户信息列表", "110", false),
    /**
     * 品牌列表查询
     */
    QUERY_VENDOR("品牌列表查询", "109", false),
    /**
     * 新增品牌
     */
    ADD_VENDOR("新增品牌", "108", true),
    /**
     * 删除品牌
     */
    DEL_VENDOR("删除品牌", "107", true),
    /**
     * 修改品牌
     */
    UPDATE_VENDOR("修改品牌", "106", true),
    /**
     * 红外类型查询
     */
    QUERY_IRCODE_TYPE("红外类型查询", "105", false),
    /**
     * 终端类型查询
     */
    QUERY_DEVICE_TYPE("终端类型查询", "104", false),
    /**
     * 用户反馈查询
     */
    QUERY_FEEDBACK("用户反馈查询", "103", false),
    /**
     * 新增用户反馈
     */
    ADD_FEEDBACK("新增用户反馈", "102", true),
    /**
     * 删除用户反馈
     */
    DEL_FEEDBACK("删除用户反馈", "101", true),
    /**
     * 编辑用户反馈
     */
    EDIT_FEEDBACK("编辑用户反馈", "100", true),
    /**
     *重置用户密码
     */
    RESET_USER_PWD("重置用户密码", "99", true),
    /**
     * 修改用户密码
     */
    MODIFY_USER_PWD("修改用户密码", "98", true),
    /**
     * 删除用户信息
     */
    DEL_USER_INFO("删除用户信息", "97", true),
    /**
     * 新增城市
     */
    ADD_USER_INFO("新增用户信息", "96", true),
    /**
     * 查询操作员类型
     */
    QUERY_USER_TYPE("查询操作员类型", "95", false),
    /**
     * 修改用户信息
     */
    UPDATE_USER_INFO("修改用户信息", "94", true),
    /**
     * 用户登录
     */
    LOGIN("用户登录", "93", true),
    /**
     * 用户登出
     */
    LOGOUT("用户登出", "92", true),
    /**
     * 查询升级信息
     */
    QUERY_UPGRADE_INFO("查询升级信息", "91", false),
    /**
     *查询频道信息
     */
    QUERY_CHANNEL("查询频道信息", "90", false),
    /**
     * 新增频道
     */
    ADD_CHANNEL("新增频道", "89", true),
    /**
     * 编辑频道
     */
    EDIT_CHANNEL("编辑频道", "88", true),
    /**
     * 删除频道
     */
    DEL_CHANNEL("删除频道", "87", true),
    /**
     * 查询模板数据
     */
    QUERY_MODEL("查询模板数据", "86", false),
    /**
     * 查询城市列表
     */
    QUERY_CLIENT_TYPE("查询渠道列表", "85", false),
    /**
     * 新增渠道信息
     */
    ADD_CLIENT_TYPE("新增渠道信息", "84", true),
    /**
     * 删除渠道信息
     */
    DEL_CLIENT_TYPE("删除渠道信息", "83", true),
    /**
     * 新增红外设备类型
     */
    ADD_IRCODE_TYPE("新增红外设备类型", "82", true),
    /**
     * 编辑红外设备类型
     */
    EDIT_IRCODE_TYPE("编辑红外设备类型", "81", true),
    /**
     * 删除红外设备类型
     */
    DEL_IRCODE_TYPE("删除红外设备类型", "80", true),
    
    /**
     * 新增渠道版本
     */
    ADD_VERSION("新增版本", "79", true),
    /**
     * 文件上传
     */
    UPLOAD_FILE("文件上传", "78", true),
    
    /**
     * 新增运营商基本信息
     */
    ADD_CHANNEL_BASE_SP("新增运营商基本信息", "77", true),
    
    /**
     * 编辑运营商基本信息
     */
    EDIT_CHANNEL_BASE_SP("编辑运营商基本信息", "76", true),
    
    /**
     * 删除运营商
     */
    DEL_CHANNEL_BASE_SP("删除运营商", "75", true),
    /**
     * 删除版本
     */
    DEL_VERSION("删除版本", "74", true),
    /**
     * 修改版本
     */
    UPDATE_VERSION("修改版本", "73", true),
    
    /**
     * 添加运营商和机顶关联盒信息
     */
    ADD_STB_RELATE_SP("添加运营商和机顶盒关联信息", "72", true),
    
    /**
     * 删除运营商和机顶盒关联信息
     */
    DEL_STB_RELATE_SP("删除运营商和机顶盒关联信息", "71", true),
    
    /**
     * 添加运营商和频道关联信息
     */
    ADD_CHANNEL_RELATE_SP("添加运营商和频道关联信息", "70", true),
    
    /**
     * 添加运营商和机顶关联信息
     */
    DEL_CHANNEL_RELATE_SP("删除运营商和频道关联信息", "69", true),
    
    /**
     * 修改运营商和频道关联信息
     */
    EDIT_CHANNEL_RELATE_SP("修改频道号", "68", true),
    
    /**
     * 刷新运营商
     */
    REFRESH_SP("刷新运营商", "67", true),
    /**
     * 新增终端
     */
    ADD_DEVICE("新增终端", "66", true),
    /**
     * 编辑终端
     */
    EDIT_DEVICE("编辑终端", "65", true),
    /**
     *  删除终端
     */
    DELETE_DEVICE("删除终端", "64", true),
    /**
     *  查询用户反馈跟踪记录
     */
    QUERY_FEEDBACK_LOGS("查询用户反馈跟踪记录", "63", false),
    /**
     *  查询用户反馈附件详情
     */
    QUERY_FEEDBACK_PLUS("查询用户反馈附件详情", "62", false),
    
    /**
     * 编辑渠道
     */
    EDIT_CLIENT_TYPE("编辑渠道", "61", true);
    
    /**
     * 接口业务类型名称
     */
    private final String busiTypeName;
    
    /**
     * 接口业务类型
     */
    private final String busiType;
    
    /**
     * 该操作是否记录DB日志 true:记录，FALSE:不记录
     */
    private boolean falg;
    
    /**
     * <默认构造函数>
      * @param resultCode 错误码
      * @param resultMsg 错误消息
      * @param flag 该操作是否记录DB日志
     */
    BusiTypeCode(String busiTypeName, String busiType, boolean flag)
    {
        this.busiType = busiType;
        this.busiTypeName = busiTypeName;
        this.falg = flag;
    }
    
    /** 
     * 根据名称获取枚举值
     * <功能详细描述>
     * @param busiTypeName 枚举名称
     * @return 枚举对象
     * @see [类、类#方法、类#成员]
     */
    public static BusiTypeCode getBusiTypeCode(String busiTypeName)
    {
        for (BusiTypeCode busiType : BusiTypeCode.values())
        {
            if (busiType.getBusiTypeName().equals(busiTypeName))
            {
                return busiType;
            }
        }
        return null;
    }
    
    /**
     * @return 返回 busiTypeName
     */
    public String getBusiTypeName()
    {
        return busiTypeName;
    }
    
    /**
     * @return 返回 busiType
     */
    public String getBusiType()
    {
        return busiType;
    }
    
    /**
     * @return 返回 falg
     */
    public boolean isFalg()
    {
        return falg;
    }
    
}
