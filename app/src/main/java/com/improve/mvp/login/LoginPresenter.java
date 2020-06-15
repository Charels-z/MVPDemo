package com.improve.mvp.login;

import android.os.SystemClock;

import com.improve.mvp.LoginActivity;
import com.improve.mvp.base.BasePresenter;
import com.improve.mvp.bean.UserInfo;

public class LoginPresenter extends BasePresenter<LoginModel, LoginActivity,LoginContract.Presenter> {

    @Override
    public LoginContract.Presenter getContract() {
        return new LoginContract.Presenter<UserInfo>() {
            @Override
            public void requestLogin(String name, String password) {
                // 交由Model层处理
//                m.getContract().executeLogin(name,password);

                // 交由子模块处理
//                HttpEngine engine = new HttpEngine<>(LoginPresenter.this);
//                engine.post(name, password);

                // 内存泄露测试
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(50000);
                    }
                }).start();

            }

            @Override
            public void responseResult(UserInfo userInfo) {
                getView().getContract().handlerResult(userInfo);
            }
        };
    }

    @Override
    public LoginModel getModel() {
        return new LoginModel(this);
    }
}
