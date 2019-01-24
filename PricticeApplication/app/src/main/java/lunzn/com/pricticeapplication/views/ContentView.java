package lunzn.com.pricticeapplication.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import lunzn.com.pricticeapplication.R;
import lunzn.com.pricticeapplication.contants.ContentType;

/**
 * Desc: 主内容view定义
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.views
 * ProjectName: PricticeApplication
 * Date: 2019/1/22 19:15
 */
public class ContentView implements View.OnFocusChangeListener {

    // 上下文
    private Context mContext;

    // 主内容类型
    private int contentType;

    // 根布局
    private ViewGroup rootView;

    // 显示图片内容
    private ImageView ivContent;

    // 边框
    private FocusBoundImageView fbDraw;

    // 缩放比例
    private static final Float SCALE_RATE = 1.1f;

    // 增加长度
    private static final int ADD_LENGTH = 10;

    public ContentView(Context context, int contentType) {
        mContext = context;
        this.contentType = contentType;
        initView();
    }

    /**
     * 获取根布局
     *
     * @return 根布局View
     */
    public View getRootView() {
        return rootView;
    }

    /**
     * 初始化控件
     */
    private void initView() {
        rootView = (FrameLayout) LayoutInflater.from(mContext).inflate(R.layout.page_content_item_layout, null);
        // 获取父布局中第一个布局并设置焦点监听
        rootView.getChildAt(0).setOnFocusChangeListener(this);

        ivContent = rootView.findViewById(R.id.iv_content);
        fbDraw = rootView.findViewById(R.id.iv_draw);

        ivContent.setOnFocusChangeListener(this);
        setContent();
    }

    /**
     * 根据contnetType设置显示内容
     */
    private void setContent() {
        switch (contentType) {
            case ContentType
                    .PAGE_CONTENT_MOVIE:
                ivContent.setImageResource(R.mipmap.video_classic_movie);
                break;
            case ContentType
                    .PAGE_CONTENT_TV:
                ivContent.setImageResource(R.mipmap.video_classic_tv);
                break;
            case ContentType
                    .PAGE_CONTENT_VARIETY:
                ivContent.setImageResource(R.mipmap.video_classic_zongyi);
                break;
            default:

                break;
        }
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        // 绘画边框
        FocusBoundImageView focusBoundImageView = (FocusBoundImageView) fbDraw;
        if (hasFocus) {
            // 获取父布局参数
            ViewGroup.LayoutParams layoutParams = fbDraw.getLayoutParams();
            layoutParams.width = v.getWidth() + ADD_LENGTH;
            layoutParams.height = v.getHeight() + ADD_LENGTH;
            // 增加宽、高长度并设置进FocusBoundImageView中
            focusBoundImageView.setLayoutParams(layoutParams);
            focusBoundImageView.setVisibility(View.VISIBLE);
            getFocusAnim(v);
        } else {
            focusBoundImageView.setVisibility(View.GONE);
            looseFocusAnim(v);
        }
    }

    /**
     * 获得焦点时执行放大操作
     *
     * @param view 需要放大的控件
     */
    private void getFocusAnim(View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, SCALE_RATE, 1.0f, SCALE_RATE);
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
        ScaleAnimation scaleAnimation = new ScaleAnimation(SCALE_RATE, 1.0f, SCALE_RATE, 1.0f);
        scaleAnimation.setFillAfter(true);
        v.startAnimation(scaleAnimation);
    }


}
