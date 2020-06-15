package com.improve.mvp.base;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseView<P extends BasePresenter, CONTRACT> extends Activity {
    protected P p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p = getPresenter();
        p.bindView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        p.unBindView();
    }

    // 让P层做什么需求
    public abstract CONTRACT getContract();

    public abstract P getPresenter();
}
