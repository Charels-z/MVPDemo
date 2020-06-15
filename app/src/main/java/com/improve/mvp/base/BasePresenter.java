package com.improve.mvp.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<M extends BaseModel,V extends BaseView,CONTRACT> {
    protected M m;
    private WeakReference<V> vWeakReference;

    public BasePresenter() {
        m = getModel();
    }
    public void bindView(V v) {
        vWeakReference = new WeakReference<>(v);
    }

    public void unBindView() {
        if (vWeakReference!=null){
            vWeakReference.clear();
            vWeakReference = null;
            System.gc();
        }
    }

    protected V getView(){
        if (vWeakReference != null) {
            return vWeakReference.get();
        }
        return null;
    }

    public abstract CONTRACT getContract();
    public abstract M getModel();
}
