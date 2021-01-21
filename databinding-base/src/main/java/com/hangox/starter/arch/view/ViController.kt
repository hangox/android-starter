package com.hangox.starter.arch.view

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * 控制器
 */
open class ViController<V : ViewDataBinding, T : ViControllerHost<V>>(
        protected val host: T
) : LifecycleObserver {

    val binding: V
        get() = host.binding

    init {
        host.getHostEventDispatcher().addOnViewReadyListener {
            onDispatchViewCreated()
        }
    }

    private fun onDispatchViewCreated() {
        // View 创建之后才开始分发事件
        this.onViewCreated(binding)
        host.lifecycle.addObserver(this)
    }


    /**
     * View 创建的时候会调用
     */
    open fun onViewCreated(binding: V) {}


}