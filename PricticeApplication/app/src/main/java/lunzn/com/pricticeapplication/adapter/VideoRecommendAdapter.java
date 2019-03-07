package lunzn.com.pricticeapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.platfrom.sdk.bean.Video;

import java.util.List;

import lunzn.com.pricticeapplication.R;
import lunzn.com.pricticeapplication.interfaces.OnItemClickListener;
import lunzn.com.pricticeapplication.util.FocusAnimUtil;

/**
 * Desc: 影片推荐适配器
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.adapter
 * ProjectName: PricticeApplication
 * Date: 2019/2/22 15:13
 */
public class VideoRecommendAdapter extends RecyclerView.Adapter<VideoRecommendAdapter.VHolder> {

    private List<Video> mVideoList;

    private Context mContext;

    private OnItemClickListener mOnItemClickListener;

    private final static String TAG = "VideoAdapter";

    private View mView;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }


    public VideoRecommendAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<Video> videoList) {
        mVideoList = videoList;
        notifyDataSetChanged();
    }

    // 创建布局
    @Override
    public VideoRecommendAdapter.VHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.item_detail_recommend_layout, null);
        return new VideoRecommendAdapter.VHolder(mView);
    }

    // 绑定数据
    @Override
    public void onBindViewHolder(VHolder vHolder, final int position) {
        final Video video = mVideoList.get(position);
        // 添加默认图片
        RequestOptions requestOptions = new RequestOptions().placeholder(R.mipmap.movie_default_icon_comm).dontAnimate();
        vHolder.mTextView.setText(video.getMvname());
        Glide.with(vHolder.mFrameLayout).load(video.getImgpath()).apply(requestOptions).into(vHolder.mImageView);

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(mVideoList, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mVideoList == null ? 0 : mVideoList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class VHolder extends RecyclerView.ViewHolder implements View.OnFocusChangeListener {

        private TextView mTextView;

        private ImageView mImageView;

        private FrameLayout mFrameLayout;

        public VHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_recommend_item);
            mImageView = itemView.findViewById(R.id.iv_recommend_item);
            mFrameLayout = itemView.findViewById(R.id.fl_recommend_item);
            mFrameLayout.setOnFocusChangeListener(this);
        }

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            float toRate = (v.findViewById(R.id.iv_recommend_item).getHeight() * 1.0f / 2) / v.getHeight();
            if (hasFocus) {
                // 获取焦点 执行放大操作
                FocusAnimUtil.getFocusAnim(v, toRate);
                mTextView.setSelected(true);
                mImageView.setSelected(true);
            } else {
                // 失去焦点 执行缩小操作
                FocusAnimUtil.looseFocusAnim(v, toRate);
                mTextView.setSelected(false);
                mImageView.setSelected(false);
            }
        }


    }
}
