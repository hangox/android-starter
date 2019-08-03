package com.hangox.starter.recycleview

import android.view.View

import androidx.recyclerview.widget.RecyclerView

/**
 * Created With Android Studio
 * User hangox
 * Date 15/12/28
 * Time 下午3:16
 */
abstract class HBRecyclerAdapter<VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>(),
    HBViewHolder.OnViewHolderClickListener {
    override fun onRootViewClick(rootView: View, index: Int) {

    }
}
