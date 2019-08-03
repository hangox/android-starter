package com.hangox.starter.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created With Android Studio
 * User hangox
 * Date 15/12/23
 * Time 上午12:22
 * 集成ViewDataBinding VieHolder
 */
class BindingViewHolder<V : ViewDataBinding>(binding: ViewDataBinding) :
    HBViewHolder(binding.root) {
    val binding: V

    init {
        this.binding = binding as V
    }

    constructor(@LayoutRes layoutId: Int, parent: ViewGroup) : this(layoutId, parent, null) {}

    constructor(
        @LayoutRes layoutId: Int, parent: ViewGroup,
        component: androidx.databinding.DataBindingComponent?
    ) : this(
        DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layoutId,
            parent,
            false,
            component
        )
    ) {
    }

}
