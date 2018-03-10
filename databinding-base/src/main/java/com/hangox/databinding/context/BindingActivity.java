package com.hangox.databinding.context;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created With Android Studio
 * User hangox
 * Date 16/7/8
 * Time 下午9:47
 */

public abstract class BindingActivity<V extends ViewDataBinding> extends HBaseActivity {
    protected V mDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(provideLayoutId() != View.NO_ID) {
            mDataBinding = DataBindingUtil.setContentView(this, provideLayoutId(),provideComponent());
        }
    }


}
