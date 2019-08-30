package com.daodian.mydialogtestavtivity;

import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.daodian.mydialogtestavtivity.databinding.LayoutMyDialogBinding;


public class MyDialogUtil {

    private AlertDialog dialog;
    private static MyDialogUtil myDialogUtil;
    private MyDialogUtil(){
    }

    public static MyDialogUtil getDialogUtils(){
        if(myDialogUtil == null){
            myDialogUtil = new MyDialogUtil();
        }

        return myDialogUtil;
    }


    /**
     * @param context
     * @param title         标题
     * @param content       内容
     * @param hint          编辑框提示信息
     * @param leftBtn       左边的文本按钮
     * @param rightBtn      右边的文本按钮
     */
    public void showDialog(final Context context, String title, String content, String hint, String leftBtn, String rightBtn){


        View view = LayoutInflater.from(context).inflate(R.layout.layout_my_dialog, null);



        TextView dialog_title = view.findViewById(R.id.dialog_title);
        TextView dialog_content = view.findViewById(R.id.dialog_content);
        final EditText dialog_edit = view.findViewById(R.id.dialog_edit);
        TextView cancel = view.findViewById(R.id.cancel);
        TextView confirm = view.findViewById(R.id.confirm);

        if (TextUtils.isEmpty(title)){
            dialog_title.setVisibility(View.GONE);
        }else{
            dialog_title.setText(title);
        }

        if (TextUtils.isEmpty(content)){
            dialog_content.setVisibility(View.GONE);
        }else{
            dialog_content.setText(content);
        }

        if (TextUtils.isEmpty(hint)){
            dialog_edit.setVisibility(View.GONE);
        }else{
            dialog_edit.setHint(hint);
        }


        cancel.setText(leftBtn);
        confirm.setText(rightBtn);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = dialog_edit.getText().toString();

                if (TextUtils.isEmpty(data)){
                    ToastUtil.getToast().showToast(context, "输入框不能为空");
                }else{
                    ToastUtil.getToast().showToast(context, data);
                    cancel();
                }

            }
        });

        initView(context, view, false, false);

    }


    /**
     * @param context
     * @param title         标题
     * @param content       内容
     * @param hint          编辑框提示信息
     * @param leftBtn       左边的文本按钮
     * @param rightBtn      右边的文本按钮
     */
    public void showDialog2(final Context context, String title, String content, String hint, String leftBtn, String rightBtn){

        LayoutMyDialogBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_my_dialog,null, false);



        if (TextUtils.isEmpty(title)){
            binding.dialogTitle.setVisibility(View.GONE);
        }else{
            binding.dialogTitle.setText(title);
        }

        if (TextUtils.isEmpty(content)){
            binding.dialogContent.setVisibility(View.GONE);
        }else{
            binding.dialogContent.setText(content);
        }

        if (TextUtils.isEmpty(hint)){
            binding.dialogEdit.setVisibility(View.GONE);
        }else{
            binding.dialogEdit.setHint(hint);
        }


        binding.cancel.setText(leftBtn);
        binding.confirm.setText(rightBtn);

        binding.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });

        binding.confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = binding.dialogEdit.getText().toString();

                if (TextUtils.isEmpty(data)){
                    ToastUtil.getToast().showToast(context, "输入框不能为空");
                }else{
                    ToastUtil.getToast().showToast(context, data);
                    cancel();
                }

            }
        });

        initView(context, binding.getRoot(), false, false);

    }



    /**
     *
     * @param context
     * @param view
     * @param canceledOnTouchOutside  点击外面是否消失 true点击外面可以消失
     * @param cancelable              false的话 点击屏幕和返回按键都不会消失 默认是true
     * @return
     */
    private AlertDialog initView(Context context, View view, boolean canceledOnTouchOutside, boolean cancelable){
        dialog = new AlertDialog.Builder(context, R.style.myDialog).create();
        dialog.setCanceledOnTouchOutside(canceledOnTouchOutside);
        dialog.setCancelable(cancelable);
        view.setLayoutParams(new WindowManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        dialog.setView(view, 0, 0, 0, 0);

        dialog.show();
        return dialog;

    }




    public void cancel(){
        if (dialog != null && dialog.isShowing()){
            dialog.cancel();
        }
        if (myDialogUtil != null){
            myDialogUtil = null;
        }
    }


}
