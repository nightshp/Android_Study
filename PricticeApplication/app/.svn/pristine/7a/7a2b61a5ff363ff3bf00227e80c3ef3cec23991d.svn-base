package lunzn.com.pricticeapplication.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import lunzn.com.pricticeapplication.R;

/**
 * Desc: Vitamio框架实现影片播放
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.activity
 * ProjectName: PricticeApplication
 * Date: 2019/1/30 14:48
 */
public class VideoPlayActivity extends Activity {

    // 视频播放控件
    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play_layout);
        initView();
        videoPlay();
    }

    private void initView() {
        mVideoView = findViewById(R.id.vv_play);
    }

    /**
     * 视频播放
     */
    public void videoPlay() {
        // 检测vitamio是否解压
        if (!io.vov.vitamio.LibsChecker.checkVitamioLibs(this)) {
            return;
        }
        String videoPlayUrl = getIntent().getStringExtra("videoPlayUrl");
        // 放入网址
        mVideoView.setVideoURI(Uri.parse(videoPlayUrl));
        // 设置控制栏
        mVideoView.setMediaController(new MediaController(this));
        //设置播放画质 高画质
        mVideoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);
        // 获取焦点
        mVideoView.requestFocus();
        // 播放监听
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                // 设置播放速度
                mp.setPlaybackSpeed(1.0f);
            }
        });
    }
}
