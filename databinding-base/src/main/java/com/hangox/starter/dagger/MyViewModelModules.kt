package com.hangox.starter.dagger

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.multibindings.Multibinds

/**
 * 用于提供一个空的 ViewModel Map
 */
@Module
abstract class MyViewModelModules {
    @Multibinds
    abstract fun stringViewModels(): Map<String, ViewModel>

    @Multibinds
    abstract fun classsViewModels(): Map<Class<out ViewModel>, ViewModel>
}