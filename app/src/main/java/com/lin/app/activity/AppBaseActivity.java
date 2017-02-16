package com.lin.app.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;

import com.lin.common.net.RequestCallback;
import com.lin.framework.activity.BaseActivity;

public abstract class AppBaseActivity extends BaseActivity {

    protected boolean needCallback;

    protected ProgressDialog dlg;

    public abstract class AbstractRequestCallback implements RequestCallback {
        public abstract void onSuccess(String content);

        @Override
        public void onFail(String errorMessage) {
            dlg.dismiss();
            new AlertDialog.Builder(AppBaseActivity.this).setTitle("error")
                    .setMessage(errorMessage).setPositiveButton("确定", null)
                    .show();
        }
    }

}
