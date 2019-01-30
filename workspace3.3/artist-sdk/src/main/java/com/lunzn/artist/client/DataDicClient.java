package com.lunzn.artist.client;

import com.lunzn.artist.controller.req.QueryDataDicEvt;
import com.lunzn.artist.controller.resp.QueryDataDicResp;
import com.lunzn.artist.exception.InnerException;

/**
 * 配置数据相关接口
 * @author suhongpeng
 * @version  [版本号, 2018年10月24日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class DataDicClient extends AbstractContentServiceClient
{
    private DataDicClient()
    {
    }
    
    /**
     * 查询字典信息
     * <功能详细描述>
     * @param evt 请求体
     * @return QuerySpArtistListResp 响应体 
     * @see [类、类#方法、类#成员]
     */
    public static QueryDataDicResp queryDataDic(QueryDataDicEvt evt)
    {
        try
        {
            return send(evt, QueryDataDicResp.class);
        }
        catch (InnerException e)
        {
            QueryDataDicResp resp = new QueryDataDicResp();
            resp.setRetCode(e.getErrorCode());
            resp.setRetMsg(e.getErrorDesc());
            return resp;
        }
    }
}
