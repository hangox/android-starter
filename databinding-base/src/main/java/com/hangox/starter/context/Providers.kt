package com.hangox.starter.context


import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

/**
 * 提供 Binding 的东西
 */
interface BindingProvider<V : ViewDataBinding> {
    val binding: V
}

/**
 * 可以提供Layout
 */

interface LayoutProvider {


    @LayoutRes
    fun provideLayoutId(): Int
}

/**
 * @author hangox
 * liang.hanguang93@gmail.com
 * 提供dataBinding的Component
 */

interface ComponentProvider {

    fun provideComponent(): androidx.databinding.DataBindingComponent?
}