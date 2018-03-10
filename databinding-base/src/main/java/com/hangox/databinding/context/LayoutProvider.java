package com.hangox.databinding.context;

import android.support.annotation.LayoutRes;

/**
 * Created With Android Studio
 * User hangox
 * Email liang.hanguang93@gmail.com
 * Date 2017/11/24
 * Time 下午10:56
 * 可以提供Layout
 */

public interface LayoutProvider {


    @LayoutRes  int provideLayoutId();
}
