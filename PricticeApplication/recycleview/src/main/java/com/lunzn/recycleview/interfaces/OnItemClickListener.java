package com.lunzn.recycleview.interfaces;

import android.view.View;

/**
 * Desc: item点击事件接口
 * <p>
 * Author: suhongpeng
 * PackageName: com.lunzn.recycleview.interfaces
 * ProjectName: PricticeApplication
 * Date: 2019/1/28 11:55
 */
public interface OnItemClickListener {

    // 点击
    void onClick(View v,int position);

    // 长按点击
    void onLongClick(View v,int position);
}
