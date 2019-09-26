package com.hangox.starter.arch.livedata

import androidx.lifecycle.LiveData

/**
 * @author hangox
 * 2018/3/15 20:12
 * 带默认值的LiveData
 */
class DefaultLiveData<T> : LiveData<T> {
    constructor(value: T) : super() {
        this.value = value
    }
}