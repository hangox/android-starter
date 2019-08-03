package com.hangox.starter.toast

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast


/**
 * Created With Android Studio
 * User hangox
 * Date 15/12/28
 * Time 上午10:36
 * Toast 的单独实现
 */
class ToastCakeWorker(private val mContext: Context) : ToastCake, ToastCake2 {
    private val toast: Toast = Toast.makeText(mContext, "", Toast.LENGTH_LONG)

    override fun showL(message: String) {
        toastLong(message)
    }

    override fun showS(message: String) {
        toastShort(message)
    }

    fun cancel() {
        toast.cancel()
    }


    override fun showL(res: Int) {
        toastLong(res)
    }

    override fun showS(res: Int) {
        toastShort(res)
    }

    override fun toastLong(message: String) {
        toast.duration = Toast.LENGTH_LONG
        toast.setText(message)
        toast.show()
    }

    override fun toastShort(message: String) {
        toast.duration = Toast.LENGTH_SHORT
        toast.setText(message)
        toast.show()
    }

    override fun toastLong(res: Int) {
        toastLong(mContext.getString(res))
    }

    override fun toastShort(res: Int) {
        toastShort(mContext.getString(res))
    }

    companion object {

        @SuppressLint("StaticFieldLeak")
        private var toastCakeWorker: ToastCakeWorker? = null

        /**
         * 获取公共的Toast
         * @param context 任意context
         * @return 返回一个公共的实现
         */
        fun getPublic(context: Context): ToastCakeWorker {
            if (toastCakeWorker == null) {
                toastCakeWorker = ToastCakeWorker(context.applicationContext)
            }
            return toastCakeWorker!!
        }
    }
}
