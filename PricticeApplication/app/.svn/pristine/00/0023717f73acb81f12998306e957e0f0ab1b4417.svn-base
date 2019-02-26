package lunzn.com.pricticeapplication.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.platfrom.sdk.bean.Video;

import java.util.List;

import lunzn.com.pricticeapplication.R;
import lunzn.com.pricticeapplication.adapter.VideoRecommendAdapter;
import lunzn.com.pricticeapplication.base.BaseActivity;
import lunzn.com.pricticeapplication.interfaces.OnItemClickListener;
import lunzn.com.pricticeapplication.util.FocusAnimUtil;

/**
 * Desc: Vitamio框架实现影片播放
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.activity
 * ProjectName: PricticeApplication
 * Date: 2019/1/30 14:48
 */
public class VideoDetailActivity extends BaseActivity implements View.OnClickListener, View.OnFocusChangeListener {

    // 显示图片
    private ImageView mImageView;

    // 显示播放图标
    private ImageView mView;

    // 影片名
    private TextView txtMvName;

    // 分数
    private TextView txtScore;

    // 地区、时间、影片类型
    private TextView txtATT;

    // 演员
    private TextView txtActor;

    // 主演
    private TextView txtDirector;

    // 播放按钮
    private Button btnPlay;

    private FrameLayout mFrameLayout;

    // 相对于自身的移动比例
    private static final Float TO_RATE = 0.5f;

    // 影片位置
    private int position;

    // 影片集合
    private List<Video> videoList;

    // 影片推荐适配器
    private VideoRecommendAdapter mVideoRecommendAdapter;

    private RecyclerView mRecyclerView;

    @Override
    protected int getRootId() {
        return R.layout.activity_video_detail_layout;
    }

    @Override
    protected void initData() {
        String jsonData = getIntent().getStringExtra("videoList");
//        Video video = JSON.parseObject(jsonData, Video.class);
        videoList = JSONArray.parseArray(jsonData,Video.class);
        position = getIntent().getIntExtra("position",0);
    }

    @Override
    protected void initView() {
        mImageView = findViewById(R.id.iv_detail);
        mView = findViewById(R.id.iv_play_icon);
        txtMvName = findViewById(R.id.tv_mvname);
        txtScore = findViewById(R.id.tv_score);
        txtActor = findViewById(R.id.tv_actor);
        txtDirector = findViewById(R.id.tv_director);
        txtATT = findViewById(R.id.tv_area_time_type);
        btnPlay = findViewById(R.id.btn_play);
        mFrameLayout = findViewById(R.id.ll);
        mRecyclerView = findViewById(R.id.rv_recommend);

        setData();
    }

    private void setData() {
        mVideoRecommendAdapter = new VideoRecommendAdapter(this);
        mVideoRecommendAdapter.setData(videoList);
        mVideoRecommendAdapter.setHasStableIds(true);
        mRecyclerView.setAdapter(mVideoRecommendAdapter);
        // 设置布局管理器+
        final GridLayoutManager layout = new GridLayoutManager(this, 6);
        mRecyclerView.setLayoutManager(layout);
        mRecyclerView.setItemViewCacheSize(0);
        // 禁用所有动画
        mRecyclerView.setItemAnimator(null);
    }

    @Override
    protected void initListener() {
        btnPlay.setOnClickListener(this);
        mFrameLayout.setOnClickListener(this);
        mFrameLayout.setOnFocusChangeListener(this);
        showDetail();

        mVideoRecommendAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(List<Video> videoList, int position) {
                Intent intent = new Intent(VideoDetailActivity.this, VideoDetailActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("videoList", JSON.toJSONString(videoList));
                startActivity(intent);
            }
        });
    }

    /**
     * 显示影片详情
     */
    private void showDetail() {

//        String videoPlayUrl = getIntent().getStringExtra("videoPlayUrl");
        String url = videoList.get(position).getImgpath();
        // 添加默认图片
        RequestOptions requestOptions = new RequestOptions().placeholder(R.mipmap.video_classic_movie);
        Glide.with(VideoDetailActivity.this).load(url).apply(requestOptions).into(mImageView);

        txtMvName.setText(videoList.get(position).getMvname());
        txtScore.setText(videoList.get(position).getScore());
        txtATT.setText(videoList.get(position).getArea() + " · " + videoList.get(position).getReleaseTime().substring(0, 4) + " · " + videoList.get(position).getType());
        txtActor.setText("演员: " + videoList.get(position).getActor());
        txtDirector.setText("导演: " + videoList.get(position).getDirector());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_play:
                jumpToPlay();
                break;
            case R.id.ll:
                jumpToPlay();
                break;
            default:

                break;
        }

    }

    /**
     * 跳到播放界面
     */
    private void jumpToPlay() {
        Intent intent = new Intent(this, VideoPlayAcyivity.class);
        startActivity(intent);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            // 获取焦点执行放大操作
            FocusAnimUtil.getFocusAnim(v,TO_RATE);
            mView.setVisibility(View.VISIBLE);
        } else {
            // 失去焦点执行缩小操作
            FocusAnimUtil.looseFocusAnim(v,TO_RATE);
            mView.setVisibility(View.GONE);
        }
    }

}
