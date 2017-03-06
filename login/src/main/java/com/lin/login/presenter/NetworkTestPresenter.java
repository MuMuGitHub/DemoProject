package com.lin.login.presenter;

import com.lin.common.net.RequestCallback;
import com.lin.common.net.RequestManager;
import com.lin.common.net.URLData;
import com.lin.common.net.UrlFactory;

/**
 * Created by linweilin on 2017/3/6.
 */

public class NetworkTestPresenter implements ILoginPresenter {

    @Override
    public void onShowImg() {
        URLData urlData = new URLData();
        urlData.setUrl(UrlFactory.getWxUrl());
        urlData.setExpires(1000);
        RequestManager.getInstance().createRequest(urlData, new RequestCallback() {
            @Override
            public void onSuccess(String content) {

            }

            @Override
            public void onFail(String errorMessage) {

            }
        });
//        requestManager.createRequest()
    }

    @Override
    public void onrecycle() {

    }
}
