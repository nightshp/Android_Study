package lunzn.com.pricticeapplication.biz;

import android.os.Handler;
import android.os.Message;

import com.alibaba.fastjson.JSON;
import com.lunzn.tool.log.LogUtil;
import com.platfrom.sdk.RequestInit;
import com.platfrom.sdk.bean.Video;
import com.platfrom.sdk.param.VideoDetailParam;
import com.platfrom.sdk.request.video.VideoListRequest;
import com.platfrom.sdk.response.video.VideoListResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lunzn.com.pricticeapplication.contants.MessageCodeContants;


/**
 * Desc: 加载影片列表
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.biz
 * ProjectName: PricticeApplication
 * Date: 2019/1/29 10:12
 */
public class VideoListBiz {

    // 影片列表
    private Map<Integer,List<Video>> mVideoListMap;

    private Handler mHandler;

    private final static String TAG = "video";

    public VideoListBiz(Handler handler) {
        mHandler = handler;
        mVideoListMap = new HashMap<Integer,List<Video>>();
    }

    public Map<Integer, List<Video>> getVideoListMap() {
        return mVideoListMap;
    }

    /**
     * 加载影片列表数据
     * @param type 影片类型
     * @param start 加载的起始位置
     */
    public void getVideoList(final int type, final int start){
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

                LogUtil.i(TAG, "视频 " + JSON.toJSONString(res));

                if (res == null) {
                    LogUtil.e("数据为空");
                    return;
                }


                List<Video> tempList = res.getList();
                if (tempList != null && tempList.size() > 0) {
                    List<Video> videoList = mVideoListMap.get(type);
                    if (videoList == null) {
                        videoList = new ArrayList<Video>();
                    }
                    videoList.addAll(tempList);
                    mVideoListMap.put(type, videoList);

                    Message message = Message.obtain();
                    message.obj = mVideoListMap;
                    message.what = MessageCodeContants.GET_VIDEO_LIST_SUCCESS;
                    mHandler.sendMessage(message);
                } else {
                    mHandler.sendEmptyMessage(MessageCodeContants.GET_VIDEO_LIST_FAILED);
                }
            }
        });
    }
}
