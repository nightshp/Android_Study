package com.muti.lesson.views;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.muti.lesson.R;
import com.muti.lesson.activity.VideoListActivity;
import com.muti.lesson.contants.ContentTypeConstant;

/**
 * Desc: TODO
 * <p>
 * Author: shirencong
 * PackageName: com.muti.lesson.views
 * ProjectName: AndroidProjects
 * Date: 2019/1/22 17:27
 */
public class ContentItemView implements View.OnFocusChangeListener, View.OnClickListener {

    // 上下文
    private Context mContext = null;

    // 根布局
    private FrameLayout rootView = null;

    // 内容类型
    private int contentType = -1;

    // 缩放比例
    private final static float SCALE_RATE = 1.06f;

    public ContentItemView(Context mContext, int contentType) {
        this.mContext = mContext;
        this.contentType = contentType;
        initView();
    }

    public View getRootView() {
        return rootView;
    }

    /**
     * 解析view，并且根据内容类型显示对应的图片
     */
    private void initView() {
        rootView = (FrameLayout) LayoutInflater.from(mContext).inflate(R.layout.content_page_item_layout, null);
        rootView.setOnFocusChangeListener(this);
        for (int i = 0; i < rootView.getChildCount(); i++) {
            FrameLayout itemParentView = (FrameLayout) rootView.getChildAt(i);
            ImageView ivIcon = (ImageView) itemParentView.getChildAt(0);
            switch (contentType) {
                case ContentTypeConstant
                        .CONTENT_TYPE_MOVIE:
                    ivIcon.setImageResource(R.mipmap.video_classic_movie);
                    break;

                case ContentTypeConstant
                        .CONTENT_TYPE_DIANSHIJU:
                    ivIcon.setImageResource(R.mipmap.video_classic_tv);
                    break;

                case ContentTypeConstant
                        .CONTENT_TYPE_ZONGYI:
                    ivIcon.setImageResource(R.mipmap.video_classic_zongyi);
                    break;
            }
            itemParentView.setOnFocusChangeListener(this);
            itemParentView.setOnClickListener(this);
        }

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        FocusBoundImageView focusView = (FocusBoundImageView) ((FrameLayout) v).getChildAt(1);
        if (hasFocus) {
            focusView.setVisibility(View.VISIBLE);
            startGetFocusAnim(v);
        } else {
            focusView.setVisibility(View.GONE);
            startLooseFocusAnim(v);
        }
    }

    /**
     * 获取焦点时执行放大动画
     *
     * @param view 需要放大的布局
     */
    private void startGetFocusAnim(View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, SCALE_RATE, 1.0F, SCALE_RATE, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        scaleAnimation.setFillAfter(true);
        view.bringToFront();
        view.startAnimation(scaleAnimation);
    }

    /**
     * 丢失焦点时执行缩小动画
     *
     * @param view 需要缩小的布局
     */
    private void startLooseFocusAnim(View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(SCALE_RATE, 1.0f, SCALE_RATE, 1.0F, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        scaleAnimation.setFillAfter(true);
        view.startAnimation(scaleAnimation);
    }

    @Override
    public void onClick(View v) {
        // 点击跳转到相应的列表页
        Intent intent = new Intent();
        intent.setClass(mContext, VideoListActivity.class);
        intent.putExtra("type", contentType);
        mContext.startActivity(intent);
    }
}
