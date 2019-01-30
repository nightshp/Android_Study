package com.lunzn.artist.manage.controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lunzn.artist.controller.req.AddArtistInfosEvt;
import com.lunzn.artist.controller.resp.AddArtistInfosResp;
import com.lunzn.artist.manage.controller.service.AddArtistInfosService;

/**
 * 新增艺人信息action
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月22日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
public class AddArtistInfosAction
{
    @Autowired
    private AddArtistInfosService addArtistInfosService;
    
    /**
     * 新增艺人信息
     * @param evt 入参
     * @return AddArtistInfosResp
     * @throws Exception 异常
     * @see [类、类#方法、类#成员]
     */
    @ResponseBody
    @RequestMapping("/addAristInfos")
    public AddArtistInfosResp addArtistInfos(@RequestBody AddArtistInfosEvt evt)
        throws Exception
    {
        
        return addArtistInfosService.addArtistInfos(evt);
    }
}
