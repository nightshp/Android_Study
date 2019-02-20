package lunzn.com.pricticeapplication.util;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

/**
 * Desc: 控件焦点操作工具类
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.util
 * ProjectName: PricticeApplication
 * Date: 2019/1/31 16:04
 */
public class FocusAnimUtil {

    // 缩放比例
    private static final Float SCALE_RATE = 1.1f;

    /**
     * 获得焦点时执行放大操作
     *
     * @param view 需要放大的控件
     */
    public static void getFocusAnim(View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, SCALE_RATE, 1.0f, SCALE_RATE, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        scaleAnimation.setFillAfter(true);
        view.bringToFront();
        view.startAnimation(scaleAnimation);
    }

    /**
     * 失去焦点时执行缩小操作
     *
     * @param v 需要缩小的控件
     */
    public static void looseFocusAnim(View v) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(SCALE_RATE, 1.0f, SCALE_RATE, 1.0f, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        scaleAnimation.setFillAfter(true);
        v.startAnimation(scaleAnimation);
    }
}
