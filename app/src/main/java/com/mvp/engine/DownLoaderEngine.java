package com.mvp.engine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.mvp.DownloaderContract;
import com.mvp.model.ImageBean;
import com.mvp.presenter.DownLoaderPresenter;
import com.mvp.utils.Constant;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownLoaderEngine implements DownloaderContract.M {
    DownLoaderPresenter presenter;

    public DownLoaderEngine(DownLoaderPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void requestDownloader(ImageBean imageBean) throws Exception {
       new Thread(new DownLoader(imageBean)).start();
    }

    private class DownLoader implements Runnable{
        ImageBean imageBean;
        public DownLoader(ImageBean imageBean) {
            this.imageBean = imageBean;
        }

        @Override
        public void run() {
            URL url = null;
            try {
                url = new URL(imageBean.getRequestPath());
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5000);
                connection.setRequestMethod("GET");

                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                    InputStream inputStream = connection.getInputStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    showUi(Constant.SUCCESS,bitmap);
                } else {
                    showUi(Constant.ERROR,null);
                }
            } catch (Exception e) {
                e.printStackTrace();
                showUi(Constant.ERROR,null);
            }

        }
        private void showUi(int resultCode, Bitmap bitmap){
            imageBean.setBitmap(bitmap);
            presenter.responseDownloaderResult(resultCode == Constant.SUCCESS, imageBean);
        }
    }


}
