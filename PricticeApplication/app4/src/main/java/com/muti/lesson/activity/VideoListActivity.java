package com.muti.lesson.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.muti.lesson.R;
import com.muti.lesson.biz.VideoListBiz;
import com.muti.lesson.contants.MessageCodeContansts;

/**
 * Desc: TODO
 * <p> 影片列表页面
 * Author: Liu Zhongzhu
 * PackageName: com.muti.lesson.activity
 * ProjectName: AndroidStudioProjects
 * Date: 2019/1/25 16:06
 */
public class VideoListActivity extends Activity {

    // 获取影片列表数据业务类
    private VideoListBiz mVideoListBiz = null;

    // 影片类型
    private int contentType = -1;


    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MessageCodeContansts
                        .GET_VIDEO_LIST_SUCCESS:
                    Toast.makeText(VideoListActivity.this, "影片加载成功", Toast.LENGTH_LONG).show();
                    break;

                case MessageCodeContansts
                        .GET_VIDEO_LIST_FAILED:
                    Toast.makeText(VideoListActivity.this, "影片加载失败", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list_layout);
        initData();
        mVideoListBiz.getVideoData(contentType, 0);
    }

    private void initData(){
        contentType = getIntent().getIntExtra("type", -1);
        mVideoListBiz = new VideoListBiz(mHandler);
    }
}
