package com.hangox.databinding.context;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created With Android Studio
 * User hangox
 * Date 7/14/16
 * Time 11:07 AM
 * 带Binding功能的Fragment
 */
public abstract class BindingFragment<V extends ViewDataBinding> extends HBaseFragment {
    protected V mBinding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, provideLayoutId(),container,false,provideComponent());
        return mBinding.getRoot();
    }
}
