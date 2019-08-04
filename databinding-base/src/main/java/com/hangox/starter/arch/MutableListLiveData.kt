package com.hangox.starter.arch

import androidx.lifecycle.LiveData


/**
 * Created by hangox on 2018/2/6.
 * 更新List用的LiveData
 */
class MutableListLiveData<T> : LiveData<MutableList<T>>() {

    init {
        value = ArrayList()
    }

    val mutableValue: MutableList<T>
        get() {
            return value as MutableList<T>
        }


    fun addList(list: List<T>) {
        value?.addAll(list)
        postValue(value)
    }

    public override fun postValue(value: MutableList<T>?) {
        super.postValue(value)
    }

    fun setList(list: MutableList<T>) {
        value = list
    }


    fun notifyListChanged() {
        value?.let {
            value = it
        }
    }

    fun removeAt(position: Int) {
        value?.removeAt(position)
        notifyListChanged()
    }


    fun add(t: T) {
        value?.add(t)
        notifyListChanged()
    }


}