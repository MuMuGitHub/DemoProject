package com.lin.framework;

import android.app.Application;
import android.content.Context;

import com.lin.common.baseapp.AppUtils;
import com.lin.framework.reactnative.ReactNativeUtil;

import java.util.Map;

/**
 * Created by linweilin on 2017/2/22.
 */

public class InitManager {
    private static final String TAG = "InitManager";

    public interface InitDelegate {
        void initReactNative();
        Map<String, String> getKeys();
    }

    private InitManager() {
    }

    public static boolean isInit = false;

    /**
     * step 1.
     * 初始化基础框架，在Application中调用。
     */
    public static void initInApplication(Application application, InitDelegate delegate) {
        if (application == null || delegate == null) {
            throw new IllegalArgumentException("init argument can not be null,but application:" + application + ",delegate:" + delegate);
        }
        AppUtils.getInstance().init(application);
    }

    /**
     * step 2.
     * 在Activity中初始化配置信息
     *
     * @param delegate 初始化SDK
     */
    public static void initInActivity(Context context, final InitDelegate delegate) {
        if (context == null || delegate == null) {
            throw new IllegalArgumentException("init argument can not be null,but context:" + context + ",delegate:" + delegate);
        }
        final Application application = (Application)context.getApplicationContext();
        if (!AppUtils.isInMainProcess(application)){
            return;
        }
        if(!isInit ) {
//            initInMainThread(application,delegate);
            InitManager.isInit = true;
        }
    }

    /**
     * 在主线程中执行
     */
    private static void initInMainThread(Application application, InitDelegate delegate) {
        delegate.initReactNative();                 //模块注册需放主线程(否则会报warning)
        ReactNativeUtil.getInstance().init(application);
    }


}
