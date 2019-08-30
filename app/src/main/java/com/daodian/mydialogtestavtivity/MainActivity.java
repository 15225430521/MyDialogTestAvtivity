package com.daodian.mydialogtestavtivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;

import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btn1)
    public void btn1(){
        MyDialogUtil.getDialogUtils().showDialog2(this, "", "内容", "", "确定", "");
    }

    @OnClick(R.id.btn2)
    public void btn2(){
        MyDialogUtil.getDialogUtils().showDialog2(this, "", "", "提示信息", "", "确定");
    }

    @OnClick(R.id.btn3)
    public void btn3(){
        MyDialogUtil.getDialogUtils().showDialog2(this, "标题", "内容", "提示信息", "取消", "确定");
    }

    @OnClick(R.id.btn4)
    public void btn4(){
        Dialog dialog = new Dialog(this, R.style.myDialog);
        View view = View.inflate(this, R.layout.layout_my_dialog, null);
        dialog.setContentView(view);

        dialog.show();


    }



}
