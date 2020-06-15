package com.improve.mvp.login;

import com.improve.mvp.bean.BaseEntity;

public interface LoginContract {
    interface Model{
        void executeLogin(String name, String password);
    }
    interface View<T extends BaseEntity>{
        void handlerResult(T t);
    }
    interface Presenter<T extends BaseEntity>{
        // 登录请求（接收到View层指令，可以自己做，也可以让Model层去执行)
        void requestLogin(String name, String password);
        // 结果响应（接收到Model层处理的结果，通知View层刷新）
        void responseResult(T t);
    }
}
