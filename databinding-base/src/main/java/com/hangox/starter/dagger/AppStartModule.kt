package com.hangox.starter.dagger

import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule

/**
 * 用于 App 开始构建
 */
@Module(
    includes = [
        AndroidSupportInjectionModule::class,
        MyViewModelModules::class,
        AndroidInjectionModule::class
    ]
)
class AppStartModule {

}