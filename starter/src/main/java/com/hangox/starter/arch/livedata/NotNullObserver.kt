package com.hangox.starter.arch.livedata

import androidx.lifecycle.Observer

/**
 * @author HangoX
 * email liang.hanguang93@gmail.com
 * 2018/6/24 下午11:25
 * 值不为Null的Observer
 */
abstract class NotNullObserver<T> : Observer<T> {
    final override fun onChanged(t: T?) {
        if (t == null) {
            onNullChanged()
        } else {
            onNotNullChanged(t)
        }

    }

    abstract fun onNotNullChanged(t: T)

    fun onNullChanged() {}
}