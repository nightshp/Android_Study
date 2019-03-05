package lunzn.com.pricticeapplication.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

import com.lunzn.tool.log.LogUtil;
import com.platfrom.sdk.bean.Video;

import java.util.List;
import java.util.Map;

import lunzn.com.pricticeapplication.R;
import lunzn.com.pricticeapplication.adapter.VideoAdapter;
import lunzn.com.pricticeapplication.base.BaseActivity;
import lunzn.com.pricticeapplication.biz.VideoListBiz;
import lunzn.com.pricticeapplication.contants.ContentType;
import lunzn.com.pricticeapplication.contants.MessageCodeContants;
import lunzn.com.pricticeapplication.datacache.VideoData;
import lunzn.com.pricticeapplication.interfaces.OnItemClickListener;
import lunzn.com.pricticeapplication.interfaces.ProloadData;

/**
 * Desc: 加载影片activity
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.activity
 * ProjectName: PricticeApplication
 * Date: 2019/1/29 10:51
 */
public class VideoListActivity extends BaseActivity {

    // 影片加载业务类
    private VideoListBiz mVideoListBiz;

    // 影片类型
    private int contentType;

    private TextView mTextView;

    private VideoAdapter mAdapter;

    private RecyclerView mRecyclerView;

    private final static String TAG = "video";

    // 上次按键的键值
    private int lastKeyCode = -1;

    // 上次按上下键的时间
    private long lastPressedTime;

    @SuppressWarnings("handlerleak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MessageCodeContants.GET_VIDEO_LIST_SUCCESS:
                    Map<Integer, List<Video>> mVideoListMap = VideoData.mVideoDataMap;
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
    protected int getRootId() {
        return R.layout.activity_video_list_layout;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        contentType = getIntent().getIntExtra("type", -1);
        mVideoListBiz = new VideoListBiz(mHandler);
        mVideoListBiz.getVideoList(contentType, 0);
    }

    /**
     * 初始化UI
     */
    @Override
    protected void initView() {
        mRecyclerView = findViewById(R.id.rv_video_list);
        mTextView = findViewById(R.id.tv_title);
        setTitle();

        mAdapter = new VideoAdapter(this);
        mAdapter.setHasStableIds(true);
        mRecyclerView.setAdapter(mAdapter);
//        // 布局管理
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        // 设置布局管理器+
        final GridLayoutManager layout = new GridLayoutManager(this, 5);
        mRecyclerView.setLayoutManager(layout);
        // 纵向布局
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        // 画横线
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, GridLayoutManager.VERTICAL));
        // 默认动画
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置recyclerview管理的缓存view数量
        mRecyclerView.setItemViewCacheSize(0);
        // 禁用所有动画
        mRecyclerView.setItemAnimator(null);

        loadData();
    }

    private void loadData() {
        mAdapter.setProloadData(new ProloadData() {
            @Override
            public void proLoadData(int index) {
                int start = VideoData.mVideoDataMap.get(contentType).size();
                LogUtil.i(TAG, "index:  " + index + ";  size:  " + start);
                if (index + 10 > start) {
                    int count = VideoData.mVideoCountsMap.get(contentType);
                    if (start < count && !VideoData.isLoading) {
                        mVideoListBiz.getVideoList(contentType, start);
                    }
                }
            }
        });
    }

    /**
     * 设置TextView内容
     */
    private void setTitle() {
        switch (contentType) {
            case ContentType.PAGE_CONTENT_MOVIE:
                mTextView.setText("电影");
                break;
            case ContentType.PAGE_CONTENT_TV:
                mTextView.setText("电视剧");
                break;
            case ContentType.PAGE_CONTENT_VARIETY:
                mTextView.setText("综艺");
                break;
            default:
                break;
        }
    }

    /**
     * 初始化监听
     */
    @Override
    protected void initListener() {
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(List<Video> videoList, int position) {
                Intent intent = new Intent(VideoListActivity.this, VideosDetailActivity.class);
                Video currentVideo = VideoData.mVideoDataMap.get(contentType).get(position);
                intent.putExtra("mvid", currentVideo.getMvid());
                intent.putExtra("groupid", currentVideo.getGroupid());
                intent.putExtra("position",position);
                intent.putExtra("contentType",contentType);
//                intent.putExtra("videoList", JSON.toJSONString(videoList));
                startActivity(intent);
            }
        });
    }

    /**
     * 按键分发事件
     *
     * @param event 按键事件
     * @return 是否分发
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        // 是否需要拦截
        boolean needIntercept = false;
        // 按下按键
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            // 向下按
            if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_DOWN) {
                if (lastKeyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
                    // 向下按的时间小于450ms进行拦截
                    if (System.currentTimeMillis() - lastPressedTime < 450) {
                        needIntercept = true;
                    } else {
                        lastPressedTime = System.currentTimeMillis();
                    }
                }

            } else if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_UP) {
                if (lastKeyCode == KeyEvent.KEYCODE_DPAD_UP) {
                    // 向上按的时间小于450ms进行拦截
                    if (System.currentTimeMillis() - lastPressedTime < 450) {
                        needIntercept = true;
                    } else {
                        lastPressedTime = System.currentTimeMillis();
                    }
                }
            }
        }
        lastKeyCode = event.getKeyCode();

        return needIntercept || super.dispatchKeyEvent(event);
    }
}
