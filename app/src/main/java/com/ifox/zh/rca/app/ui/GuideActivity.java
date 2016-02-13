package com.ifox.zh.rca.app.ui;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ifox.zh.rca.app.R;
import com.ifox.zh.rca.app.adapter.CommonPagerAdapter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.Arrays;

/**
 * Created by zh on 2016/2/1.
 *
 * @description 引导界面 一般用viewpager 加 小圆点使用
 */
@EActivity(R.layout.activity_guide)
public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener {

    private static final String TAG = GuideActivity.class.getSimpleName();
    @ViewById(R.id.vp_guide)
    protected ViewPager mPager;

    @ViewById(R.id.v_guide_focus_dot)
    protected View mFocusDot;

    @ViewById(R.id.ll_guide_dot_container)
    protected LinearLayout mDotContainer;

    @ViewById(R.id.btn_guide_start)
    protected Button mStartBtn;

    protected View[] mGuideImages;

    protected int dotWidth;

    int[] mImageIds = {R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};

    @AfterInject
    void init() {
        mGuideImages = new ImageView[mImageIds.length];
        int index = 0;
        for (int id : mImageIds) {
            Log.e(TAG, "index " + index + mImageIds[index]);
            ImageView temp = new ImageView(this);
            temp.setLayoutParams(new ViewPager.LayoutParams());
            temp.setImageResource(id);
            temp.setScaleType(ImageView.ScaleType.FIT_XY);
            mGuideImages[index] = temp;
            index++;
        }
    }

    @AfterViews
    void setPagerAdapter() {
        mPager.setAdapter(new CommonPagerAdapter(Arrays.asList(mGuideImages)));
    }

    @AfterViews
    void initNormalDots() {
        mFocusDot.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {
                for (int index = 0; index < mGuideImages.length; index++) {
                    View dot = new View(GuideActivity.this);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dotWidth = mFocusDot.getWidth(), mFocusDot.getHeight());
                    params.leftMargin = index == 0 ? 0 : mFocusDot.getWidth();
                    dot.setBackgroundResource(R.drawable.guide_dot_normal);
                    Log.e(TAG, "w " + mFocusDot.getWidth() + "h " + mFocusDot.getHeight());
                    mDotContainer.addView(dot, params);
                }
                mFocusDot.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @AfterViews
    void setListener() {
        mPager.addOnPageChangeListener(this);
    }

    @Click(R.id.btn_guide_start)
    void start() {
        MainActivity_.intent(this).start();
        finish();
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mFocusDot.getLayoutParams();
        params.leftMargin = (int) ((position + positionOffset) * 2 * dotWidth + 0.5f);
        mFocusDot.setLayoutParams(params);
    }

    @Override
    public void onPageSelected(int position) {
        boolean show = false;
        if(position == mGuideImages.length - 1) {
          show = true;
        }
        mStartBtn.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
        mStartBtn.setEnabled(show);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
