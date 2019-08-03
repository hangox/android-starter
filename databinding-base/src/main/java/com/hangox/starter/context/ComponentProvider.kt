package com.hangox.starter.context


/**
 * @author hangox
 * liang.hanguang93@gmail.com
 * 提供dataBinding的Component
 */

interface ComponentProvider {

    fun provideComponent(): androidx.databinding.DataBindingComponent?
}
