package com.hangox.starter.databinding

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * @author hangox
 * 2018/2/27 21:20
 * 用来存放View公共属性的Adapter
 */

object MyViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("isGone")
    fun viewGone(view: View, isGone: Boolean) {
        view.visibility = if (isGone) View.GONE else View.VISIBLE
    }

    @JvmStatic
    @BindingAdapter("isVisible")
    fun viewVisible(view: View, isVisible: Boolean) {
        view.visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}