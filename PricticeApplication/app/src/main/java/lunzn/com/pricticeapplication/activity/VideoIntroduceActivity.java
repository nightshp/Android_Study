package lunzn.com.pricticeapplication.activity;

import android.content.Intent;
import android.widget.TextView;

import lunzn.com.pricticeapplication.R;
import lunzn.com.pricticeapplication.base.BaseActivity;

/**
 * Desc: 影片介绍activity
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.activity
 * ProjectName: PricticeApplication
 * Date: 2019/2/25 14:47
 */
public class VideoIntroduceActivity extends BaseActivity {

    // 影片标题
    private TextView txtTitle;

    // 影片介绍
    private TextView txtIntroduce;

    private String mvName;

    private String mvIntroduce;

    @Override
    protected int getRootId() {
        return R.layout.activity_video_introduce_layout;
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        mvName = intent.getStringExtra("videoTitle");
        mvIntroduce = intent.getStringExtra("videoIntroduce");
    }

    @Override
    protected void initView() {
        txtTitle = findViewById(R.id.tv_introduce_title);
        txtIntroduce = findViewById(R.id.tv_introduce_content);
        txtTitle.setText("影片介绍：" + mvName);
        txtIntroduce.setText(mvIntroduce);
    }

    @Override
    protected void initListener() {

    }
}
