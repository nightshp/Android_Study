package lunzn.com.pricticeapplication.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.platfrom.sdk.bean.Video;
import com.platfrom.sdk.bean.VideoDetail;

import java.util.List;

import lunzn.com.pricticeapplication.R;
import lunzn.com.pricticeapplication.base.BaseActivity;
import lunzn.com.pricticeapplication.biz.VideoDetailBiz;
import lunzn.com.pricticeapplication.contants.MessageCodeContants;
import lunzn.com.pricticeapplication.datacache.VideoData;
import lunzn.com.pricticeapplication.util.FocusAnimUtil;

/**
 * Desc: 影片列表详情activity
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.activity
 * ProjectName: PricticeApplication
 * Date: 2019/2/25 10:05
 */
public class VideosDetailActivity extends BaseActivity implements View.OnClickListener, View.OnFocusChangeListener {

    // 显示图片
    private ImageView mImageView;

    // 影片名
    private TextView txtMvTitle;

    // 更新至第几集
    private TextView txtVolume;

    // 分数
    private TextView txtScore;

    // 地区、时间、影片类型
    private TextView txtATTL;

    // 演员
    private TextView txtActor;

    // 导演
    private TextView txtDirector;

    // 介绍
    private TextView txtIntroduce;

    private RelativeLayout mRelativeLayout;

    private LinearLayout mLinearLayout;

    // 影片id
    private String mvid = null;

    // 类型id
    private String groupId = null;

    // 获取影片详情业务类
    private VideoDetailBiz mDetailBiz = null;

    private static final String TAG = "videoDetail";

    VideoDetail mVideoDetail = null;

    // 相对于自身的移动比例
    private static final Float TO_RATE = 0.5f;

    // 影片位置
    private int position;

    // 影片集合
    private List<Video> videoList;

    // 推荐列表View
    private View view;

    // 推荐列表图片
    private ImageView imageViewRecommend;

    // 推荐列表影片名
    private TextView textViewRecommend;


    // 影片推荐适配器
//    private VideoRecommendAdapter mVideoRecommendAdapter;

//    private RecyclerView mRecyclerView;


    @SuppressWarnings("handlerleak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MessageCodeContants.GET_VIDEO_DETAIL_SUCCESS:
                    mVideoDetail = VideoData.mVideoDetailMap.get(groupId);
                    RequestOptions requestOptions = new RequestOptions().placeholder(R.mipmap.movie_default_icon_comm).dontAnimate();
                    Glide.with(mRelativeLayout).load(mVideoDetail.getImgpath()).apply(requestOptions).into(mImageView);
                    txtMvTitle.setText(mVideoDetail.getMvname());
                    txtVolume.setText("更新至" + mVideoDetail.getCurrentVolume() + "集");
                    txtScore.setText(mVideoDetail.getScore());
                    txtATTL.setText(mVideoDetail.getType() + " / " + mVideoDetail.getReleaseTime().substring(0, 4) + " / " + mVideoDetail.getLanguage() + " / " + mVideoDetail.getArea());
                    txtDirector.setText("导演：" + mVideoDetail.getDirector());
                    txtActor.setText("演员：" + mVideoDetail.getActor());
                    txtIntroduce.setText("简介：" + mVideoDetail.getIntroduction());
                    break;

                case MessageCodeContants.GET_VIDEO_VOLUME_SUCCESS:
                    mDetailBiz.getVideoRecommend(mvid, groupId);
                    break;
            }
        }
    };

    @Override
    protected int getRootId() {
        return R.layout.activity_videos_detail_layout;
    }

    @Override
    protected void initData() {
        mDetailBiz = new VideoDetailBiz(mHandler);
        Intent intent = getIntent();
        mvid = intent.getStringExtra("mvid");
        groupId = intent.getStringExtra("groupid");
        String jsonData = intent.getStringExtra("videoList");
        videoList = JSONArray.parseArray(jsonData, Video.class);
        mDetailBiz.getVideoProperty(mvid, groupId);
    }

    @Override
    protected void initView() {
        mImageView = findViewById(R.id.iv_detail_image);
        txtMvTitle = findViewById(R.id.tv_detail_title);
        txtVolume = findViewById(R.id.tv_detail_volume);
        txtScore = findViewById(R.id.tv_detail_score);
        txtATTL = findViewById(R.id.tv_area_time_type_language);
        txtActor = findViewById(R.id.tv_actor);
        txtDirector = findViewById(R.id.tv_director);
        txtIntroduce = findViewById(R.id.tv_introduce);
        mRelativeLayout = findViewById(R.id.rl_detail);
        mLinearLayout = findViewById(R.id.ll_video_recommend);
//        mRecyclerView = findViewById(R.id.rv_recommend);

//        setLayout();
        initRecommendView();
    }

    /**
     * 初始化推荐列表UI
     */
    public void initRecommendView() {
        for (int i = 0; i < videoList.size(); i++) {
            view = LayoutInflater.from(VideosDetailActivity.this).inflate(R.layout.item_detail_recommend_layout, null);
            imageViewRecommend = view.findViewById(R.id.iv_recommend_item);
            textViewRecommend = view.findViewById(R.id.tv_recommend_item);
            FrameLayout frameLayout = view.findViewById(R.id.fl_recommend_item);
            RequestOptions requestOptions = new RequestOptions().placeholder(R.mipmap.movie_default_icon_comm).dontAnimate();
            Video video = videoList.get(i);
            Glide.with(frameLayout).load(video.getImgpath()).apply(requestOptions).into(imageViewRecommend);
            textViewRecommend.setText(video.getMvname());
            frameLayout.setOnFocusChangeListener(this);
            frameLayout.setOnClickListener(this);
            mLinearLayout.addView(view);
            frameLayout.setTag(i);
        }

    }

//    private void setLayout() {
//        mVideoRecommendAdapter = new VideoRecommendAdapter(this);
//        mVideoRecommendAdapter.setData(videoList);
//        mVideoRecommendAdapter.setHasStableIds(true);
//        mRecyclerView.setAdapter(mVideoRecommendAdapter);
//        // 设置布局管理器+
//        final LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        mRecyclerView.setLayoutManager(layout);
//        mRecyclerView.setItemViewCacheSize(0);
//        // 禁用所有动画
//        mRecyclerView.setItemAnimator(null);
//    }

    @Override
    protected void initListener() {
        txtIntroduce.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_introduce:
                Intent intent = new Intent(VideosDetailActivity.this, VideoIntroduceActivity.class);
                intent.putExtra("videoTitle", mVideoDetail.getMvname());
                intent.putExtra("videoIntroduce", mVideoDetail.getIntroduction());
                startActivity(intent);
                break;
            case R.id.fl_recommend_item:
                Video video = videoList.get((Integer) v.getTag());
                mDetailBiz.getVideoProperty(video.getMvid(), video.getGroupid());
                break;
            default:

                break;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        float toRate = (v.findViewById(R.id.iv_recommend_item).getHeight() * 1.0f / 2) / v.getHeight();
        if (hasFocus) {
            // 获取焦点 执行放大操作
            FocusAnimUtil.getFocusAnim(v, toRate);
            v.findViewById(R.id.iv_recommend_item).setSelected(true);
            v.findViewById(R.id.tv_recommend_item).setSelected(true);
        } else {
            // 失去焦点 执行缩小操作
            FocusAnimUtil.looseFocusAnim(v, toRate);
            v.findViewById(R.id.iv_recommend_item).setSelected(false);
            v.findViewById(R.id.tv_recommend_item).setSelected(false);
        }
    }
}
