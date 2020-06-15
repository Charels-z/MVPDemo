package com.mvp.presenter;

import android.app.Activity;
import android.os.SystemClock;

import com.mvp.DownloaderContract;
import com.mvp.engine.DownLoaderEngine;
import com.mvp.model.ImageBean;

public class DownLoaderPresenter implements DownloaderContract.PV {
    private DownLoaderEngine model;
    private DownloaderContract.PV view;

    public DownLoaderPresenter(DownloaderContract.PV view) {
        this.view = view;
        model = new DownLoaderEngine(this);
    }

    @Override
    public void requestDownloader(ImageBean imageBean) {
//        if (model != null) {
//            try {
//                model.requestDownloader(imageBean);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(50000);
            }
        }).start();
    }

    @Override
    public void responseDownloaderResult(boolean isSuccess, ImageBean imageBean) {
        view.responseDownloaderResult(isSuccess,imageBean);
    }
}
