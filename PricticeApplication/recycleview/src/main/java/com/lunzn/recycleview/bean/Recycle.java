package com.lunzn.recycleview.bean;

/**
 * Desc: RecycleView实体类
 * <p>
 * Author: suhongpeng
 * PackageName: com.lunzn.recycleview.bean
 * ProjectName: PricticeApplication
 * Date: 2019/1/28 10:10
 */
public class Recycle {

    private String txtRecycle;

    public Recycle(String txtRecycle) {
        this.txtRecycle = txtRecycle;
    }

    public String getTxtRecycle() {
        return txtRecycle;
    }

    public void setTxtRecycle(String txtRecycle) {
        this.txtRecycle = txtRecycle;
    }

    @Override
    public String toString() {
        return txtRecycle;
    }
}
