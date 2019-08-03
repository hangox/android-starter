package com.hangox.starter.toast


import androidx.annotation.StringRes

/**
 * Created With Android Studio
 * User hangox
 * Email liang.hanguang93@gmail.com
 * Date 2017/11/27
 * Time 下午3:59
 */

interface ToastCake2 {

    /**
     * 长提示
     */
    fun toastLong(message: String)

    /**
     * 短提示
     */
    fun toastShort(message: String)

    /**
     * 长提示
     */
    fun toastLong(@StringRes res: Int)

    /**
     * 短提示
     */
    fun toastShort(@StringRes res: Int)
}
