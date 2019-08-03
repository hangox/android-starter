package com.hangox.starter.context


import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created With Android Studio
 * User hangox
 * Date 16/7/8
 * Time 下午9:47
 */

abstract class BindingActivity<V : ViewDataBinding> : HBaseActivity(), BindingProvider<V> {
    override lateinit var binding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (provideLayoutId() != View.NO_ID) {
            binding = DataBindingUtil.setContentView(this, provideLayoutId(), provideComponent())
        }
    }
}
