package com.hangox.databinding.toast;

import android.support.annotation.StringRes;

/**
 * Created With Android Studio
 * User hangox
 * Email liang.hanguang93@gmail.com
 * Date 2017/11/27
 * Time 下午3:59
 */

public interface ToastCake2 {
    void toastLong(String message);

    void toastShort(String message);

    void toastLong(@StringRes int res);

    void toastShort(@StringRes int res);
}
