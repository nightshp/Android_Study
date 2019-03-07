package com.muti.lesson.biz;

import android.os.Handler;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.muti.lesson.contants.MessageCodeContansts;
import com.platfrom.sdk.RequestInit;
import com.platfrom.sdk.bean.Video;
import com.platfrom.sdk.param.VideoDetailParam;
import com.platfrom.sdk.request.video.VideoListRequest;
import com.platfrom.sdk.response.video.VideoListResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Desc: TODO
 * <p> 加载影片列表数据业务类
 * Author: Liu Zhongzhu
 * PackageName: com.muti.lesson.biz
 * ProjectName: AndroidStudioProjects
 * Date: 2019/1/25 16:29
 */
public class VideoListBiz {

    private final static String TAG = "VideoLesson";

    // 影片列表
    private Map<String, List<Video>> videoData = null;

    private Handler mHandler = null;

    public VideoListBiz(Handler mHandler) {
        videoData = new HashMap<String, List<Video>>();
        this.mHandler = mHandler;
    }

    public Map<String, List<Video>> getVideoData() {
        return videoData;
    }

    /**
     * 加载影片列表数据
     * @param type 影片类型
     * @param start 加载的起始位置
     */
    public void getVideoData(final int type, final int start) {
        ExcutorService.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                RequestInit.setServerIp("http://tv.tviyun.com/pfs/");
                RequestInit.setAppversion("1.837");
                RequestInit.setCompany("XIAOYU");
                RequestInit.setCoversion("W004");
                RequestInit.setOldcompany("XIAOYU");
                RequestInit.setOldcoversion("W004");
                RequestInit.setRealmName("");

                VideoListRequest req = new VideoListRequest();
                VideoDetailParam param = new VideoDetailParam();
                param.setGroupId(type + "");
                param.setStart(start);
                param.setPage(6);
                param.setSize(10);
                req.setData(param);
                VideoListResponse res = req.getResponse();
                List<Video> tempList = res.getList();
                if (tempList != null && tempList.size() > 0) {
                    List<Video> videoList = videoData.get(type);
                    if (videoList == null) {
                        videoList = new ArrayList<Video>();
                    }
                    videoList.addAll(tempList);
                    for (Video v : videoList){
                        Log.i(TAG , "getVideoList:  " + JSON.toJSONString(v));
                    }
                    mHandler.sendEmptyMessage(MessageCodeContansts.GET_VIDEO_LIST_SUCCESS);
                } else {
                    mHandler.sendEmptyMessage(MessageCodeContansts.GET_VIDEO_LIST_FAILED);
                }
            }
        });
    }

}
