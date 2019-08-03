package com.hangox.starter.context


import androidx.databinding.ViewDataBinding

/**
 * 提供 Binding 的东西
 */
interface BindingProvider<V : ViewDataBinding> {
    val binding: V
}
