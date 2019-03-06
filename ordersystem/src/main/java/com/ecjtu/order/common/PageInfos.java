package com.ecjtu.order.common;

/**
 * Desc: 分页数据
 * <p>
 * Author: suhongpeng
 * PackageName: com.ecjtu.order.common
 * ProjectName: ordersystem
 * Date: 2019/2/21 17:38
 */
public class PageInfos
{
    /**
     * 页码
     */
    private int pageNum;

    /**
     * 起始索引
     */
    private int offset;

    /**
     * 每页显示的数据
     */
    private int pageSize;

    public int getPageNum()
    {
        return pageNum;
    }

    public void setPageNum(int pageNum)
    {
        this.pageNum = pageNum;
    }

    public int getOffset()
    {
        return offset;
    }

    public void setOffset(int offset)
    {
        this.offset = offset;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }
}
