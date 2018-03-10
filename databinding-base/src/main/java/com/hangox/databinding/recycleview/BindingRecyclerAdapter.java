package com.hangox.databinding.recycleview;

import android.content.Context;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;



/**
 * Created With Android Studio
 * User hangox
 * Date 15/12/23
 * Time 下午3:58
 */
public abstract class BindingRecyclerAdapter<VH extends BindingViewHolder> extends HBRecyclerAdapter<VH> {

    protected LayoutInflater mLayoutInflater;
    protected Context mContent;
    protected ViewGroup mParent;

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mParent = recyclerView;
        mContent = recyclerView.getContext();
        mLayoutInflater = LayoutInflater.from(recyclerView.getContext());
    }


    /**
     获得Item 的ViewDataBinding
     * @param layoutId
     * @param <T>
     * @return
     */
    public <T extends ViewDataBinding> T inflate(int layoutId){
        return DataBindingUtil.inflate(mLayoutInflater,layoutId,mParent,false,null);
    }


    /**
     * 获得Item 的ViewDataBinding
     * @param layoutId
     * @param isAttachToParent
     * @param <T>
     * @return
     */
    public <T extends ViewDataBinding> T inflate(int layoutId,boolean isAttachToParent){
        return inflate(layoutId,isAttachToParent,null);
    }

    /**
     * 获得Item 的ViewDataBinding
     * @param layoutId
     * @param isAttachToParent
     * @param bindingComponent
     * @param <T>
     * @return
     */
    public <T extends ViewDataBinding> T inflate(int layoutId, boolean isAttachToParent, DataBindingComponent bindingComponent){
        return DataBindingUtil.inflate(mLayoutInflater,layoutId,mParent,isAttachToParent,bindingComponent);
    }

}
