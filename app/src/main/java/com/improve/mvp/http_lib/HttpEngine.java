package com.improve.mvp.http_lib;

import com.improve.mvp.bean.UserInfo;
import com.improve.mvp.login.LoginPresenter;

public class HttpEngine<P extends LoginPresenter> {

    private P p;

    public HttpEngine(P p) {
        this.p = p;
    }

    public void post(String name, String pwd) {
        if ("netease".equalsIgnoreCase(name) && "163".equals(pwd)) {
            p.getContract().responseResult(new UserInfo("网易", "彭老师"));
        } else {
            p.getContract().responseResult(null);
        }
    }
}
