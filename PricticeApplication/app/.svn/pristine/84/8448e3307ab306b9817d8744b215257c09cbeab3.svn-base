package lunzn.com.pricticeapplication.views;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;

import lunzn.com.pricticeapplication.R;

/**
 * Desc: 自定义PopupWindow
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.views
 * ProjectName: PricticeApplication
 * Date: 2019/3/1 15:03
 */
public class MyPopupWindow extends PopupWindow{
    // 上下文
    private Context mContext;

    private RadioGroup rg_volume;

    private PopupWindow mPopupWindow;

    private FrameLayout frameLayout;

    // 根布局
    private View rootView;

    public MyPopupWindow(Context context, View rootView) {
        mContext = context;
        this.rootView = rootView;
        initView();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        frameLayout = (FrameLayout) LayoutInflater.from(mContext).inflate(R.layout.volume_list_layout,null);
        rg_volume = frameLayout.findViewById(R.id.rg_volume);
        mPopupWindow.setContentView(frameLayout);
        mPopupWindow.setWidth(1280);
        mPopupWindow.setHeight(120);
        mPopupWindow.setFocusable(true);
        //为了防止弹出菜单获取焦点之后，点击activity的其他组件没有响应
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.setAnimationStyle(R.style.menuAnimation);
        mPopupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);
    }


}
