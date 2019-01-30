package com.lunzn.artist.client;

import com.lunzn.artist.controller.req.AddArtistInfosEvt;
import com.lunzn.artist.controller.req.DeleteArtistInfoListEvt;
import com.lunzn.artist.controller.req.EditArtistInfosEvt;
import com.lunzn.artist.controller.req.QueryArtistDetaileEvt;
import com.lunzn.artist.controller.req.QueryArtistInfoListEvt;
import com.lunzn.artist.controller.resp.AddArtistInfosResp;
import com.lunzn.artist.controller.resp.DeleteArtistInfoListResp;
import com.lunzn.artist.controller.resp.EditArtistInfosResp;
import com.lunzn.artist.controller.resp.QueryArtistDetileResp;
import com.lunzn.artist.controller.resp.QueryArtistInfoListResp;
import com.lunzn.artist.exception.InnerException;

/**
 * 配置数据相关接口
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月18日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public final class ArtistClient extends AbstractContentServiceClient
{
    private ArtistClient()
    {
    }
    
    /**
     * 查询艺术家列表信息
     * <功能详细描述>
     * @param evt 请求体
     * @return QueryArtistInfoResp 响应体 
     * @see [类、类#方法、类#成员]
     */
    public static QueryArtistInfoListResp queryArtistInfos(QueryArtistInfoListEvt evt)
    {
        try
        {
            return send(evt, QueryArtistInfoListResp.class);
        }
        catch (InnerException e)
        {
            QueryArtistInfoListResp resp = new QueryArtistInfoListResp();
            resp.setRetCode(e.getErrorCode());
            resp.setRetMsg(e.getErrorDesc());
            return resp;
        }
    }
    
    /**
     * 查看艺术家详细信息
     * <功能详细描述>
     * @param evt 请求体
     * @return QueryArtistInfoResp 响应体
     * @see [类、类#方法、类#成员]
     */
    public static QueryArtistDetileResp queryArtistDateile(QueryArtistDetaileEvt evt)
    {
        try
        {
            return send(evt, QueryArtistDetileResp.class);
        }
        catch (InnerException e)
        {
            QueryArtistDetileResp resp = new QueryArtistDetileResp();
            resp.setRetCode(e.getErrorCode());
            resp.setRetMsg(e.getErrorDesc());
            return resp;
        }
    }
    
    /**
     * 插入艺人信息
     * @param evt 请求体
     * @return AddArtistInfoResp 响应体
     * @see [类、类#方法、类#成员]
     */
    public static AddArtistInfosResp addArtistInfos(AddArtistInfosEvt evt)
    {
        try
        {
            return send(evt, AddArtistInfosResp.class);
        }
        catch (InnerException e)
        {
            AddArtistInfosResp resp = new AddArtistInfosResp();
            resp.setRetCode(e.getErrorCode());
            resp.setRetMsg(e.getErrorDesc());
            return resp;
        }
    }
    
    /**
     * 删除艺人信息
     * @param evt 请求体
     * @return DeleteArtistInfoResp 响应体
     * @see [类、类#方法、类#成员]
     */
    public static DeleteArtistInfoListResp deleteArtistInfoList(DeleteArtistInfoListEvt evt)
    {
        try
        {
            return send(evt, DeleteArtistInfoListResp.class);
        }
        catch (InnerException e)
        {
            DeleteArtistInfoListResp resp = new DeleteArtistInfoListResp();
            resp.setRetCode(e.getErrorCode());
            resp.setRetMsg(e.getErrorDesc());
            return resp;
        }
    }
    
    /**
     * 更新艺人信息
     * @param evt 请求体
     * @return DeleteArtistInfoResp 响应体
     * @see [类、类#方法、类#成员]
     */
    public static EditArtistInfosResp editArtistInfos(EditArtistInfosEvt evt)
    {
        try
        {
            return send(evt, EditArtistInfosResp.class);
        }
        catch (InnerException e)
        {
            EditArtistInfosResp resp = new EditArtistInfosResp();
            resp.setRetCode(e.getErrorCode());
            resp.setRetMsg(e.getErrorDesc());
            return resp;
        }
    }
}
