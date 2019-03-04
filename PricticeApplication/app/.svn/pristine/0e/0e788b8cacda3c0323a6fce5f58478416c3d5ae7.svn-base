package lunzn.com.pricticeapplication.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.platfrom.sdk.bean.Video;

import java.util.List;

import lunzn.com.pricticeapplication.R;
import lunzn.com.pricticeapplication.interfaces.RefreshRecommendData;
import lunzn.com.pricticeapplication.util.FocusAnimUtil;

/**
 * Desc: 影片推荐列表view
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.views
 * ProjectName: PricticeApplication
 * Date: 2019/3/1 9:18
 */
public class RecommendView implements View.OnClickListener, View.OnFocusChangeListener {
    // 上下文
    private Context mContext;

    // 影片列表数据
    private List<Video> mVideoList;

    private ImageView imageViewRecommend;

    private TextView textViewRecommend;

    // 根布局
    private View rootView;

    // 影片位置
    private int index;

    // 刷新推荐列表接口引用
    private RefreshRecommendData mRecommendData;

    public RecommendView(Context context, List<Video> videoList, int index) {
        mContext = context;
        mVideoList = videoList;
        this.index = index;
        initView();
    }

    public View getRootView() {
        return rootView;
    }

    public void setRecommendData(RefreshRecommendData recommendData) {
        mRecommendData = recommendData;
    }

    /**
     * 初始化UI
     */
    private void initView() {
        rootView = (FrameLayout) LayoutInflater.from(mContext).inflate(R.layout.item_detail_recommend_layout, null);
        imageViewRecommend = rootView.findViewById(R.id.iv_recommend_item);
        textViewRecommend = rootView.findViewById(R.id.tv_recommend_item);
        FrameLayout frameLayout = rootView.findViewById(R.id.fl_recommend_item);
        frameLayout.setOnFocusChangeListener(this);
        frameLayout.setOnClickListener(this);
        setData(frameLayout);
    }

    /**
     * 设置数据
     */
    public void setData(FrameLayout frameLayout) {
        RequestOptions requestOptions = new RequestOptions().placeholder(R.mipmap.movie_default_icon_comm).dontAnimate();
        Video video = mVideoList.get(index);
        Glide.with(frameLayout).load(video.getImgpath()).apply(requestOptions).into(imageViewRecommend);
        textViewRecommend.setText(video.getMvname());
    }

    @Override
    public void onClick(View v) {
        mRecommendData.refreshData(index, mVideoList);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        float toRate = (v.findViewById(R.id.iv_recommend_item).getHeight() * 1.0f / 2) / v.getHeight();
        if (hasFocus) {
            // 获取焦点 执行放大操作
            FocusAnimUtil.getFocusAnim(v, toRate);
            imageViewRecommend.setSelected(true);
            textViewRecommend.setSelected(true);
        } else {
            // 失去焦点 执行缩小操作
            FocusAnimUtil.looseFocusAnim(v, toRate);
            imageViewRecommend.setSelected(false);
            textViewRecommend.setSelected(false);
        }
    }
}
