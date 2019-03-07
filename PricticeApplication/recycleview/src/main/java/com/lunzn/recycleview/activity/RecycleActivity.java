package com.lunzn.recycleview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.lunzn.recycleview.R;
import com.lunzn.recycleview.adapter.RecycleAdapter;
import com.lunzn.recycleview.bean.Recycle;
import com.lunzn.recycleview.interfaces.OnItemClickListener;
import com.lunzn.recycleview.util.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: RecycleView activity
 * <p>
 * Author: suhongpeng
 * PackageName: com.lunzn.recycleview.activity
 * ProjectName: PricticeApplication
 * Date: 2019/1/28 10:11
 */
public class RecycleActivity extends Activity {

    private RecyclerView mRecyclerView;

    private RecycleAdapter mAdapter;

    private List<Recycle> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_mian_layout);
        initView();
        initData();
        initAdapter();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        mRecyclerView = findViewById(R.id.rv_main);
    }

    /**
     * 测试数据
     */
    private void initData() {
        mData = new ArrayList<Recycle>();
        for (int i = 0; i < 100; i++) {
            mData.add(new Recycle("亚瑟" + i));
        }
    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        mAdapter = new RecycleAdapter(mData, RecycleActivity.this);
        // 布局管理
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        // 设置适配器
        mRecyclerView.setAdapter(mAdapter);
        // 画横线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        // 默认动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Toast.makeText(RecycleActivity.this, "你点击了" + mData.get(position).getTxtRecycle(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLongClick(View v, int position) {
                mAdapter.remove(position);
                Toast.makeText(RecycleActivity.this, "你移除了" + mData.get(position).getTxtRecycle(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
