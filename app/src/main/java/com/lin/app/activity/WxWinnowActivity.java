package com.lin.app.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.lin.app.R;
import com.lin.app.WXBinding;
import com.lin.app.bean.WxModel;
import com.lin.common.net.UrlFactory;
import com.lin.framework.activity.BaseActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by linweilin on 2017/3/10.
 */

public class WxWinnowActivity extends BaseActivity {

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected int getContentViewId() {
        return 0;
    }

    @Override
    protected void initVariables() {
        WXBinding wxBinding = DataBindingUtil.setContentView(this, R.layout.activity_wxwinnow);
//        wxBinding.set(x);
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("size","10")
                .build();
        Request request = new Request.Builder()
                .url(UrlFactory.getWxUrl())
                .post(formBody)
                .build();
        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.e("linwl","success : " + str);
                WxModel wxModel = (WxModel) JSON.parse(str);
                Message message = new Message();
                message.what = 1;
//                message.obj = wxModel;
                handler.sendMessage(message);

            }
        });
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected void loadData() {

    }
}
