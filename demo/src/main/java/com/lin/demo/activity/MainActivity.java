package com.lin.demo.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

import com.lin.app.activity.AppBaseActivity;
import com.lin.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppBaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.content_main)
    RelativeLayout contentMain;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
