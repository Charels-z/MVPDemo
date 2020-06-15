package com.improve.mvp.login;

import com.improve.mvp.base.BaseModel;
import com.improve.mvp.bean.UserInfo;

public class LoginModel extends BaseModel<LoginPresenter,LoginContract.Model> {

    public LoginModel(LoginPresenter loginPresenter) {
        super(loginPresenter);
    }

    @Override
    public LoginContract.Model getContract() {
        return new LoginContract.Model() {
            @Override
            public void executeLogin(String name, String password) {
                if ("xzzz".equalsIgnoreCase(name) && "123456".equals(password)) {
                    p.getContract().responseResult(new UserInfo("company", "charles"));
                } else {
                    p.getContract().responseResult(null);
                }
            }
        };
    }
}
