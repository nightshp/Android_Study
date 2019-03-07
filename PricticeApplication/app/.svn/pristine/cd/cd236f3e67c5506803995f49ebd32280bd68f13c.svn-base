package lunzn.com.pricticeapplication.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.platfrom.sdk.bean.Video;

import lunzn.com.pricticeapplication.R;
import lunzn.com.pricticeapplication.base.BaseActivity;
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

    private LinearLayout mLinearLayout;

    // 相对于自身的移动比例
    private static final Float TO_RATE = 0.5f;

    @Override
    protected int getRootId() {
        return R.layout.activity_video_detail_layout;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mImageView = findViewById(R.id.iv_detail);
        txtMvName = findViewById(R.id.tv_mvname);
        txtScore = findViewById(R.id.tv_score);
        txtActor = findViewById(R.id.tv_actor);
        txtDirector = findViewById(R.id.tv_director);
        txtATT = findViewById(R.id.tv_area_time_type);
        btnPlay = findViewById(R.id.btn_play);
        mLinearLayout = findViewById(R.id.ll);
    }

    @Override
    protected void initListener() {
        btnPlay.setOnClickListener(this);
        mLinearLayout.setOnFocusChangeListener(this);
        showDetail();
    }

    /**
     * 显示影片详情
     */
    private void showDetail() {
        String jsonData = getIntent().getStringExtra("video");
        Video video = JSON.parseObject(jsonData, Video.class);
//        String videoPlayUrl = getIntent().getStringExtra("videoPlayUrl");
        String url = video.getImgpath();
        // 添加默认图片
        RequestOptions requestOptions = new RequestOptions().placeholder(R.mipmap.video_classic_movie);
        Glide.with(VideoDetailActivity.this).load(url).apply(requestOptions).into(mImageView);

        txtMvName.setText(video.getMvname());
        txtScore.setText(video.getScore());
        txtATT.setText(video.getArea() + " · " + video.getReleaseTime().substring(0, 4) + " · " + video.getType());
        txtActor.setText("演员: " + video.getActor());
        txtDirector.setText("导演: " + video.getDirector());
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, VideoPlayAcyivity.class);
        startActivity(intent);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            // 获取焦点执行放大操作
            FocusAnimUtil.getFocusAnim(v,TO_RATE);
        } else {
            // 失去焦点执行缩小操作
            FocusAnimUtil.looseFocusAnim(v,TO_RATE);
        }
    }

}
