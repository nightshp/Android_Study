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
import lunzn.com.pricticeapplication.interfaces.ProloadData;
import lunzn.com.pricticeapplication.util.FocusAnimUtil;
import lunzn.com.pricticeapplication.views.FocusBoundImageView;

/**
 * Desc: 影片列表适配器
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.adapter
 * ProjectName: PricticeApplication
 * Date: 2019/1/29 11:20
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VHolder> {

    private List<Video> mVideoList;

    private Context mContext;

    private OnItemClickListener mOnItemClickListener;

    private ProloadData mProloadData;

    private final static String TAG = "VideoAdapter";

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void setProloadData(ProloadData proloadData) {
        mProloadData = proloadData;
    }

    public VideoAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<Video> videoList) {
        mVideoList = videoList;
        notifyDataSetChanged();
    }

    // 创建布局
    @Override
    public VHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_video_list_layout, null);
        return new VHolder(view);
    }

    // 绑定数据
    @Override
    public void onBindViewHolder(VHolder vHolder, final int position) {
        final Video video = mVideoList.get(position);
        vHolder.frameLayout.setTag(position);
        // 添加默认图片
        RequestOptions requestOptions = new RequestOptions().placeholder(R.mipmap.movie_default_icon_comm).dontAnimate();
        vHolder.mTextView.setText(video.getMvname());
        // 电影
        if ("2".equals(video.getGroupid())) {
            vHolder.mView.setText(video.getMvname());
        } else {
            // 如果当前集数等于最大集数
            if (video.getCurrentVolume() == video.getMaxVolume()) {
                vHolder.mView.setText(video.getMaxVolume() + "集全");
            } else {
                vHolder.mView.setText("更新至" + video.getCurrentVolume() + "集");
            }
        }
        if ("0.0".equals(video.getScore())) {
            vHolder.mTextScore.setVisibility(View.GONE);
        } else {
            vHolder.mTextScore.setText(video.getScore());
        }
        Glide.with(vHolder.frameLayout).load(video.getImgpath()).apply(requestOptions).into(vHolder.mImageView);

        vHolder.frameLayout.setOnClickListener(new View.OnClickListener() {
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

    //    /**
//     * item隐藏时调用(防止内存泄漏)
//     * @param holder VHolder对象
//     */
//    @Override
//    public void onViewRecycled(VHolder holder) {
//        super.onViewRecycled(holder);
//        ImageView imageView = holder.mImageView;
//        if (imageView != null){
//            Glide.with(holder.frameLayout).clear(imageView);
//        }
//    }

    class VHolder extends RecyclerView.ViewHolder implements View.OnFocusChangeListener {

        // 影片名
        private TextView mTextView;

        private TextView mView;

        private TextView mTextScore;

        private ImageView mImageView;

        private FrameLayout frameLayout;


        public VHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_video_list);
            mView = itemView.findViewById(R.id.tv_video_title);
            mTextScore = itemView.findViewById(R.id.tv_video_score);
            mImageView = itemView.findViewById(R.id.iv_video_list);
            frameLayout = itemView.findViewById(R.id.fl_video);
            frameLayout.setOnFocusChangeListener(this);
        }

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            FocusBoundImageView fbiView = (FocusBoundImageView) ((FrameLayout) v).getChildAt(4);
            float toRate = (v.findViewById(R.id.iv_video_list).getHeight() * 1.0f / 2) / v.getHeight();
            if (hasFocus) {
                // 获取焦点
                fbiView.setVisibility(View.VISIBLE);
                mView.setVisibility(View.VISIBLE);
                mTextView.setSelected(true);
                mView.setSelected(true);
                FocusAnimUtil.getFocusAnim(v, toRate);
                int index = (int) v.getTag();
                mProloadData.proLoadData(index);
            } else {
                // 失去焦点
                fbiView.setVisibility(View.GONE);
                mView.setVisibility(View.GONE);
                mTextView.setSelected(false);
                mView.setSelected(false);
                FocusAnimUtil.looseFocusAnim(v, toRate);
            }
        }


    }
}
