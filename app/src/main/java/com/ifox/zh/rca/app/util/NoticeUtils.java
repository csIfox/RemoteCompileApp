package com.ifox.zh.rca.app.util;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

/**
 * Created by zh on 2016/2/1.
 * @description 提示的工具类 如toast提示 progress dialog
 */
public class NoticeUtils {

    private static void showToast(Context context, String text, int duration) {
        if(Looper.myLooper() == Looper.getMainLooper()) { // 如果是在主线程中执行 提示
            Toast.makeText(context, text, duration).show();
        } else {
            throw new IllegalArgumentException("不是主线程");
        }
    }

    /**
     * @description 显示短提示
     * @param context 上下文
     * @param text 提示的文本
     */
    public static void showToastShort(Context context, String text) {
        showToast(context, text, Toast.LENGTH_SHORT);
    }

    /**
     * @description toast 长提示
     * @param context 上下文
     * @param text  提示信息
     */
    public static void showToastLong(Context context, String text) {
        showToast(context,text,Toast.LENGTH_LONG);
    }
}
