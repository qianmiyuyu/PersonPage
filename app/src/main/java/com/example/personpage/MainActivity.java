package com.example.personpage;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.CountListener;
import cn.bmob.v3.listener.FindListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public TextView UserName;
    public TextView GroupName;
    public TextView GroupNumber;
    public TextView CalendarNumber;
    public Button Image;
    public Button add_group;
    public Button invite_person;
    public Button switch_group;
    public Button quit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collasping_toobar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        UserName=(TextView)findViewById(R.id.username);
        GroupName=(TextView)findViewById(R.id.nowGroup);
        GroupNumber=(TextView)findViewById(R.id.value_groupnumber);
        CalendarNumber=(TextView)findViewById(R.id.value_notenumber);
        Image=(Button)findViewById(R.id.setImage);
        add_group=(Button)findViewById(R.id.addGroup);
        invite_person=(Button)findViewById(R.id.joinGroup);
        switch_group=(Button)findViewById(R.id.SwitchGroup);
        quit=(Button)findViewById(R.id.quit);

        Image.setOnClickListener(this);
        add_group.setOnClickListener(this);
        invite_person.setOnClickListener(this);
        switch_group.setOnClickListener(this);
        quit.setOnClickListener(this);

        //-----初始化数据与更新UI--
        initName_Group("a","1");
        initCalendarNumber("1");
        initGroupNumber("aa");
    }
    public void initName_Group(String username,String groupname){
        UserName.setText(username);
        GroupName.setText("现在所在小组："+groupname);
    }
    public void initGroupNumber(String username){
        BmobQuery<Group> query = new BmobQuery<Group>();
        String [] user = {username};
        query.addWhereContainsAll("member", Arrays.asList(user));
        query.findObjects(new FindListener<Group>() {

            @Override
            public void done(List<Group> object,BmobException e) {
                if(e==null){
                    String a=""+object.size();
                    GroupNumber.setText(a);
                }else{
                    Log.i("bmob","失败："+e.getMessage());
                }
            }

        });
    }
    public void initCalendarNumber(String groupname){
        BmobQuery<Calendar> query = new BmobQuery<Calendar>();
        query.addWhereEqualTo("GroupName", groupname);
        query.count(Calendar.class, new CountListener() {
            @Override
            public void done(Integer count, BmobException e) {
                if(e==null){
                    CalendarNumber.setText(count.toString());
                }else{
                    Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.setImage:{}
                break;
            case R.id.addGroup:{
                MyDialog myDialog=new MyDialog(this,"1","新建小组");
                myDialog.show();
            }
                break;
            case R.id.joinGroup:{
                MyDialog myDialog=new MyDialog(this,"1","邀请成员");
                myDialog.show();
            }
                break;
            case R.id.SwitchGroup:{

            }
                break;
            case R.id.quit:{}
                break;
        }
    }
}
