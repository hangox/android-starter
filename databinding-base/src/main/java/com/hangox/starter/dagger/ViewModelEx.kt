package com.hangox.starter.dagger

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import javax.inject.Inject
import javax.inject.Singleton

/**
 * 用这个获取就不需要拿到ViewModelFactory
 */
@Singleton
class MyViewModelProviders
@Inject
constructor(
    private val factory: MyViewModelProviderFactory
) {


    /**
     * 获取Provider
     */
    fun of(fragment: Fragment): ViewModelProvider {
        return ViewModelProviders.of(fragment, factory)
    }


    /**
     * 获取Provider
     */
    fun of(activity: FragmentActivity): ViewModelProvider {
        return ViewModelProviders.of(activity, factory)
    }
}
