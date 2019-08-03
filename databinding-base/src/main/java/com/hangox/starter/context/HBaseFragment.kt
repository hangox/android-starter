package com.hangox.starter.context

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created With Android Studio
 * User hangox
 * Date 16/5/27
 * Time 下午4:28
 */

abstract class HBaseFragment : Fragment(), LayoutProvider, ComponentProvider {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(provideLayoutId(), container, false)
    }

    override fun provideComponent(): androidx.databinding.DataBindingComponent? {
        return null
    }
}
