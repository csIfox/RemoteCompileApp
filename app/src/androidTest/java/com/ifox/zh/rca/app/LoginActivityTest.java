package com.ifox.zh.rca.app;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.ifox.zh.rca.app.ui.LoginActivity_;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by zh on 2016/2/13.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

    public static final String LOGIN_TEXT = "zhzhzhz";
    /**
     * 测试界面获取
     */
    @Rule
    public ActivityTestRule<LoginActivity_> mLoginActivityRule = new ActivityTestRule<LoginActivity_>(
            LoginActivity_.class
    );

    /**
     * 输入edit_text 测试用例
     * @throws Exception
     */
    @Test
    public void inputTest() throws  Exception {
      onView(withId(R.id.et_login_account))
              .perform(ViewActions.typeText(
                      LOGIN_TEXT));
        Thread.sleep(5000);
    }



}
