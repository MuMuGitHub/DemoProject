package com.lin.login.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lin.framework.activity.BaseActivity;
import com.lin.login.R;
import com.lin.login.presenter.ILoginPresenter;
import com.lin.login.presenter.OkHttpTestPresenter;
import com.lin.login.view.ILoginView;

public class LoginActivity extends BaseActivity implements View.OnClickListener,ILoginView{


    Button button = null;
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
        button = (Button) findViewById(R.id.bt_setimg);
        button.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        loginPresenter = new OkHttpTestPresenter(this,this);
    }

    @Override
    public void onClick(View v) {
        Log.e("linwl","click2");

        if (v.getId() == R.id.bt_setimg){
            Log.e("linwl","click");
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

     if (drawable == null){
         Log.e("linwl","drawabledrawable");

     }
        findViewById(R.id.iv_img).setBackground(drawable);
    }

    @Override
    protected void onDestroy() {
        loginPresenter.onrecycle();
        super.onDestroy();
    }
}
