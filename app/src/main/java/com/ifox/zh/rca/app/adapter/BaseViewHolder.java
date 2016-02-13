package com.ifox.zh.rca.app.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;

/**
 * 包名：com.ifox.zh.rca.app.adapter
 * 作者：zh 于 2016/2/13 17:00.
 * 描述：viewHolder 基类
 * 版本：1.0
 * 更新：创建
 */
public abstract  class BaseViewHolder<T> implements ViewHolder<T> {

    protected Context context;

    protected  int layoutId;

    protected View rootView;

    protected SparseArray<View> views;

    public BaseViewHolder(Context context, int layoutId) {
        this.context = context;
        this.layoutId = layoutId;
        rootView = View.inflate(context, layoutId, null);
        rootView.setTag(this);
        views = new SparseArray<>();
    }

    @Override
    public View getRootView() {
        return this.rootView;
    }

    @Override
    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);

        if(view != null)
            return (T) view;

        view = rootView.findViewById(viewId);

        if(view != null)
            views.put(viewId, view);

        return (T) view;
    }

    @Override
    public abstract void fillView(T data);
}