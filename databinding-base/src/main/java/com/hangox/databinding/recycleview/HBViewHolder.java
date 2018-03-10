package com.hangox.databinding.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created With Android Studio
 * User hangox
 * Date 15/12/28
 * Time 下午3:18
 */
public abstract class HBViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    protected OnViewHolderClickListener mOnViewHolderClickListener;
    public HBViewHolder(View itemView) {
        super(itemView);

    }


    @Override
    public void onClick(View v) {
        if(mOnViewHolderClickListener != null) {
            mOnViewHolderClickListener.onRootViewClick(itemView,getAdapterPosition());
        }
    }

    public void setOnViewHolderClickListener(OnViewHolderClickListener onViewHolderClickListener) {
        itemView.setOnClickListener(onViewHolderClickListener == null ? null : this);
        mOnViewHolderClickListener = onViewHolderClickListener;
    }

    public interface OnViewHolderClickListener {
        void onRootViewClick(View rootView, int index);
    }
}
