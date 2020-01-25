package com.hangox.starter.dagger

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerApplication

/**
 *
 */

abstract class StarterApp : Application(), HasAndroidInjector {

    @Volatile
    @JvmField
    var androidInjector: DispatchingAndroidInjector<Any?>? = null


    override fun onCreate() {
        super.onCreate()
        injectIfNecessary()
    }


    /**
     * Implementations should return an [AndroidInjector] for the concrete [ ]. Typically, that injector is a [dagger.Component].
     */
    protected abstract fun applicationInjector(): AndroidInjector<out StarterApp?>

    /**
     * Lazily injects the [DaggerApplication]'s members. Injection cannot be performed in [ ][Application.onCreate] since [android.content.ContentProvider]s' [ ][android.content.ContentProvider.onCreate] method will be called first and might
     * need injected members on the application. Injection is not performed in the constructor, as
     * that may result in members-injection methods being called before the constructor has completed,
     * allowing for a partially-constructed instance to escape.
     */
    private fun injectIfNecessary() {
        if (androidInjector == null) {
            synchronized(this) {
                if (androidInjector == null) {
                    val applicationInjector =
                        applicationInjector() as AndroidInjector<StarterApp?>
                    applicationInjector.inject(this)
                    checkNotNull(androidInjector) {
                        ("The AndroidInjector returned from applicationInjector() did not inject the "
                                + "DaggerApplication")
                    }
                }
            }
        }
    }

    override fun androidInjector(): AndroidInjector<Any?>? { // injectIfNecessary should already be called unless we are about to inject a ContentProvider,
        injectIfNecessary()
        return androidInjector
    }

}