package com.lin.login.presenter;

import android.content.Context;
import android.util.Log;

import com.lin.login.bean.LoginInfo;
import com.lin.login.view.ILoginView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by linweilin on 2017/3/3.
 */

public class TestPresenter implements ILoginPresenter {
    private ILoginView mILoginView = null;
    private Context mContext;

    public TestPresenter(ILoginView mILoginView, Context context) {
        this.mILoginView = mILoginView;
        mContext = context;
    }

    @Override
    public void onShowImg() {
        LoginInfo loginInfo = new LoginInfo("1");
        LoginInfo loginInfo2 = new LoginInfo("2");
        LoginInfo loginInfo3 = new LoginInfo("3");
        LoginInfo loginInfo4 = new LoginInfo("4");
        LoginInfo loginInfo5 = new LoginInfo("5");
        LoginInfo loginInfo6 = new LoginInfo("6");

        List<LoginInfo> infos = new ArrayList<>();
        infos.add(loginInfo);
        infos.add(loginInfo2);
        infos.add(loginInfo3);
        infos.add(loginInfo4);
        infos.add(loginInfo5);
        infos.add(loginInfo6);

        Observable.from(infos).map(new Func1<LoginInfo, String>() {
            @Override
            public String call(LoginInfo loginInfo) {
                return loginInfo.getSessionId();
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String o) {
                Log.e("linwl",o);
            }
        });
    }

    @Override
    public void onrecycle() {

    }
}
