package com.lin.framework.app;

import android.app.Application;
import android.content.Context;

import com.lin.framework.InitManager;
import com.lin.framework.base.AppLifecycleCallback;

import java.util.Map;

/**
 * Created by linweilin on 2017/2/20.
 */

public class BaseApplication extends Application implements InitManager.InitDelegate{


    @Override
    public void initReactNative() {

    }


    public static InitManager.InitDelegate initDelegate(Context context){
        Application app = (Application) context.getApplicationContext();
        return (app instanceof InitManager.InitDelegate)?(InitManager.InitDelegate)app:null;
    }

    @Override
    public Map<String, String> getKeys() {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        InitManager.initInApplication(this,this);
        this.registerActivityLifecycleCallbacks(new AppLifecycleCallback());

    }
}
