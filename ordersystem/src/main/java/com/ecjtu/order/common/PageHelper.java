package com.ecjtu.order.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: 返回数据封装类
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.common
 * ProjectName: ordersystem
 * Date: 2019/2/21 17:49
 */
public class PageHelper<T>
{
    /**
     * 实体类集合
     */
    private List<T> rows = new ArrayList<T>();

    /**
     * 数据总数
     */
    private int total;

    public PageHelper()
    {
    }

    public List<T> getRows()
    {
        return rows;
    }

    public void setRows(List<T> rows)
    {
        this.rows = rows;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }
}
