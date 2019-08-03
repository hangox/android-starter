package com.hangox.starter.recycleview

import android.view.View

import androidx.recyclerview.widget.RecyclerView

/**
 * Created With Android Studio
 * User hangox
 * Date 15/12/28
 * Time 下午3:18
 */
abstract class HBViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {
    protected var mOnViewHolderClickListener: OnViewHolderClickListener? = null


    override fun onClick(v: View) {
        if (mOnViewHolderClickListener != null) {
            mOnViewHolderClickListener!!.onRootViewClick(itemView, adapterPosition)
        }
    }

    fun setOnViewHolderClickListener(onViewHolderClickListener: OnViewHolderClickListener?) {
        itemView.setOnClickListener(if (onViewHolderClickListener == null) null else this)
        mOnViewHolderClickListener = onViewHolderClickListener
    }

    interface OnViewHolderClickListener {
        fun onRootViewClick(rootView: View, index: Int)
    }
}
