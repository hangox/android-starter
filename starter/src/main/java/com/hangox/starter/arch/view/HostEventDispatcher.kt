package com.hangox.starter.arch.view

import javax.inject.Inject

/**
 *
 */

class HostEventDispatcher
@Inject
constructor() {
    private val callbacks = ArrayList<() -> Unit>(2)


    fun dispatchViewCreated() {
        callbacks.forEach {
            it.invoke()
        }
        callbacks.clear()
    }

    fun addOnViewReadyListener(callback: () -> Unit) {
        callbacks.add(callback)
    }
}