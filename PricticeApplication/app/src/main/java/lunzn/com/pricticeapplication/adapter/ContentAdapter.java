package lunzn.com.pricticeapplication.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: 主内容显示适配器
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.adapter
 * ProjectName: PricticeApplication
 * Date: 2019/1/22 19:04
 */
public  class ContentAdapter extends PagerAdapter {

    private List<View> mViews;

    public ContentAdapter(List<View> views) {
        setData(views);
    }

    private void setData(List<View> views) {
        if (views == null){
            views = new ArrayList<View>();
        }
        mViews = views;
    }


    @Override
    public int getCount() {
        return mViews == null ? 0 : mViews.size();
    }

    @Override
    public boolean isViewFromObject(View view,Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mViews.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = mViews.get(position);
        container.removeView(view);
    }
}
