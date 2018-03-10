package com.hangox.databinding.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created With Android Studio
 * User hangox
 * Date 15/12/28
 * Time 下午3:16
 */
public abstract class HBRecyclerAdapter<VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> implements HBViewHolder.OnViewHolderClickListener{
    @Override
    public void onRootViewClick(View rootView, int index) {

    }
}
