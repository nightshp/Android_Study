package lunzn.com.pricticeapplication.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import lunzn.com.pricticeapplication.R;
import lunzn.com.pricticeapplication.adapter.ContentAdapter;
import lunzn.com.pricticeapplication.contants.ContentType;
import lunzn.com.pricticeapplication.views.ContentView;

public class MainActivity extends Activity implements View.OnFocusChangeListener, ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    // 顶部标题栏
    private RadioGroup rg_tab_menu;

    // radioButton
    private RadioButton rbMovie, rbTv, rbVariety;

    // view集合
    private List<View> mViewList;

    // 主内容显示适配器
    private ContentAdapter mAdapter;

    // ViewPager
    private ViewPager mViewPager;

    private static final String TAG = "main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        rbMovie = findViewById(R.id.rb_movie);
        rbTv = findViewById(R.id.rb_tv);
        rbVariety = findViewById(R.id.rb_variety);
        rg_tab_menu = findViewById(R.id.rg_tab_menu);
        mViewPager = findViewById(R.id.vp_content);
        mViewPager.addOnPageChangeListener(this);
        rg_tab_menu.setOnCheckedChangeListener(this);

        initMenu();
        initData();
    }

    /**
     * 设置测试数据
     */
    private void initData() {
        mViewList = new ArrayList<View>();
        int[] contentType = new int[]{ContentType.PAGE_CONTENT_MOVIE, ContentType.PAGE_CONTENT_TV, ContentType.PAGE_CONTENT_VARIETY};
        ContentView contentView = null;
        for (int i = 0; i < contentType.length; i++) {
            contentView = new ContentView(this, contentType[i]);
            mViewList.add(contentView.getRootView());
        }
        mAdapter = new ContentAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);
    }


    /**
     * 设置焦点监听事件
     */
    private void initMenu() {
        int count = rg_tab_menu.getChildCount();
        for (int index = 0; index < count; index++) {
            RadioButton rbItem = (RadioButton) rg_tab_menu.getChildAt(index);
            rbItem.setOnFocusChangeListener(this);
            rbItem.setTag(index);
        }
    }

    /**
     * 处理顶部标题栏焦点改变时的切换效果
     *
     * @param v        控件
     * @param hasFocus 是否聚焦
     */
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            ((RadioButton) v).setChecked(true);
            ((RadioButton) v).setTextSize(TypedValue.COMPLEX_UNIT_PX, 32);
            v.setBackgroundResource(R.mipmap.sort_item_focus_en);
            Log.i(TAG, "onFocusChange radioButton: " + v);
//            switch (v.getId()) {
//                case R.id.rb_movie:
//                    mViewPager.setCurrentItem(ContentType.PAGE_CONTENT_MOVIE);
//                    break;
//                case R.id.rb_tv:
//                    mViewPager.setCurrentItem(ContentType.PAGE_CONTENT_TV);
//                    break;
//                case R.id.rb_variety:
//                    mViewPager.setCurrentItem(ContentType.PAGE_CONTENT_VARIETY);
//                    break;
//                default:
//                    break;
//            }
        } else {
            ((RadioButton) v).setTextSize(TypedValue.COMPLEX_UNIT_PX, 30);
            v.setBackground(null);
        }
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    /**
     * 页面跳转之后
     *
     * @param position 页面位置
     */
    @SuppressLint("ResourceAsColor")
    @Override
    public void onPageSelected(int position) {
        RadioButton radioButton = (RadioButton) rg_tab_menu.getChildAt(position);
        Log.i(TAG, "onPageSelected : " + position);
        radioButton.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton radioButton = group.findViewById(group.getCheckedRadioButtonId());
        mViewPager.setCurrentItem((Integer) radioButton.getTag(), true);
    }
}
