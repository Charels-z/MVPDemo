package com.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.mvp.model.ImageBean;
import com.mvp.presenter.DownLoaderPresenter;
import com.mvp.utils.Constant;

public class MainActivity extends AppCompatActivity implements DownloaderContract.PV {

    private ImageView imageView;
    private DownLoaderPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.iv);
        presenter = new DownLoaderPresenter(this);
    }

    // 点击事件
    public void down(View view) {
        ImageBean imageBean = new ImageBean();
        imageBean.setRequestPath(Constant.IMAGE_PATH);
        requestDownloader(imageBean);
    }

    @Override
    public void requestDownloader(ImageBean imageBean) {
        if (presenter != null)
            presenter.requestDownloader(imageBean);
    }

    @Override
    public void responseDownloaderResult(final boolean isSuccess, final ImageBean imageBean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, isSuccess ? "下载成功" : "下载失败", Toast.LENGTH_SHORT).show();
                if (isSuccess && imageBean.getBitmap() != null) {
                    imageView.setImageBitmap(imageBean.getBitmap());
                }
            }
        });
    }
}
