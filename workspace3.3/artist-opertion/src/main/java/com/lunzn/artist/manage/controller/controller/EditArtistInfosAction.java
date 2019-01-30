package com.lunzn.artist.manage.controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lunzn.artist.controller.req.EditArtistInfosEvt;
import com.lunzn.artist.controller.resp.EditArtistInfosResp;
import com.lunzn.artist.manage.controller.service.EditArtistInfosService;

/**
 * 编辑艺人信息action
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月29日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
public class EditArtistInfosAction
{
    @Autowired
    private EditArtistInfosService editArtistInfosService;
    
    /**
      * 编辑艺人信息服务
      * @param evt 编辑艺人信息evt
      * @return EditArtistInfoResp
      * @throws Exception 异常
      * @see [类、类#方法、类#成员]
      */
    @ResponseBody
    @RequestMapping("/editArtistInfos")
    public EditArtistInfosResp editArtistInfos(@RequestBody EditArtistInfosEvt evt)
        throws Exception
    {
        
        return editArtistInfosService.editArtistInfos(evt);
    }
    
}
