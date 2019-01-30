package com.muti.lesson.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: TODO
 * <p> 主内容页面适配器
 * Author: shirencong
 * PackageName: com.muti.lesson.adapter
 * ProjectName: AndroidProjects
 * Date: 2019/1/22 17:13
 */
public class MainContentAdapter extends PagerAdapter {

    private List<View> contentViewList = null;

    public MainContentAdapter(List<View> contentViewList) {
        setData(contentViewList);
    }

    private void setData(List<View> contentViewList) {
        if (contentViewList == null) {
            contentViewList = new ArrayList<View>();
        }
        this.contentViewList = contentViewList;
    }

    @Override
    public int getCount() {
        return contentViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = contentViewList.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = contentViewList.get(position);
        container.removeView(view);
    }
}
