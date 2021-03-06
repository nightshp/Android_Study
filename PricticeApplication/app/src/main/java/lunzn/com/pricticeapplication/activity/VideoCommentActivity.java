package lunzn.com.pricticeapplication.activity;

import android.content.Intent;
import android.view.Gravity;
import android.widget.TextView;

import lunzn.com.pricticeapplication.R;
import lunzn.com.pricticeapplication.base.BaseActivity;

/**
 * Desc: 影片评论activity
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.activity
 * ProjectName: PricticeApplication
 * Date: 2019/3/6 11:29
 */
public class VideoCommentActivity extends BaseActivity {

    // 影片标题
    private TextView txtTitle;

    // 影片评论
    private TextView txtComment;

    private String mvName;

    private String mvComment;

    @Override
    protected int getRootId() {
        return R.layout.activity_video_comment_layout;
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        mvName = intent.getStringExtra("videoTitle");
        mvComment = intent.getStringExtra("videoComment");
    }

    @Override
    protected void initView() {
        txtTitle = findViewById(R.id.tv_comment_title);
        txtComment = findViewById(R.id.tv_comment_content);
        txtTitle.setText(mvName);
        txtComment.setGravity(Gravity.CENTER);
        txtComment.setTextSize(30);
        txtComment.setText("暂无评论");
    }

    @Override
    protected void initListener() {
      
    }


}
