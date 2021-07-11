package com.hangox.starter.arch.view

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import com.hangox.starter.context.BindingProvider

/**
 *
 */
interface ViControllerHost<V : ViewDataBinding> : LifecycleOwner , BindingProvider<V> {


    fun getHostEventDispatcher(): HostEventDispatcher


}