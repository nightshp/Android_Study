package lunzn.com.pricticeapplication.activity;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import lunzn.com.pricticeapplication.R;
import lunzn.com.pricticeapplication.adapter.VideoPhotosAdapter;
import lunzn.com.pricticeapplication.base.BaseActivity;

/**
 * Desc: 剧照activity
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.activity
 * ProjectName: PricticeApplication
 * Date: 2019/3/6 10:24
 */
public class VideoPhotosActivity extends BaseActivity {

    // 剧照适配器
    private VideoPhotosAdapter mVideoPhotosAdapter;

    // recyclerview
    private RecyclerView mRecyclerView;

    private TextView mTextView;

    // 图片地址集合
    private String[] imgArray;

    @Override
    protected int getRootId() {
        return R.layout.activity_video_photos_layout;
    }

    @Override
    protected void initData() {
        imgArray = new String[]{"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=368018268,2357972354&fm=26&gp=0.jpg",
                "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1811231234,2430544063&fm=26&gp=0.jpg",
                "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=321064652,4001383061&fm=26&gp=0.jpg",
                "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3455007711,3753031215&fm=26&gp=0.jpg",
                "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1052424559,2237473873&fm=26&gp=0.jpg",
                "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2565773622,551819416&fm=26&gp=0.jpg",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2893039801,1226479020&fm=26&gp=0.jpg",
                "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1188131316,3323481434&fm=26&gp=0.jpg",
                "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1915616776,972347219&fm=26&gp=0.jpg",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2923099592,2587568013&fm=26&gp=0.jpg"
        };
    }

    @Override
    protected void initView() {
        mTextView = findViewById(R.id.tv_photos_item);
        mRecyclerView = findViewById(R.id.rv_video_photos);
        mVideoPhotosAdapter = new VideoPhotosAdapter(this, imgArray);
        mVideoPhotosAdapter.setHasStableIds(true);
        mRecyclerView.setAdapter(mVideoPhotosAdapter);
        // 布局管理
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        // 默认动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置recyclerview管理的缓存view数量
        mRecyclerView.setItemViewCacheSize(0);
    }

    @Override
    protected void initListener() {
        mVideoPhotosAdapter.setPhotoPositionListener(new VideoPhotosAdapter.PhotoPositionListener() {

            @Override
            public void photoPostition(String[] imgArr, int position) {
                mTextView.setText((position + 1) + "/" + imgArr.length + "张");
            }
        });
    }
}
