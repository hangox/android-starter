package com.hangox.starter.context


import androidx.annotation.LayoutRes

/**
 * Created With Android Studio
 * User hangox
 * Email liang.hanguang93@gmail.com
 * Date 2017/11/24
 * Time 下午10:56
 * 可以提供Layout
 */

interface LayoutProvider {


    @LayoutRes
    fun provideLayoutId(): Int
}
