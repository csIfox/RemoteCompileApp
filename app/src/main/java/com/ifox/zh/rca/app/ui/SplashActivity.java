package com.ifox.zh.rca.app.ui;

import android.app.Activity;
import android.os.Bundle;

import com.ifox.zh.rca.app.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;

/**
 * Created by zh on 2016/2/1.
 * @description 启动界面
 */
@EActivity(R.layout.actvity_splash)
public class SplashActivity extends Activity {

    @AfterViews
    @UiThread(delay = 1000)
    void toGuideActivity() {
        GuideActivity_.intent(this).start();
        this.finish();
    }
}
