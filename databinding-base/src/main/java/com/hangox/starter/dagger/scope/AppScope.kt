package com.hangox.starter.dagger.scope

import javax.inject.Scope

/**
 * Created by hangox on 2018/2/2.
 * App 域 用于标记应用整个周期
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class AppScope