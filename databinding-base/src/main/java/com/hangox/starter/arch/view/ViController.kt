package com.hangox.starter.arch.view

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.hangox.starter.dagger.MyViewModelProviders

/**
 * 控制器
 */
open class ViController<T : ViControllerHost>(
    protected val host: T,
    protected val viewModelProviders: MyViewModelProviders
) : LifecycleObserver {

    init {
        host.viewCreatedEventDispatcher.addOnViewReadyListener {
            host.lifecycle.addObserver(this)
        }
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onViewCreated() {

    }
}