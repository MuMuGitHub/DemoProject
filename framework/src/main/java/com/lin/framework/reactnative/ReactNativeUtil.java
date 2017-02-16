package com.lin.framework.reactnative;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.lin.common.baseapp.ActivityStackManager;
import com.lin.framework.R;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by linweilin on 2017/2/16.
 */

public class ReactNativeUtil {
    private static final String TAG = ReactNativeUtil.class.getSimpleName();
    private static ReactNativeUtil mInstance;
    public static synchronized ReactNativeUtil getInstance() {
        if (mInstance == null) {
            mInstance = new ReactNativeUtil();
        }
        return mInstance;
    }


    public static void notSupportWarning(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        AlertDialog dialog = builder.setTitle(R.string.prompt)
                .setMessage(R.string.unknown_machine_warning)
                .setCancelable(false)
                .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityStackManager.getInstance().appExit();
                    }
                }).create();
        dialog.show();
    }

    public static boolean isSupport() {
        try {
            Class clazz = Class.forName("android.os.SystemProperties");
            Method method = clazz.getDeclaredMethod("get", String.class, String.class);
            return String.valueOf(method.invoke(null, "ro.product.cpu.abi", "")).indexOf("mips") == -1;
        } catch (ClassNotFoundException e) {
        } catch (NoSuchMethodException e) {
        } catch (InvocationTargetException e) {
        } catch (IllegalAccessException e) {
        }
        return true;
    }
}
