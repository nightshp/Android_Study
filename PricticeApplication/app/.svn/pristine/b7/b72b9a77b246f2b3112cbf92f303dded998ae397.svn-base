package lunzn.com.pricticeapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import lunzn.com.pricticeapplication.R;

/**
 * Desc: 剧照适配器
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.adapter
 * ProjectName: PricticeApplication
 * Date: 2019/3/6 10:04
 */
public class VideoPhotosAdapter extends RecyclerView.Adapter<VideoPhotosAdapter.VH> {

    // 上下文
    private Context mContext;

    // 图片地址集合
    private String[] imgArray;

    // 图片位置监听
    private PhotoPositionListener mPhotoPositionListener;

    public VideoPhotosAdapter(Context context, String[] imgArray) {
        mContext = context;
        this.imgArray = imgArray;
    }

    public void setPhotoPositionListener(PhotoPositionListener photoPositionListener) {
        mPhotoPositionListener = photoPositionListener;
    }

    // 创建布局
    @Override
    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_video_photos_layout, null);
        return new VH(view);
    }

    // 绑定数据
    @Override
    public void onBindViewHolder(VH vh, int i) {
        // 添加默认图片
        RequestOptions requestOptions = new RequestOptions().placeholder(R.mipmap.movie_default_icon_comm).dontAnimate();
        Glide.with(vh.mFrameLayout).load(imgArray[i]).apply(requestOptions).into(vh.mImageView);
        mPhotoPositionListener.photoPostition(imgArray, i);
    }

    @Override
    public int getItemCount() {
        return imgArray.length;
    }

    class VH extends RecyclerView.ViewHolder {

        private FrameLayout mFrameLayout;

        private ImageView mImageView;

        public VH(View itemView) {
            super(itemView);
            mFrameLayout = itemView.findViewById(R.id.fl_video_photos_item);
            mImageView = itemView.findViewById(R.id.iv_photos_item);
        }
    }

    public interface PhotoPositionListener {
        void photoPostition(String[] imgArr, int position);
    }
}
