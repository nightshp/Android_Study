package com.lunzn.artist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lunzn.artist.controller.req.QueryArtistDetaileEvt;
import com.lunzn.artist.controller.resp.QueryArtistDetileResp;
import com.lunzn.artist.service.ArtistInfosService;

/**
 * 查询艺人详细信息action
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月30日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
@RequestMapping("/artistInfo")
public class QueryDetaileArtistAction
{
    @Autowired
    private ArtistInfosService artistInfosService;
    
    /**
     * 查看艺术家详细信息
     * @param evt 入参 
     * @return QueryArtistInfoResp  出参
     * @throws Exception 
     * @see [类、类#方法、类#成员]
     */
    @ResponseBody
    @RequestMapping("/queryDetaileArtist")
    public QueryArtistDetileResp queryArtistDetile(@RequestBody QueryArtistDetaileEvt evt)
        throws Exception
    {
        
        return artistInfosService.queryArtistDetaile(evt);
    }
}
