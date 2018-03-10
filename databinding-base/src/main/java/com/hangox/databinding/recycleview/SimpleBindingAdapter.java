package com.hangox.databinding.recycleview;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

/**
 * Created With Android Studio
 * User hangox
 * Email liang.hanguang93@gmail.com
 * Date 2017/11/26
 * Time 下午9:59
 */

public abstract class SimpleBindingAdapter<V extends BindingViewHolder> extends BindingRecyclerAdapter<V> {
    public abstract @LayoutRes
    int getLayoutId();

    @SuppressWarnings("unchecked")
    @Override
    public V onCreateViewHolder(ViewGroup parent, int viewType) {
        BindingViewHolder viewHolder = new BindingViewHolder<>(getLayoutId(), parent);

        if (isSetClickListener()) {
            viewHolder.setOnViewHolderClickListener(this);
        }
        return (V) viewHolder;
    }

    protected boolean isSetClickListener() {
        return true;
    }
}
