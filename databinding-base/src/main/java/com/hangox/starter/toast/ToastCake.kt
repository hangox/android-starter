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
class ToastCake(private val mContext: Context) {
    private val toast: Toast = Toast.makeText(mContext, "", Toast.LENGTH_LONG)


    fun cancel() {
        toast.cancel()
    }


    fun long(message: String) {
        toast.duration = Toast.LENGTH_LONG
        toast.setText(message)
        toast.show()
    }

    fun short(message: String) {
        toast.duration = Toast.LENGTH_SHORT
        toast.setText(message)
        toast.show()
    }

    fun long(res: Int) {
        long(mContext.getString(res))
    }

    fun short(res: Int) {
        short(mContext.getString(res))
    }

    companion object {

        @SuppressLint("StaticFieldLeak")
        private var toastCake: ToastCake? = null

        /**
         * 获取公共的Toast
         * @param context 任意context
         * @return 返回一个公共的实现
         */
        fun getPublic(context: Context): ToastCake {
            if (toastCake == null) {
                toastCake = ToastCake(context.applicationContext)
            }
            return toastCake!!
        }
    }
}
