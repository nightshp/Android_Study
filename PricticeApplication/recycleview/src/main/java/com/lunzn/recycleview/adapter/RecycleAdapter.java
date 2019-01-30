package com.lunzn.recycleview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lunzn.recycleview.R;
import com.lunzn.recycleview.bean.Recycle;
import com.lunzn.recycleview.interfaces.OnItemClickListener;

import java.util.List;

/**
 * Desc: RecycleView适配器
 * <p>
 * Author: suhongpeng
 * PackageName: com.lunzn.recycleview.adapter
 * ProjectName: PricticeApplication
 * Date: 2019/1/28 10:14
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    private List<Recycle> mData;

    private Context mContext;

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public RecycleAdapter(List<Recycle> data, Context context) {
        mData = data;
        mContext = context;
    }

    // 创建布局，初始化ViewHolder并返回
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycle_item_layout, null);
        return new MyViewHolder(view);
    }

    // 绑定viewholder并填充数据
    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        myViewHolder.mTextView.setText(mData.get(position).toString());
    }

    // 获取条目数量
    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    /**
     * 移除指定位置的数据
     *
     * @param position 位置索引
     */
    public void remove(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * 向指定位置插入数据
     *
     * @param recycle  Recycle对象
     * @param position 位置索引
     */
    public void addData(Recycle recycle, int position) {
        mData.add(recycle);
        notifyItemInserted(position);
    }

    class MyViewHolder extends ViewHolder {

        private TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            if (itemView != null) {
                mTextView = itemView.findViewById(R.id.tv_recycle_item);
                mTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mOnItemClickListener != null) {
                            // getLayoutPosition 返回的是item当前点击的位置
                            mOnItemClickListener.onClick(v, getLayoutPosition());
                        }
                    }
                });
                mTextView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        if (mOnItemClickListener != null) {
                            mOnItemClickListener.onLongClick(v, getLayoutPosition());
                        }
                        return true;
                    }
                });
            }
        }
    }
}
