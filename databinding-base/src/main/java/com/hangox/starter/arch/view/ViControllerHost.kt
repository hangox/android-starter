package com.hangox.starter.arch.view

import androidx.lifecycle.LifecycleOwner

/**
 *
 */
interface ViControllerHost : LifecycleOwner {

    fun getHostEventDispatcher(): HostEventDispatcher

}