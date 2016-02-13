package com.ifox.zh.rca.app.util;

import android.widget.TextView;

/**
 * Created by zh on 2016/2/4.
 */
public class StringUtils {
    /**
     * @param tv 获取textview 及其子类的文本信息 如 edittext button...
     * @return 文本控件中的文本信息
     */
    public  static String getString(TextView tv) {
        return  tv.getText().toString();
    }
}
