package com.lunzn.artist.service;

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

/**
 * 艺术家信息服务
 * 
 * @author  Administrator
 * @version  [版本号, 2018年11月5日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface ArtistInfosService
{
    /**
     * 删除艺人信息
     * @param evt 删除艺人信息入参
     * @return DeleteArtistInfoListResp
     * @throws Exception 
     * @see [类、类#方法、类#成员]
     */
    DeleteArtistInfoListResp deleteArtistInfoList(DeleteArtistInfoListEvt evt)
        throws Exception;
    
    /**
     * 查询艺人列表数据
     * @param evt 入参
     * @return 列表信息
     * @throws Exception 
     * @see [类、类#方法、类#成员]
     */
    QueryArtistInfoListResp queryArtistInfoList(QueryArtistInfoListEvt evt)
        throws Exception;
    
    /**
     *  艺术家详细信息
     * @param evt 入参
     * @return 艺人详细信息
     * @throws Exception 
     * @see [类、类#方法、类#成员]
     */
    QueryArtistDetileResp queryArtistDetaile(QueryArtistDetaileEvt evt)
        throws Exception;
    
    /**
     * 新增艺人信息
     * @param evt 新增艺人信息入参
     * @return AddArtistInfosResp
     * @throws Exception 
     * @see [类、类#方法、类#成员]
     */
    AddArtistInfosResp addArtistInfos(AddArtistInfosEvt evt)
        throws Exception;
    
    /**
     * 编辑艺人信息
     * @param evt 编辑艺人信息如蚕1
     * @return EditArtistInfosResp
     * @throws Exception 
     * @see [类、类#方法、类#成员]
     */
    EditArtistInfosResp editArtistInfos(EditArtistInfosEvt evt)
        throws Exception;
}
