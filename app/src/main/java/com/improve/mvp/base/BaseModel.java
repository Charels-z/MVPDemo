package com.improve.mvp.base;

public abstract class BaseModel<P extends BasePresenter, CONTRACT> {
    protected P p;

    public BaseModel(P p) {
        this.p = p;
    }
    public abstract CONTRACT getContract();
}
