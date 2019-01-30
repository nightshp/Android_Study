package com.lunzn.artist.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lunzn.artist.cache.CacheKey;
import com.lunzn.artist.cache.service.RedisService;
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
import com.lunzn.artist.dao.ArtistI18nDao;
import com.lunzn.artist.dao.ArtistInfoDao;
import com.lunzn.artist.dao.ArtistInfosDao;
import com.lunzn.artist.model.ArtistDetaileInfoBean;
import com.lunzn.artist.model.ArtistInfoListBean;
import com.lunzn.artist.service.ArtistInfosService;
import com.lunzn.artist.system.exception.InnerException;
import com.lunzn.artist.system.exception.ValidateException;
import com.lunzn.artist.validator.Validator;

/**
 * 艺人信息服务实现类
 * 
 * @author  Administrator
 * @version  [版本号, 2018年11月5日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
public class ArtistInfosServiceImpl implements ArtistInfosService
{
    /**
     * 日志
     */
    private static Logger logger = Logger.getLogger(ArtistInfosServiceImpl.class);
    
    /**
     * 艺人所有信息dao引用
     */
    @Autowired
    private ArtistInfosDao artistInfosDao;
    
    /**
     * 多语言信息dao引用
     */
    @Autowired
    private ArtistI18nDao artistI18nDao;
    
    /**
     * 基本信息dao引用
     */
    @Autowired
    private ArtistInfoDao artistInfoDao;
    
    /**
     * redis缓存引用
     */
    @Autowired
    private RedisService redisService;
    
    /**
     * 删除艺人列表信息
     * @param evt 入参
     * @return DeleteArtistInfoListResp
     * @throws InnerException 
     * @throws ValidateException 
     * @throws Exception 
     * @see [类、类#方法、类#成员]
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public DeleteArtistInfoListResp deleteArtistInfoList(DeleteArtistInfoListEvt evt)
        throws ValidateException, InnerException, Exception
    
    {
        //Validator工具类校验参数
        Validator.getInstance().validate(DeleteArtistInfoListEvt.class, evt);
        
        String cacheKey = CacheKey.KvMapping.artist_detaileartist.format(evt.getArtistCode());
        
        //删除redis缓存数据
        redisService.del(cacheKey);
        //删除艺人基本信息
        artistInfoDao.delete(evt);
        //删除多语言信息
        artistI18nDao.delete(evt);
        
        return new DeleteArtistInfoListResp();
        
    }
    
    /**
     * 查询艺人列表信息
     * @param evt 入参
     * @return QueryArtistInfoListResp
     * @throws Exception 
     * @throws InnerException 
     * @throws ValidateException 
     * @see [类、类#方法、类#成员]
     */
    @Override
    public QueryArtistInfoListResp queryArtistInfoList(QueryArtistInfoListEvt evt)
        throws ValidateException, InnerException, Exception
    
    {
        //Validator工具类校验参数
        Validator.getInstance().validate(QueryArtistInfoListEvt.class, evt);
        
        QueryArtistInfoListResp resp = new QueryArtistInfoListResp();
        //获取列表信息总数
        int total = artistInfosDao.queryTotal(evt);
        resp.setTotal(total);
        if (total > 0)
        {
            
            List<ArtistInfoListBean> artistInfoListBeans = artistInfosDao.queryArtistInfoList(evt);
            resp.setRows(artistInfoListBeans);
        }
        else
        {
            //没有数据返回空数组
            resp.setRows(new ArrayList<>());
        }
        return resp;
    }
    
    /**
     * 新增艺人信息
     * @param evt
     * @return
     * @throws InnerException 
     * @throws ValidateException 
     * @throws Exception 
     * @see [类、类#方法、类#成员]
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public AddArtistInfosResp addArtistInfos(AddArtistInfosEvt evt)
        throws ValidateException, InnerException, Exception
    
    {
        
        //Validator工具类校验参数
        Validator.getInstance().validate(AddArtistInfosEvt.class, evt);
        
        //新增多语言信息
        artistI18nDao.insert(evt.getArtistI18nBeans());
        //新增艺人基本信息
        artistInfoDao.insert(evt);
        
        String cacheKey = CacheKey.KvMapping.artist_detaileartist.format(evt.getArtistCode());
        
        //加入redis缓存数据
        redisService.set(cacheKey, evt);
        
        return new AddArtistInfosResp();
        
    }
    
    /**
     *查看艺人详细信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param evt 入参
     * @return resp 出参
     * @throws InnerException 
     * @throws ValidateException 
     * @throws Exception 
     * @see [类、类#方法、类#成员]
     */
    @Override
    public QueryArtistDetileResp queryArtistDetaile(QueryArtistDetaileEvt evt)
        throws ValidateException, InnerException, Exception
    
    {
        QueryArtistDetileResp resp = new QueryArtistDetileResp();
        
        //Validator工具类校验参数
        Validator.getInstance().validate(QueryArtistDetaileEvt.class, evt);
        
        String cacheKey = CacheKey.KvMapping.artist_detaileartist.format(evt.getArtistCode());
        //优先从redis中获取
        ArtistDetaileInfoBean artistDetaileInfoBean = redisService.get(cacheKey, ArtistDetaileInfoBean.class);
        
        //如果redis中没有数据，那么从数据库中获取
        if (null == artistDetaileInfoBean)
        {
            artistDetaileInfoBean = artistInfosDao.queryDetaile(evt.getArtistCode());
            
            //将数据再放入redis
            redisService.set(cacheKey, artistDetaileInfoBean);
        }
        resp.setArtistDetaileInfoBean(artistDetaileInfoBean);
        
        return resp;
        
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public EditArtistInfosResp editArtistInfos(EditArtistInfosEvt evt)
        throws ValidateException, InnerException, Exception
    
    {
        
        //Validator工具类校验参数
        Validator.getInstance().validate(EditArtistInfosEvt.class, evt);
        
        //更新艺人基本信息
        artistInfoDao.update(evt);
        //更新多语言信息
        artistI18nDao.update(evt.getArtistI18nBeans());
        
        String cacheKey = CacheKey.KvMapping.artist_detaileartist.format(evt.getArtistCode());
        ArtistDetaileInfoBean artistDetaileInfoBean = redisService.get(cacheKey, ArtistDetaileInfoBean.class);
        //判断redis中有没有数据
        if (null == artistDetaileInfoBean)
        {
            //加入redis缓存数据
            redisService.set(cacheKey, artistDetaileInfoBean);
        }
        else
        {
            //删除redis缓存数据
            redisService.del(cacheKey);
            //加入redis缓存数据
            redisService.set(cacheKey, evt);
        }
        
        return new EditArtistInfosResp();
    }
    
}
