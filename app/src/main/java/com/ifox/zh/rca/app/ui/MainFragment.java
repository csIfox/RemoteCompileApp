package com.ifox.zh.rca.app.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.ifox.zh.rca.app.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;


/**
 * Created by zh on 2016/2/3.
 */
@EFragment(R.layout.fragment_main)
public class MainFragment extends Fragment {

    @ViewById(R.id.vp_main_content)
    protected ViewPager mContentPager;
}
