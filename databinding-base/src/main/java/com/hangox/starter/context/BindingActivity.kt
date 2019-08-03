package com.hangox.starter.context


import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.hangox.starter.toast.ToastCakeWorker

/**
 * Created With Android Studio
 * User hangox
 * Date 16/7/8
 * Time 下午9:47
 */

abstract class BindingActivity<V : ViewDataBinding> :
    AppCompatActivity(),
    BindingProvider<V>,
    LayoutProvider,
    ComponentProvider {
    override lateinit var binding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toastCakeWorker = ToastCakeWorker(this)
        configActionBar()
        if (provideLayoutId() != View.NO_ID) {
            binding = DataBindingUtil.setContentView(this, provideLayoutId(), provideComponent())
        }
    }

    private lateinit var toastCakeWorker: ToastCakeWorker


    val activity: BindingActivity<V>
        get() = this


    /**
     * 是否显示返回按键
     * @return
     */
    protected val isShowNavigationUp: Boolean
        get() = true


    protected fun configActionBar() {
        val actionBar = supportActionBar
        if (actionBar != null && isShowNavigationUp) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
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
}
