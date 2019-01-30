package com.lunzn.artist.manage.controller.service;

import org.springframework.stereotype.Service;

import com.lunzn.artist.client.ArtistClient;
import com.lunzn.artist.controller.req.EditArtistInfosEvt;
import com.lunzn.artist.controller.resp.EditArtistInfosResp;
import com.lunzn.artist.system.exception.InnerException;
import com.lunzn.artist.system.exception.ValidateException;
import com.lunzn.artist.validator.Validator;

/**
 * 编辑艺人信息服务
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月31日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
public class EditArtistInfosService
{
    
    /**
     * 编辑艺人信息
     * @param evt 入参
     * @return EditArtistInfoResp 出参
     * @throws InnerException 
     * @throws ValidateException 
     * @throws Exception 异常
     * @see [类、类#方法、类#成员]
     */
    public EditArtistInfosResp editArtistInfos(EditArtistInfosEvt evt)
        throws ValidateException, InnerException, Exception
    
    {
        
        //Validator工具类校验参数
        Validator.getInstance().validate(EditArtistInfosEvt.class, evt);
        
        return ArtistClient.editArtistInfos(evt);
        
    }
}
