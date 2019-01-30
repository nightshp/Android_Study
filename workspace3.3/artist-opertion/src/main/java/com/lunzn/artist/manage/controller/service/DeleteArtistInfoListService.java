package com.lunzn.artist.manage.controller.service;

import org.springframework.stereotype.Service;

import com.lunzn.artist.client.ArtistClient;
import com.lunzn.artist.controller.req.DeleteArtistInfoListEvt;
import com.lunzn.artist.controller.resp.DeleteArtistInfoListResp;
import com.lunzn.artist.system.exception.InnerException;
import com.lunzn.artist.system.exception.ValidateException;
import com.lunzn.artist.validator.Validator;

/**
 * 删除艺人信息服务
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月31日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
public class DeleteArtistInfoListService
{
    
    /**
     * 删除艺人信息
     * @param evt 入参
     * @return DeleteArtistInfoResp 出参
     * @throws InnerException 
     * @throws ValidateException 
     * @throws Exception 异常
     * @see [类、类#方法、类#成员]
     */
    public DeleteArtistInfoListResp deleteArtistInfoList(DeleteArtistInfoListEvt evt)
        throws ValidateException, InnerException, Exception
    
    {
        
        //Validator工具类校验参数
        Validator.getInstance().validate(DeleteArtistInfoListEvt.class, evt);
        
        return ArtistClient.deleteArtistInfoList(evt);
        
    }
    
}
