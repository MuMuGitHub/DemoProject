package com.lin.login.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lin.common.activity.BaseActivity;
import com.lin.login.R;
import com.lin.login.presenter.ILoginPresenter;
import com.lin.login.presenter.OkHttpTestPresenter;
import com.lin.login.view.ILoginView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements View.OnClickListener, ILoginView {

    Button button;
    ILoginPresenter loginPresenter = null;


    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initVariables() {
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        button.setOnClickListener(this);
        String imageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489321408195&di=5db2207174a917c50d768f4e3dd292c9&imgtype=0&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ff703738da97739121c70e72dfa198618367ae22c.jpg";
        ImageSize imageSize = new ImageSize(100, 500);
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher) // resource or drawable
                .showImageForEmptyUri(R.mipmap.ic_launcher) // resource or drawable
                .showImageOnFail(R.mipmap.ic_launcher) // resource or drawable
                .resetViewBeforeLoading(false)  // default
                .delayBeforeLoading(1000)
                .cacheInMemory(false) // default
                .cacheOnDisk(false) // default
                .considerExifParams(false) // default
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
                .displayer(new SimpleBitmapDisplayer()) // default
                .handler(new Handler()) // default
                .build();

//        ImageLoader.getInstance().loadImage(imageUrl, imageSize,options,new ImageLoadingListener() {
//
//            @Override
//            public void onLoadingStarted(String imageUri, View view) {
//                Log.e("linwl","onLoadingStarted");
//            }
//
//            @Override
//            public void onLoadingFailed(String imageUri, View view,
//                                        FailReason failReason) {
//                Log.e("linwl","onLoadingFailed" + failReason.getCause().toString());
//
//            }
//
//            @Override
//            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//                ((ImageView)findViewById(R.id.iv_img)).setImageBitmap(loadedImage);
//                Log.e("linwl","onLoadingComplete");
//
//            }
//
//            @Override
//            public void onLoadingCancelled(String imageUri, View view) {
//                Log.e("linwl","onLoadingCancelled");
//
//            }
//        });
//
        ImageLoader.getInstance().displayImage(imageUrl, (ImageView) findViewById(R.id.iv_img), options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                Log.e("linwl", "onLoadingStarted");

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                Log.e("linwl", "onLoadingFailed");

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                Log.e("linwl", "onLoadingComplete");

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                Log.e("linwl", "onLoadingCancelled");

            }
        }, new ImageLoadingProgressListener() {
            @Override
            public void onProgressUpdate(String imageUri, View view, int current, int total) {
                Log.e("linwl", " total   : " + total + "current   : " + current);
            }
        });


    }

    @Override
    protected void loadData() {
        loginPresenter = new OkHttpTestPresenter(this, this);
    }

    @Override
    public void onClick(View v) {
        Log.e("linwl", "click2");

        if (v.getId() == R.id.bt_setimg) {
            Log.e("linwl", "click");
            loginPresenter.onShowImg();
//            findViewById(R.id.iv_img).setBackground(getResources().getDrawable(R.mipmap.mac));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void setImg(Drawable drawable) {

        if (drawable == null) {
            Log.e("linwl", "drawabledrawable");

        }
        findViewById(R.id.iv_img).setBackground(drawable);
    }

    @Override
    protected void onDestroy() {
        loginPresenter.onrecycle();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
