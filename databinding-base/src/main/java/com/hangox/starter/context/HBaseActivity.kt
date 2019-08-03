package com.hangox.starter.context


import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingComponent

import com.hangox.starter.toast.ToastCake
import com.hangox.starter.toast.ToastCakeWorker


/**
 * Created With Android Studio
 * User hangox
 * Date 16/5/26
 * Time 下午10:05
 * Activity 的父类
 */

abstract class HBaseActivity : AppCompatActivity(), ToastCake, LayoutProvider, ComponentProvider {

    private lateinit var toastCakeWorker: ToastCakeWorker


    val activity: HBaseActivity
        get() = this


    /**
     * 是否显示返回按键
     * @return
     */
    protected val isShowNavigationUp: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toastCakeWorker = ToastCakeWorker(this)
        configActionBar()

    }

    protected fun configActionBar() {
        val actionBar = supportActionBar
        if (actionBar != null && isShowNavigationUp) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }


    override fun showL(message: String) {
        toastCakeWorker.showL(message)
    }

    override fun showS(message: String) {
        toastCakeWorker.showS(message)
    }

    override fun showL(@StringRes res: Int) {
        toastCakeWorker.showL(res)
    }

    override fun showS(@StringRes res: Int) {
        toastCakeWorker.showS(res)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            onHomeButtonClick()
        }
        return super.onOptionsItemSelected(item)
    }


    /**
     * 点击左上角的按钮时候触发
     */
    protected fun onHomeButtonClick() {
        finish()
    }

    override fun provideComponent(): DataBindingComponent? {
        return null
    }
}
