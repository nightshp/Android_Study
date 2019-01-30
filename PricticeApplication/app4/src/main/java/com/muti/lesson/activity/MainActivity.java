package com.muti.lesson.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.muti.lesson.R;
import com.muti.lesson.adapter.MainContentAdapter;
import com.muti.lesson.contants.ContentTypeConstant;
import com.muti.lesson.views.ContentItemView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnFocusChangeListener, ViewPager.OnPageChangeListener,RadioGroup.OnCheckedChangeListener {

    // 主标题
    private RadioGroup rgTitle = null;

    // 主内容
    private ViewPager vpContent = null;


    // 内容布局list
    private List<View> contentViewList = null;

    // 内容布局适配器
    private MainContentAdapter mContentAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        vpContent = findViewById(R.id.vp_main_content);
        vpContent.setOnPageChangeListener(this);
        initMainTitle();
        initMainContent();
    }

    private void initData() {

    }

    /**
     * 初始化顶部标题栏，并且设置焦点监听事件
     */
    private void initMainTitle() {
        rgTitle = findViewById(R.id.rg_tab_title);
        rgTitle.setOnCheckedChangeListener(this);
        int count = rgTitle.getChildCount();
        for (int i = 0; i < count; i++) {
            RadioButton rbItem = (RadioButton) rgTitle.getChildAt(i);
            rbItem.setOnFocusChangeListener(this);
            rbItem.setTag(i);
        }
    }

    /**
     * 初始化主内容布局
     */
    private void initMainContent(){
        contentViewList = new ArrayList<View>();
        int[] typeAry = new int[]{ContentTypeConstant.CONTENT_TYPE_MOVIE, ContentTypeConstant.CONTENT_TYPE_DIANSHIJU, ContentTypeConstant.CONTENT_TYPE_ZONGYI};
        ContentItemView itemView = null;
        for (int type : typeAry){
            itemView = new ContentItemView(this, type);
            contentViewList.add(itemView.getRootView());
        }
        mContentAdapter = new MainContentAdapter(contentViewList);
        vpContent.setAdapter(mContentAdapter);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        // 处理顶部标题栏的焦点切换显示效果
        if (hasFocus) {
            ((RadioButton) v).setChecked(true);
            ((RadioButton) v).setTextSize(TypedValue.COMPLEX_UNIT_PX, 32);
            v.setBackgroundResource(R.mipmap.sort_item_focus_en);
        } else {
            ((RadioButton) v).setTextSize(TypedValue.COMPLEX_UNIT_PX, 28);
            v.setBackground(null);
        }
    }

    @Override
    public void onPageSelected(int i) {
        ((RadioButton)rgTitle.getChildAt(i)).setChecked(true);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton rbItem = group.findViewById(group.getCheckedRadioButtonId());
        int pos = (int) rbItem.getTag();
        vpContent.setCurrentItem(pos, true);
    }
}
