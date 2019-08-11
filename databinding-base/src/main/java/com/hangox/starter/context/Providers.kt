package com.hangox.starter.context


import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

/**
 * 提供 Binding 的东西
 */
interface BindingProvider<V : ViewDataBinding> {

    /**
     * 提供 binding
     */
    var binding: V
}

/**
 * 可以提供Layout
 */
interface LayoutProvider {


    /**
     * 提供 layoutId
     */
    @LayoutRes
    fun provideLayoutId(): Int
}

/**
 * @author hangox
 * liang.hanguang93@gmail.com
 * 提供dataBinding的Component
 */

interface ComponentProvider {

    /**
     * 提供 DatabindingComponent
     */
    fun provideComponent(): androidx.databinding.DataBindingComponent?
}