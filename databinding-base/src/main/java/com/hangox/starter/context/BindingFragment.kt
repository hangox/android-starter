package com.hangox.starter.context

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * Created With Android Studio
 * User hangox
 * Date 7/14/16
 * Time 11:07 AM
 * 带Binding功能的Fragment
 */
abstract class BindingFragment<V : ViewDataBinding> : Fragment(), LayoutProvider, ComponentProvider,
    BindingProvider<V> {
    override lateinit var binding: V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            provideLayoutId(),
            container,
            false,
            provideComponent()
        )
        return binding.root
    }

}
