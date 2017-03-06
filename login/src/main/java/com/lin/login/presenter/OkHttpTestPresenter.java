package com.lin.login.presenter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.lin.login.view.ILoginView;

/**
 * Created by linweilin on 2017/3/6.
 */

public class OkHttpTestPresenter implements ILoginPresenter {
    private ILoginView mILoginView = null;
    private Context mContext;
    public OkHttpTestPresenter(ILoginView mILoginView,Context mContext) {
        this.mILoginView = mILoginView;
        this.mContext = mContext;
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1){
                Log.e("linwl","handler");
                mILoginView.setImg((Drawable) msg.obj);
                return true;
            }
            return false;
        }
    });

    @Override
    public void onShowImg() {


//                .subscribe(new Action1<Drawable>() {
//            @Override
//            public void call(Drawable drawable) {
//
//            }
//        });
        //创建okHttpClient对象
//        OkHttpClient mOkHttpClient = new OkHttpClient();
//        //创建一个Request
//        final Request request = new Request.Builder()
//                .url(UrlFactory.getWxUrl())
//                .build();
//        //new call
//        Call call = mOkHttpClient.newCall(request);
//        //请求加入调度
//        call.enqueue(new Callback() {
//
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("linwl","onFailure");
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Log.e("linwl","onResponse" + response.message() + response.body().string());
//                Message m = new Message();
//                m.what = 1;
//                Drawable d = mContext.getResources().getDrawable(R.mipmap.mac);
////                Bitmap b = new B
//                m.obj = d;
//                handler.sendMessage(m);
//            }
//        });

        getFingerprintManager(mContext).authenticate(null, null, 0, null, null);


    }

    public static FingerprintManager getFingerprintManager(Context context) {
        FingerprintManager fingerprintManager = null;
        try {
            fingerprintManager = (FingerprintManager) context.getSystemService(Context.FINGERPRINT_SERVICE);
        } catch (Throwable e) {
            Log.e("linwl","have not class FingerprintManager");
        }
        return fingerprintManager;
    }

    @Override
    public void onrecycle() {

    }
}
