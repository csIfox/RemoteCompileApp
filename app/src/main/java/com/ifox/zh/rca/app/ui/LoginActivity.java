package com.ifox.zh.rca.app.ui;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

import com.ifox.zh.rca.app.R;
import com.ifox.zh.rca.app.util.StringUtils;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by zh on 2016/2/1.
 * @description 登陆界面  忘记密码 去注册 记住密码
 */

@EActivity(R.layout.activity_login)
public class LoginActivity extends Activity {

    @ViewById(R.id.et_login_account)
    EditText mAccount;

    @ViewById(R.id.et_login_password)
    EditText mPassword;

    @ViewById(R.id.btn_login_to_login)
    Button mLoginBtn;

    @Click(R.id.btn_login_to_login)
    void onToLogin() {
        checkAccount();
        checkPassword();
        toLogin();
    }

    private void checkAccount() {
        //TODO 检查输入账户的合法性
    }

    private void checkPassword() {
        //TODO 检查输入密码的合法性
    }

    private void toLogin() {
        String account = StringUtils.getString(mAccount);
        String password = StringUtils.getString(mPassword);
        try{

        } catch (Exception e) {

        }
    }

    void toMainActivity() {
        //TODO 去主界面
    }

}
