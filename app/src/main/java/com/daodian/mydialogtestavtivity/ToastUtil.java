package com.daodian.mydialogtestavtivity;

import android.content.Context;
import android.widget.Toast;

/**
 * 解决Toast多次弹出的问题
 */
public class ToastUtil {
    private Toast toast;
    private static ToastUtil toastUtil;

    private ToastUtil(){

    }

    public static ToastUtil getToast(){
        if(toastUtil == null){
            toastUtil = new ToastUtil();
        }
        return toastUtil;
    }

    public void showToast(final Context context, final String text) {
        if (toast == null && context != null) {
            toast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
        }
        toast.show();
    }

}
