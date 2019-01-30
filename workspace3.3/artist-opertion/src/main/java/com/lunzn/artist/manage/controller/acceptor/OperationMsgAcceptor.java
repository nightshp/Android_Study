package com.lunzn.artist.manage.controller.acceptor;

import com.lunzn.artist.controller.InnerBaseMsgAcceptor;

/**
 * 超级智控管理台请求分发器
 * 
 * @author  longguofei
 * @version  [版本号, 2017年10月23日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class OperationMsgAcceptor extends InnerBaseMsgAcceptor
{
    private String serviceName;
    
    /**
     * 默认构造函数
     */
    public OperationMsgAcceptor()
    {
        register();
    }
    
    /**
     * <默认构造函数>
      * @param serviceName 服务名
     */
    public OperationMsgAcceptor(String serviceName)
    {
        this.serviceName = serviceName;
        register();
    }
    
    private void register()
    {
        //----------------------------模板接口-----------------------
        
        // 查询省份接口
        //        super.registerAction(serviceName + "/province/query.do",
        //            new QueryArtistAction(BusiTypeCode.QUERY_PROVINCE.getBusiTypeName()));
        //        
        //        // 新增省份接口
        //        super.registerAction(serviceName + "/province/add.do",
        //            new AddProvinceAction(BusiTypeCode.ADD_PROVINCE.getBusiTypeName()));
        //        
        //        // 修改省份接口
        //        super.registerAction(serviceName + "/province/edit.do",
        //            new EditProvinceAction(BusiTypeCode.EDIT_PROVINCE.getBusiTypeName()));
        //        
        //        // 删除省份接口
        //        super.registerAction(serviceName + "/province/delete.do",
        //            new DeleteProvinceAction(BusiTypeCode.DEL_PROVINCE.getBusiTypeName()));
        //        
        //        //查询操作日志列表数据
        //        super.registerAction(serviceName + "/log/queryOperatoinLogs.do",
        //            new QueryOperationLogsAction(BusiTypeCode.QUERY_SYS_LOG.getBusiTypeName()));
        //        //查询操作类型字典信息
        //        super.registerAction(serviceName + "/log/queryOperationType.do",
        //            new QueryOperationTypeAction(BusiTypeCode.QUERY_BUSITYPE_DIC.getBusiTypeName()));
        //        
        //        //查询系统用户信息列表数据
        //        super.registerAction(serviceName + "/user/queryUserInfos.do",
        //            new QueryUserInfoAction(BusiTypeCode.QUERY_USERINFO.getBusiTypeName()));
        //       
        //        //文件上传
        //        super.registerAction(serviceName + "/uploadfile.do",
        //            new UploadFileAction(BusiTypeCode.UPLOAD_FILE.getBusiTypeName()));
        //        
    }
}
