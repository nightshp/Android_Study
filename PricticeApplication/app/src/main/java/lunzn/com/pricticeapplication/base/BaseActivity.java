package lunzn.com.pricticeapplication.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Desc: 自定义activity基类
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.base
 * ProjectName: PricticeApplication
 * Date: 2019/1/31 14:51
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getRootId());
        initData();
        initView();
        initListener();
    }



    /**
     * 获取布局id
     * @return 布局id
     */
    protected abstract int getRootId();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化界面
     */
    protected abstract void initView();

    /**
     * 初始化监听
     */
    protected abstract void initListener();
}
