package lunzn.com.pricticeapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.platfrom.sdk.bean.Video;

import java.util.List;
import java.util.Map;

import lunzn.com.pricticeapplication.R;
import lunzn.com.pricticeapplication.adapter.VideoAdapter;
import lunzn.com.pricticeapplication.biz.VideoListBiz;
import lunzn.com.pricticeapplication.contants.MessageCodeContants;

/**
 * Desc: 加载影片activity
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.activity
 * ProjectName: PricticeApplication
 * Date: 2019/1/29 10:51
 */
public class VideoListActivity extends Activity {

    // 影片加载业务类
    private VideoListBiz mVideoListBiz;

    // 影片类型
    private int contentType;

    private VideoAdapter mAdapter;

    private RecyclerView mRecyclerView;

    private final static String TAG = "video";

    @SuppressWarnings("handlerleak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MessageCodeContants.GET_VIDEO_LIST_SUCCESS:
                    Map<Integer, List<Video>> mVideoListMap = (Map<Integer, List<Video>>) msg.obj;
                    Log.i(TAG, "VideoListMap: " + mVideoListMap);
                    List<Video> mVideoList = mVideoListMap.get(contentType);
                    Log.i(TAG, "VideoList: " + mVideoList);

                    mAdapter.setData(mVideoList);
                    Toast.makeText(VideoListActivity.this, "加载成功", Toast.LENGTH_LONG).show();
                    break;
                case MessageCodeContants.GET_VIDEO_LIST_FAILED:
                    Toast.makeText(VideoListActivity.this, "加载失败", Toast.LENGTH_LONG).show();
                    break;
                default:

                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list_layout);
        initData();
        initView();

    }

    /**
     * 初始化数据
     */
    private void initData() {

        contentType = getIntent().getIntExtra("type", -1);
        mVideoListBiz = new VideoListBiz(mHandler);
        mVideoListBiz.getVideoList(contentType, 0);
    }

    /**
     * 初始化控件
     */
    private void initView() {
        mRecyclerView = findViewById(R.id.rv_video_list);

        mAdapter = new VideoAdapter(this);
        mAdapter.setHasStableIds(true);

        mRecyclerView.setAdapter(mAdapter);
        // 布局管理
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        // 纵向布局
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        // 画横线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        // 默认动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        // 禁用所有动画
//        mRecyclerView.setItemAnimator(null);


    }

}
