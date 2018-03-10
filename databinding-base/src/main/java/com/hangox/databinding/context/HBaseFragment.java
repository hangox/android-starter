package com.hangox.databinding.context;

import android.databinding.DataBindingComponent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created With Android Studio
 * User hangox
 * Date 16/5/27
 * Time 下午4:28
 */

public abstract class HBaseFragment extends Fragment implements LayoutProvider,ComponentProvider{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(provideLayoutId(),container,false);
    }

    @Override
    public DataBindingComponent provideComponent() {
        return null;
    }
}
