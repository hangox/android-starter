package com.hangox.starter.context

import android.app.Service
import dagger.android.AndroidInjection

abstract class BindingService : Service() {
    override fun onCreate() {
        super.onCreate()
        AndroidInjection.inject(this)
    }


}