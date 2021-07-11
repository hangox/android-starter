package com.hangox.starter.databinding

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter

/**
 *
 */
object MyImageViewAdapter {

    @JvmStatic
    @BindingAdapter("android:src")
    fun androidSrcDrawableRes(view: ImageView, @DrawableRes drawableRes: Int) {
        view.setImageResource(drawableRes)
    }
}