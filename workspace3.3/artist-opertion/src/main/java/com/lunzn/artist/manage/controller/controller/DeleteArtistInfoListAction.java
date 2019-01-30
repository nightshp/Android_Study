package com.lunzn.artist.manage.controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lunzn.artist.controller.req.DeleteArtistInfoListEvt;
import com.lunzn.artist.controller.resp.DeleteArtistInfoListResp;
import com.lunzn.artist.manage.controller.service.DeleteArtistInfoListService;

/**
 * 删除艺人信息action
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月22日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
public class DeleteArtistInfoListAction
{
    @Autowired
    private DeleteArtistInfoListService deleteArtistInfoListService;
    
    /**
     * 删除艺人列表信息
     * @param evt 删除艺人信息evt入参
     * @return DeleteArtistInfoListResp
     * @throws Exception 异常
     * @see [类、类#方法、类#成员]
     */
    @ResponseBody
    @RequestMapping("/deleteArtistInfoList")
    public DeleteArtistInfoListResp deleteArtistInfoList(@RequestBody DeleteArtistInfoListEvt evt)
        throws Exception
    {
        
        return deleteArtistInfoListService.deleteArtistInfoList(evt);
    }
}
