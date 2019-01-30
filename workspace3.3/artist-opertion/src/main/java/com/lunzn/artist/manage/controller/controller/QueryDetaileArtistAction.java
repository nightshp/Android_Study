package com.lunzn.artist.manage.controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lunzn.artist.controller.req.QueryArtistDetaileEvt;
import com.lunzn.artist.controller.resp.QueryArtistDetileResp;
import com.lunzn.artist.manage.controller.service.QueryDetaileArtistService;

/**
 * 查询艺人详细信息action
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月30日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
public class QueryDetaileArtistAction
{
    @Autowired
    private QueryDetaileArtistService queryDetaileArtistService;
    
    /**
     * 查看详细信息
     * @param evt 入参
     * @return QueryArtistInfoListResp
     * @throws Exception 异常
     * @see [类、类#方法、类#成员]
     */
    @ResponseBody
    @RequestMapping("/queryDetaileArtist")
    public QueryArtistDetileResp queryArtistDetile(@RequestBody QueryArtistDetaileEvt evt)
        throws Exception
    {
        
        return queryDetaileArtistService.queryDetaileArtist(evt);
    }
}
