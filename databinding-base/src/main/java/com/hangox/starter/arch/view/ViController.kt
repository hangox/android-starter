package com.hangox.starter.arch.view

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * 控制器
 */
open class ViController<T : ViControllerHost>(
    protected val host: T
) : LifecycleObserver {

    init {
        host.getHostEventDispatcher().addOnViewReadyListener {
            host.lifecycle.addObserver(this)
        }
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onViewCreated() {

    }
}