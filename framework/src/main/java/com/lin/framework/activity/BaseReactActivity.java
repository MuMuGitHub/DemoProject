package com.lin.framework.activity;

import com.facebook.react.ReactActivity;

import javax.annotation.Nullable;

public class BaseReactActivity extends ReactActivity{
    @Nullable
    @Override
    protected String getMainComponentName() {
        return "demoReact";
    }
}
