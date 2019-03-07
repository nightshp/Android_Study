package lunzn.com.pricticeapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.platfrom.sdk.bean.Video;

import lunzn.com.pricticeapplication.R;

/**
 * Desc: Vitamio框架实现影片播放
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.activity
 * ProjectName: PricticeApplication
 * Date: 2019/1/30 14:48
 */
public class VideoDetailActivity extends Activity implements View.OnClickListener, View.OnFocusChangeListener {

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

    // 缩放比例
    private static final Float SCALE_RATE = 1.1f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail_layout);
        initView();
    }

    private void initView() {
        mImageView = findViewById(R.id.iv_detail);
        txtMvName = findViewById(R.id.tv_mvname);
        txtScore = findViewById(R.id.tv_score);
        txtActor = findViewById(R.id.tv_actor);
        txtDirector = findViewById(R.id.tv_director);
        txtATT = findViewById(R.id.tv_area_time_type);
        btnPlay = findViewById(R.id.btn_play);
        mLinearLayout = findViewById(R.id.ll);

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
        txtDirector.setText("主演: " + video.getDirector());
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, VideoPlayAcyivity.class);
        startActivity(intent);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            getFocusAnim(v);
        } else {
            looseFocusAnim(v);
        }
    }


    /**
     * 获得焦点时执行放大操作
     *
     * @param view 需要放大的控件
     */
    private void getFocusAnim(View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, SCALE_RATE, 1.0f, SCALE_RATE, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        scaleAnimation.setFillAfter(true);
        view.bringToFront();
        view.startAnimation(scaleAnimation);
    }

    /**
     * 失去焦点时执行缩小操作
     *
     * @param v 需要缩小的控件
     */
    private void looseFocusAnim(View v) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(SCALE_RATE, 1.0f, SCALE_RATE, 1.0f, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        scaleAnimation.setFillAfter(true);
        v.startAnimation(scaleAnimation);
    }

}
