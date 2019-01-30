package com.lunzn.artist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lunzn.artist.controller.req.EditArtistInfosEvt;
import com.lunzn.artist.controller.resp.EditArtistInfosResp;
import com.lunzn.artist.service.ArtistInfosService;

/**
 * 编辑艺人信息action
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月29日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
@RequestMapping("/artistInfo")
public class EditArtistInfosAction
{
    @Autowired
    private ArtistInfosService artistInfosService;
    
    /**
     * 编辑艺人信息
     * @param editEvt 入参
     * @return EditArtistInfosResp
     * @throws Exception 
     * @see [类、类#方法、类#成员]
     */
    @ResponseBody
    @RequestMapping("/editArtistInfos")
    public EditArtistInfosResp editArtistInfos(@RequestBody EditArtistInfosEvt editEvt)
        throws Exception
    {
        
        return artistInfosService.editArtistInfos(editEvt);
        
    }
}
