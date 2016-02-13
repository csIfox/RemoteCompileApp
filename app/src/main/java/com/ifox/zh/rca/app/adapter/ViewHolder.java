package com.ifox.zh.rca.app.adapter;

import android.view.View;

/**
 * 包名：com.ifox.zh.rca.app.adapter
 * 作者：zh 于 2016/2/13 16:43.
 * 描述：视图控制的holder
 * 版本：1
 * 更新：创建
 */
public interface ViewHolder<D> {

    /**
     *得到 所有view的父view
     * @return view 可以复用的view
     */
    View getRootView();

    /**
     * @param viewId view 对象的id
     * @param <T> view对象的类型
     * @return view 对象
     */
    <T extends View> T getView(int viewId);

    /**
     * 填充view用数据
     */
    void fillView(D data);
}
