package com.lin.login.presenter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.lin.login.R;
import com.lin.login.bean.LoginInfo;
import com.lin.login.view.ILoginView;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by linweilin on 2017/3/2.
 */

public class LoginPresenter {
    private ILoginView mILoginView = null;

    private Subscriber<Object> subscriber = null;
    private Observer<Object> observer = null;
    private Observable observable = null;
    private Context mContext;
    public LoginPresenter(ILoginView mILoginView,Context context) {
        this.mILoginView = mILoginView;
        mContext = context;
    }

    public void onShowImg(){
//观察者
        observer = new Observer<Object>() {
            @Override
            public void onCompleted() {
                Log.e("linwl","observer completed");

            }

            @Override
            public void onError(Throwable e) {
                Log.e("linwl","observer onError");

            }

            @Override
            public void onNext(Object s) {
                if (s instanceof String)
                    Log.e("linwl","observer onNext" + s);
                if (s instanceof LoginInfo){
                    Log.e("linwl","observer " + ((LoginInfo) s).getSessionId());
                }

            }
        };


        //观察者的抽象类
        subscriber = new Subscriber<Object>() {
            @Override
            public void onCompleted() {
                Log.e("linwl","Subscriber completed");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("linwl","Subscriber onError" + e);

            }

            @Override
            public void onNext(Object s) {
                if (s instanceof String)
                    Log.e("linwl","Subscriber onNext" + s);
                if (s instanceof LoginInfo){
                    Log.e("linwl","Subscriber " +((LoginInfo) s).getSessionId());
                }
                if (s instanceof Drawable){
                    mILoginView.setImg((Drawable) s);
                }

            }


            @Override
            public void onStart() {
                super.onStart();
                Log.e("linwl","Subscriber onStart");
            }



        };
        //被观察者 创建方式1
        Observable.create(new Observable.OnSubscribe<Object>(){
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                Drawable drawable = mContext.getResources().getDrawable(R.mipmap.mac);
                subscriber.onNext(drawable);
//                subscriber.onNext("good");
//                LoginInfo loginInfo = new LoginInfo();
//                loginInfo.setSessionId("123");
//                subscriber.onNext(loginInfo);
                subscriber.onCompleted();
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(subscriber);
        //被观察者创建方式2
//        observable = Observable.just("good good","study");
        //被观察者创建方式3
//        String[] words = {"Hello", "Hi", "Aloha"};
//        observable = Observable.from(words);


        //注册观察者
//        observable.subscribe(observer);
//        observable.subscribe(subscriber);

//        Action1<Object> onNextAction = new Action1<Object>() {
//            // onNext()
//            @Override
//            public void call(Object s) {
//                if (s instanceof String)
//                    Log.e("linwl","Subscriber onNext" + s);
//                if (s instanceof LoginInfo){
//                    Log.e("linwl","Subscriber " +((LoginInfo) s).getSessionId());
//                }
//
//            }
//        };
//        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
//            // onError()
//            @Override
//            public void call(Throwable throwable) {
//                // Error handling
//            }
//        };
//        Action0 onCompletedAction = new Action0() {
//            // onCompleted()
//            @Override
//            public void call() {
//                Log.d("linwl", "completed");
//            }
//        };

// 自动创建 Subscriber ，并使用 onNextAction 来定义 onNext()
//        observable.subscribe(onNextAction);
// 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
//        observable.subscribe(onNextAction, onErrorAction);
// 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
//        observable.subscribe(onNextAction, onErrorAction, onCompletedAction);



    }

    public void onrecycle(){
        mILoginView = null;
        if (!subscriber.isUnsubscribed()){
            subscriber.unsubscribe();
        }
    }
}
