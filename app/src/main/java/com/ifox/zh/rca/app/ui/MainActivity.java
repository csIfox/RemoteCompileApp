package com.ifox.zh.rca.app.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import com.ifox.zh.rca.app.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by zh on 2016/2/2.
 * @description 主界面 所有activity返回的最终的界面
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends FragmentActivity {

    public static final String TAG = FragmentActivity.class.getSimpleName();

    @ViewById(R.id.v_main_title_bar)
    protected View mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null) {
            Fragment contentContainer = MainFragment_.builder().build();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_main_content_container, contentContainer);
            fragmentTransaction.commit();
        }
    }

    @Click(R.id.v_main_title_bar)
    void toLogin() {
        Log.i(TAG, "去登陆");
        LoginActivity_.intent(this).start();
    }
}
