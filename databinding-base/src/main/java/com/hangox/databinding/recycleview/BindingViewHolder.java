package com.hangox.databinding.recycleview;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created With Android Studio
 * User hangox
 * Date 15/12/23
 * Time 上午12:22
 * 集成ViewDataBinding VieHolder
 */
public class BindingViewHolder<V extends ViewDataBinding>  extends HBViewHolder {
    public final V mBinding;

    @SuppressWarnings("unchecked")
    public BindingViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        mBinding = (V) binding;
    }

    @SuppressWarnings("unchecked")
    public BindingViewHolder(@LayoutRes int layoutId, ViewGroup parent){
        this(layoutId,parent,null);
    }

    public BindingViewHolder(@LayoutRes int layoutId, ViewGroup parent, DataBindingComponent component){
        this((V) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),layoutId,parent,false,component));
    }

}
