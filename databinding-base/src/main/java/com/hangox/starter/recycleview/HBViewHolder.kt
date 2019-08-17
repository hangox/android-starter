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
    protected var onViewHolderClickListener: OnViewHolderClickListener? = null
        set(value) {
            itemView.setOnClickListener(if (value == null) null else this)
            field = value
        }


    override fun onClick(v: View) {
        if (onViewHolderClickListener != null) {
            onViewHolderClickListener!!.onRootViewClick(itemView, adapterPosition)
        }
    }

    interface OnViewHolderClickListener {
        fun onRootViewClick(rootView: View, index: Int)
    }
}
