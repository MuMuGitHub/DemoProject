package com.lin.framework.activity;

import android.app.Activity;
import android.os.Bundle;

import com.lin.common.baseapp.ActivityStackManager;

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStackManager.getInstance().addActivity(this);
        setContentView(getContentViewId());
        initVariables();
        initViews(savedInstanceState);
        loadData();
    }
    //获取布局id
    protected abstract int getContentViewId();
    //初始化变量
    protected abstract void initVariables();
    //初始化view
    protected abstract void initViews(Bundle savedInstanceState);
    //获取数据
    protected abstract void loadData();

    @Override
    protected void onResume() {
        super.onResume();
        ActivityStackManager.getInstance().setTopActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityStackManager.getInstance().finishActivity(this);
    }
}
