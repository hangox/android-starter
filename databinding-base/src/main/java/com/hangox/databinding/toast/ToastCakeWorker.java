package com.hangox.databinding.toast;

import android.content.Context;
import android.widget.Toast;


/**
 * Created With Android Studio
 * User hangox
 * Date 15/12/28
 * Time 上午10:36
 * Toast 的单独实现
 */
public class ToastCakeWorker implements ToastCake ,ToastCake2{
    private Toast mToast;
    private Context mContext;

    private static ToastCakeWorker mToastCakeWorker;

    /**
     * 获取公共的Toast
     * @param context 任意context
     * @return 返回一个公共的实现
     */
    public static ToastCakeWorker getPublic(Context context) {
        if (mToastCakeWorker == null) {
            mToastCakeWorker = new ToastCakeWorker(context.getApplicationContext());
        }
        return mToastCakeWorker;
    }

    public ToastCakeWorker(Context context) {
        mToast = Toast.makeText(context, "", Toast.LENGTH_LONG);
        mContext = context;
    }

    public void showL(String message) {
        toastLong(message);
    }

    public void showS(String message) {
        toastShort(message);
    }

    public void cancel(){
        mToast.cancel();
    }



    @Override
    public void showL(int res) {
        toastLong(res);
    }

    @Override
    public void showS(int res) {
        toastShort(res);
    }

    @Override
    public void toastLong(String message) {
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.setText(message);
        mToast.show();
    }

    @Override
    public void toastShort(String message) {
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.setText(message);
        mToast.show();
    }

    @Override
    public void toastLong(int res) {
        toastLong(mContext.getString(res));
    }

    @Override
    public void toastShort(int res) {
        toastShort(mContext.getString(res));
    }
}
