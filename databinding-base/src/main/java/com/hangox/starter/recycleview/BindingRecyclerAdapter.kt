package com.hangox.starter.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


/**
 * Created With Android Studio
 * User hangox
 * Date 15/12/23
 * Time 下午3:58
 */
abstract class BindingRecyclerAdapter<VH : BindingViewHolder<*>> : HBRecyclerAdapter<VH>() {

    protected lateinit var layoutInflater: LayoutInflater
    protected lateinit var content: Context
    protected lateinit var parent: ViewGroup

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        parent = recyclerView
        content = recyclerView.context
        layoutInflater = LayoutInflater.from(recyclerView.context)
    }


    /**
     * 获得Item 的ViewDataBinding
     * @param layoutId
     * @param <T>
     * @return
    </T> */
    fun <T : ViewDataBinding> inflate(layoutId: Int): T {
        return DataBindingUtil.inflate(layoutInflater, layoutId, parent, false, null)
    }


    /**
     * 获得Item 的ViewDataBinding
     * @param layoutId
     * @param isAttachToParent
     * @param <T>
     * @return
    </T> */
    fun <T : ViewDataBinding> inflate(layoutId: Int, isAttachToParent: Boolean): T {
        return inflate(layoutId, isAttachToParent, null)
    }

    /**
     * 获得Item 的ViewDataBinding
     * @param layoutId
     * @param isAttachToParent
     * @param bindingComponent
     * @param <T>
     * @return
    </T> */
    fun <T : ViewDataBinding> inflate(
        layoutId: Int,
        isAttachToParent: Boolean,
        bindingComponent: androidx.databinding.DataBindingComponent?
    ): T {
        return DataBindingUtil.inflate(
            layoutInflater,
            layoutId,
            parent,
            isAttachToParent,
            bindingComponent
        )
    }

}
