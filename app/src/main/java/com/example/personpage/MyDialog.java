package com.example.personpage;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class MyDialog extends Dialog{
    private String title;
    private EditText edt_title;
    private TextView tv_title;
    private Button btnOK;
    private Button btnCancel;
    private String storeid;
    public MyDialog(Context context,String storeid,String dialogName) {
        super(context);
        this.title = dialogName;
        this.storeid = storeid;
    }

    public MyDialog(Context context,String storeid) {
        super(context);
        this.title = "图片";
        this.storeid = storeid;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.addgroup_layout);
        Bmob.initialize(this.getContext(),"03de14ff4bda451ee3108a1070c21129");

        edt_title = (EditText) findViewById(R.id.edt_title);
        tv_title=(TextView)findViewById(R.id.tv_title);
        btnOK = (Button) findViewById(R.id.btn_ok);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
        tv_title.setText(title);
        tv_title.setTextColor(Color.WHITE);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               switch(title){
                   case "新建小组":{
                       addGroup();
                   }break;
                   case "邀请成员":{
                       inviteMember();
                   }break;
               }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }


    public void addGroup(){

    }
    public void inviteMember(){

    }

}