package com.improve.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.improve.mvp.base.BaseView;
import com.improve.mvp.bean.UserInfo;
import com.improve.mvp.login.LoginContract;
import com.improve.mvp.login.LoginPresenter;
import com.mvp.R;

public class LoginActivity extends BaseView<LoginPresenter, LoginContract.View> {
    private EditText nameEt;
    private EditText pwdEt;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    // 初始化控件
    private void initView() {
        nameEt = findViewById(R.id.et_name);
        pwdEt = findViewById(R.id.et_pwd);
        btn = findViewById(R.id.bt_login);
    }

    // 点击事件
    public void doLoginAction(View view) {
        String name = nameEt.getText().toString();
        String pwd = pwdEt.getText().toString();
        // 发起需求，让Presenter处理
        p.getContract().requestLogin(name, pwd);
    }

    @Override
    public LoginContract.View<UserInfo> getContract() {
        return new LoginContract.View<UserInfo>() {
            @Override
            public void handlerResult(UserInfo userInfo) {
                if (userInfo != null) {
                    Toast.makeText(LoginActivity.this, userInfo.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "登录失败！", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }
}
