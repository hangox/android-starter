package com.hangox.starter.dagger

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.hangox.starter.dagger.scope.AppScope
import javax.inject.Inject

/**
 * 用这个获取就不需要拿到ViewModelFactory
 */
@AppScope
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
