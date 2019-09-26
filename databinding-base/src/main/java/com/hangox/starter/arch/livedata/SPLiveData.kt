package com.hangox.starter.arch.livedata

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import kotlin.reflect.KClass

/**
 * Created With Android Studio
 * User hangox
 * Date 2018/2/25
 * Time 下午9:52
 * 一个可以监听SP变化的LiveData
 */
class SPLiveData<T>(
    private val keyName: String,
    private val defaultValue: T?,
    private val preferences: SharedPreferences,
    private val tClass: KClass<out Any>
) : MutableLiveData<T>(), SharedPreferences.OnSharedPreferenceChangeListener {

    init {
        value = getSharePreferencesValue()
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        if (keyName == key) {
            value = getSharePreferencesValue()
        }

    }

    @Suppress("UNCHECKED_CAST")
    private fun getSharePreferencesValue(): T {
        return when (tClass) {
            Int::class -> {
                preferences.getInt(keyName, defaultValue as Int) as T
            }
            String::class -> {
                preferences.getString(keyName, defaultValue as String) as T
            }
            Float::class -> {
                preferences.getFloat(keyName, defaultValue as Float) as T
            }
            Boolean::class -> {
                preferences.getBoolean(keyName, defaultValue as Boolean) as T
            }
            Long::class -> {
                preferences.getLong(keyName, defaultValue as Long) as T
            }

            else -> {
                throw IllegalArgumentException("not implement")
            }

        }
    }

    override fun onActive() {
        super.onActive()
        preferences.registerOnSharedPreferenceChangeListener(this)
    }


    override fun onInactive() {
        super.onInactive()
        preferences.unregisterOnSharedPreferenceChangeListener(this)
    }
}
