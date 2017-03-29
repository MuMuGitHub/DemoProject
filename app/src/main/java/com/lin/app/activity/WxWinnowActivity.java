package com.lin.app.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.lin.app.R;
import com.lin.app.adapter.WxAdapter;
import com.lin.app.bean.WxItemModel;
import com.lin.app.bean.WxModel;
import com.lin.common.net.UrlFactory;
import com.lin.common.view.DividerItemDecoration;
import com.lin.common.activity.BaseActivity;

import java.io.IOException;
import java.util.List;

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
            if (msg.what == 1){
                mWxAdapter = new WxAdapter((List<WxItemModel>)msg.obj);
                mRecyclerView.setAdapter(mWxAdapter);
            }
        }
    };
    private RecyclerView mRecyclerView = null;
    private WxAdapter mWxAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_wxwinnow;
    }

    @Override
    protected void initVariables() {
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_wx);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
    }

    @Override
    protected void loadData() {
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
                Log.e("linwl", "success : " + str);
                WxModel wxModel = new Gson().fromJson(str, WxModel.class);
                Log.e("linwl", "wxmodel................." +
                        "" +
                        "");
                Log.e("linwl", "wxmodel" + wxModel.toString());
                Log.e("linwl", "wxmodel" + wxModel.getResult());
                Log.e("linwl", "wxmodel" + wxModel.getError_code());
                Log.e("linwl", "wxmodel" + wxModel.getReason());
                Log.e("linwl", "wxmodel" + wxModel.getResult().getTotalPage());
                Log.e("linwl", "wxmodel" + wxModel.getResult().getList().get(1).getFirstImg());


                Message message = new Message();
                message.what = 1;
                message.obj = wxModel.getResult().getList();
                handler.sendMessage(message);
            }
        });



    }
}
//        Retrofit retrofit = new Retrofit.Builder()
//
//                .baseUrl(UrlFactory.getWxUrl())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        IWxItem wxItem = retrofit.create(IWxItem.class);
//        retrofit2.Call<List<WxItemModel>> call1 = wxItem.getItems();
//        call1.enqueue(new retrofit2.Callback<List<WxItemModel>>() {
//            @Override
//            public void onResponse(retrofit2.Call<List<WxItemModel>> call, retrofit2.Response<List<WxItemModel>> response) {
//                Log.e("linwl",response.body().toString());
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call<List<WxItemModel>> call, Throwable t) {
//
//            }
//        });