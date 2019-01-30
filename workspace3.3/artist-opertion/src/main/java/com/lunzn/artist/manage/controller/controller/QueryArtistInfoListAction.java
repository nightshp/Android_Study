package com.lunzn.artist.manage.controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lunzn.artist.controller.req.QueryArtistInfoListEvt;
import com.lunzn.artist.controller.resp.QueryArtistInfoListResp;
import com.lunzn.artist.manage.controller.service.QueryArtistInfoListService;

/**
 *查询艺人列表信息action
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月18日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
public class QueryArtistInfoListAction
{
    @Autowired
    private QueryArtistInfoListService queryArtistInfoListService;
    
    /**
     * 查询艺人列表信息 
     * @param evt 查询艺人列表evt
     * @return QueryArtistInfoListResp
     * @throws Exception 异常
     * @see [类、类#方法、类#成员]
     */
    @ResponseBody
    @RequestMapping("/queryArtistList")
    public QueryArtistInfoListResp queryArtistInfoList(@RequestBody QueryArtistInfoListEvt evt)
        throws Exception
    {
        
        return queryArtistInfoListService.queryArtistInfo(evt);
    }
}
