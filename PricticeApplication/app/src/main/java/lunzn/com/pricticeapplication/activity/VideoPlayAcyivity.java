package lunzn.com.pricticeapplication.activity;

import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import lunzn.com.pricticeapplication.R;
import lunzn.com.pricticeapplication.base.BaseActivity;

/**
 * Desc: TODO
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.activity
 * ProjectName: PricticeApplication
 * Date: 2019/1/31 11:16
 */
public class VideoPlayAcyivity extends BaseActivity {

    // 视频播放控件
    private VideoView mVideoView;

    // 显示网速
    private TextView txtNetSpeed;

    // 缓冲百分比
    private TextView txtPercent;

    // 加载进度圈
    private ImageView mImageView;

    // 暂停图标
    private ImageView mImagePause;

    // 开始图标
    private ImageView mImageStart;

    // 快进图标
    private ImageView mImageForward;

    // 快退图标
    private ImageView mImageBack;

    // 视频播放前的背景
    private FrameLayout mFrameLayout;

    // 退出时间
    private long exitTime;

    @Override
    protected int getRootId() {
        return R.layout.activity_video_play_layout;
    }

    @Override
    protected void initData() {

    }

    protected void initView() {
        mVideoView = findViewById(R.id.vv_play);
        txtNetSpeed = findViewById(R.id.tv_net_speed);
        txtPercent = findViewById(R.id.tv_percent);
        mFrameLayout = findViewById(R.id.fl_video_start);
        mImageView = findViewById(R.id.image_progressbar);
        mImageStart = findViewById(R.id.image_start);
        mImagePause = findViewById(R.id.image_pause);
        mImageBack = findViewById(R.id.image_back);
        mImageForward = findViewById(R.id.image_forward);

        videoPlay();
    }

    /**
     * 设置监听
     */
    protected void initListener() {
        //缓存监听，当前缓存了多少,百分比
        mVideoView.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                txtPercent.setText("已缓冲: " + percent + " %");
            }
        });
        // 播放监听
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mFrameLayout.setVisibility(View.GONE);
                // 设置播放速度
                mp.setPlaybackSpeed(1.0f);
                //video状态监听
                mVideoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                    @Override
                    public boolean onInfo(MediaPlayer mp, int what, int extra) {
                        switch (what) {
                            // 开始缓冲
                            case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                                txtNetSpeed.setVisibility(View.VISIBLE);
                                txtPercent.setVisibility(View.VISIBLE);
                                mImageView.setVisibility(View.VISIBLE);
                                // 设置加载圈动画
                                final AnimationDrawable ad = (AnimationDrawable) mImageView.getDrawable();
                                mImageView.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        ad.start();
                                    }
                                }, 100);
                                mp.pause();
                                break;
                            // 缓冲结束
                            case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                                txtNetSpeed.setVisibility(View.GONE);
                                txtPercent.setVisibility(View.GONE);
                                mImageView.setVisibility(View.GONE);
                                mp.start();
                                break;
                            // 正在缓冲
                            case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                                if (extra < 1024) {
                                    txtNetSpeed.setText("当前网速: " + extra + "KB/S");
                                } else {
                                    double speed = extra / ((double) 1024);
                                    // 转化为字符串并截取前三位
                                    String s = (speed + "").substring(0, 3);
                                    txtNetSpeed.setText("当前网速: " + s + "MB/S");
                                }

                                break;
                            default:

                                break;
                        }
                        return true;
                    }
                });
            }
        });


        /**
         * 设置按键监听
         */
        mVideoView.setOnKeyListener(new View.OnKeyListener() {
            /**
             * 点击按键执行该方法
             *
             * @param v       事件源
             * @param keyCode 键码
             * @param event   事件
             * @return false
             */
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    // 快退
                    case KeyEvent.KEYCODE_DPAD_LEFT:
                        if (event.getAction() == KeyEvent.ACTION_DOWN) {
                            mImageBack.setVisibility(View.VISIBLE);
                            long back = mVideoView.getCurrentPosition() - 3 * 1000;
                            mVideoView.seekTo(back);
                        } else {
                            mImageBack.setVisibility(View.GONE);
                        }
                        break;
                    // 快进
                    case KeyEvent.KEYCODE_DPAD_RIGHT:
                        if (event.getAction() == KeyEvent.ACTION_DOWN) {
                            mImageForward.setVisibility(View.VISIBLE);
                            long forward = mVideoView.getCurrentPosition() + 3 * 1000;
                            mVideoView.seekTo(forward);
                        } else {
                            mImageForward.setVisibility(View.GONE);
                        }
                        break;
                    // 播放、暂停
                    case KeyEvent.KEYCODE_DPAD_CENTER:
                        if (event.getAction() == KeyEvent.ACTION_DOWN) {
                            if (mVideoView.isPlaying()) {
                                mVideoView.pause();
                                mImagePause.setVisibility(View.VISIBLE);
                            } else {
                                mImagePause.setVisibility(View.GONE);
                                mVideoView.start();
                            }
                        }
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }


    /**
     * 视频播放
     */
    public void videoPlay() {
        // 检测vitamio是否解压
        if (!io.vov.vitamio.LibsChecker.checkVitamioLibs(this)) {
            return;
        }
        // 放入网址
        mVideoView.setVideoURI(Uri.parse("http://vjs.zencdn.net/v/oceans.mp4 "));
        // 设置控制栏
        mVideoView.setMediaController(new MediaController(this));
        //设置播放画质 高画质
//        mVideoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);
        mVideoView.setVideoQuality(MediaPlayer.VIDEOCHROMA_RGB565);
        // 表示播放为视屏画面原始大小(0原始画面大小1画面全屏2画面拉伸3画面裁剪)，第二个参数表示设置视频的宽高比，0表示自动检测
        mVideoView.setVideoLayout(VideoView.VIDEO_LAYOUT_STRETCH, 0);
        //设置视频缓冲大小。默认1024KB，单位byte
//        mVideoView.setBufferSize(10240);
        // 获取焦点
        mVideoView.requestFocus();

    }

    /**
     * 退出操作
     */
    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - exitTime) < 2000) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_LONG).show();
            exitTime = System.currentTimeMillis();
        }
    }

}
