package lunzn.com.pricticeapplication.biz;

import android.os.Handler;

import com.alibaba.fastjson.JSONArray;
import com.lunzn.tool.log.LogUtil;
import com.platfrom.sdk.bean.VideoDetail;
import com.platfrom.sdk.bean.VideoMini;
import com.platfrom.sdk.param.VideoDetailParam;
import com.platfrom.sdk.param.VideoVolumeParam;
import com.platfrom.sdk.request.video.VideoDetailRequest;
import com.platfrom.sdk.request.video.VideoRecommedRequest;
import com.platfrom.sdk.request.video.VideoVolumeRequest;
import com.platfrom.sdk.response.video.VideoDetailResponse;
import com.platfrom.sdk.response.video.VideoRecommedResponse;
import com.platfrom.sdk.response.video.VideoVolumeResponse;

import java.util.List;

import lunzn.com.pricticeapplication.contants.MessageCodeContants;
import lunzn.com.pricticeapplication.datacache.VideoData;

/**
 * Desc: 获取影片详情业务类
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.biz
 * ProjectName: PricticeApplication
 * Date: 2019/2/25 9:59
 */
public class VideoDetailBiz {
    private final static String TAG = "videolist";

    private Handler mHandler = null;

    public VideoDetailBiz(Handler mHandler) {
        this.mHandler = mHandler;
    }

    /**
     * 获取影片的基本信息
     *
     * @param mvid    影片id
     * @param groupId 类型id
     */
    public void getVideoProperty(final String mvid, final String groupId) {
        ExcutorService.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                VideoDetailParam detailParam = new VideoDetailParam();
                detailParam.setMvid(mvid);
                detailParam.setGroupId(groupId);
                VideoDetailRequest detailRequest = new VideoDetailRequest();
                detailRequest.setData(detailParam);
                VideoDetailResponse response = detailRequest.getResponse();
                if (response != null && response.getCode() == 0) {
                    mHandler.sendEmptyMessage(MessageCodeContants.GET_VIDEO_DETAIL_SUCCESS);
                    VideoDetail mVideoDetail = response.getVideo();
                    VideoData.mVideoDetailMap.put(groupId,mVideoDetail);
                    LogUtil.i(TAG, "mvname:  " + mVideoDetail.getMvname() + ";  introduction:  " + mVideoDetail.getIntroduction());
                } else {
                    mHandler.sendEmptyMessage(MessageCodeContants.GET_VIDEO_DETAIL_FAILED);
                }
            }
        });
    }

    /**
     * 获取影片集数列表
     *
     * @param index   开始请求的集数index
     * @param mvid    影片id
     * @param groupid 类型id
     */
    public void getVideoVolume(String index, final String mvid, final String groupid) {
        ExcutorService.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                VideoVolumeParam volumeParam = new VideoVolumeParam();
                volumeParam.setIndex("0");
                volumeParam.setMvid(mvid);
                volumeParam.setGroupId(groupid);
                VideoVolumeRequest volumeRequest = new VideoVolumeRequest();
                volumeRequest.setData(volumeParam);
                VideoVolumeResponse response = volumeRequest.getResponse();
                if (response != null && response.getCode() == 0) {
                    mHandler.sendEmptyMessage(MessageCodeContants.GET_VIDEO_VOLUME_SUCCESS);
                    JSONArray volumeList = response.getList();
                    LogUtil.i(TAG, "volumeList:  " + volumeList);
                }else {
                    mHandler.sendEmptyMessage(MessageCodeContants.GET_VIDEO_VOLUME_FAILED);
                }
            }
        });
    }

    /**
     * 获取影片的推荐列表信息
     *
     * @param mvid    影片id
     * @param groupId 类型id
     */
    public void getVideoRecommend(final String mvid, final String groupId) {

        ExcutorService.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                VideoDetailParam detailParam = new VideoDetailParam();
                detailParam.setGroupId(groupId);
                detailParam.setMvid(mvid);
                VideoRecommedRequest recommedRequest = new VideoRecommedRequest();
                recommedRequest.setData(detailParam);
                VideoRecommedResponse response = recommedRequest.getResponse();
                if (response != null && response.getCode() == 0) {
                    mHandler.sendEmptyMessage(MessageCodeContants.GET_VIDEO_RECOMMEND_SUCCESS);
                    List<VideoMini> recommendList = response.getList();
                    for (VideoMini video : recommendList) {
                        LogUtil.i(TAG,"recommend item mvname:  " + video.getMvname());
                    }
                }else{
                    mHandler.sendEmptyMessage(MessageCodeContants.GET_VIDEO_RECOMMEND_FAILED);
                }
            }
        });
    }

}
