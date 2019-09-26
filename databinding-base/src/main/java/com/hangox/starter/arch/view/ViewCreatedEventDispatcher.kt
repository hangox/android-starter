package com.hangox.starter.arch.view

import javax.inject.Inject

/**
 *
 */

class ViewCreatedEventDispatcher
@Inject
constructor() {
    private val callbacks = ArrayList<() -> Unit>(2)

    init {

    }

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