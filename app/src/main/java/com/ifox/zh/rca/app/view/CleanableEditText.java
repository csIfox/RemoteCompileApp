package com.ifox.zh.rca.app.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EView;

@EView
public class CleanableEditText extends EditText{

    private Drawable[] drawables;


    public CleanableEditText(Context context) {
        super(context);
    }

    public CleanableEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CleanableEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @AfterViews
    void init() {
        // getCompoundDrawables:
        // Returns drawables for the left, top, right, and bottom borders.
        drawables = this.getCompoundDrawables();
        // 设置焦点变化的监听
        this.setOnFocusChangeListener(new FocusChangeListenerImpl());
        // 设置EditText文字变化的监听
        this.addTextChangedListener(new TextWatcherImpl());
        // 初始化时让右边clean图标不可见
        this.setClearDrawableVisible(false);
    }

    /**
     * 当手指抬起的位置在clean的图标的区域 我们将此视为进行清除操作 getWidth():得到控件的宽度
     * event.getX():抬起时的坐标(改坐标是相对于控件本身而言的)
     * getTotalPaddingRight():clean的图标左边缘至控件右边缘的距离
     * getPaddingRight():clean的图标右边缘至控件右边缘的距离 于是: getWidth() -
     * getTotalPaddingRight()表示: 控件左边到clean的图标左边缘的区域 getWidth() -
     * getPaddingRight()表示: 控件左边到clean的图标右边缘的区域 所以这两者之间的区域刚好是clean的图标的区域
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:

               if((event.getX() > (getWidth() - getTotalPaddingRight()))
                        && (event.getX() < (getWidth() - getPaddingRight()))) {
                   clear();
               }
                break;

            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    private class FocusChangeListenerImpl implements OnFocusChangeListener {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            setClearDrawableVisible(hasFocus ? isCleanable() : false);
        }
    }

    // 当输入结束后判断是否显示右边clean的图标
    private class TextWatcherImpl implements TextWatcher {
        @Override
        public void afterTextChanged(Editable s) {
            setClearDrawableVisible(isCleanable());
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {

        }


        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {

        }

    }

    protected boolean isCleanable() {
        return !getText().toString().isEmpty();
    }

    // 隐藏或者显示右边clean的图标
    protected void setClearDrawableVisible(boolean isVisible) {
        // 使用代码设置该控件left, top, right, and bottom处的图标
        setCompoundDrawables(getCompoundDrawables()[0],
                getCompoundDrawables()[1], isVisible ? drawables[2] : null,
                getCompoundDrawables()[3]);
    }

    public void clear() {
        setText("");
    }


    public void set(int width, int height) {

    }
}
