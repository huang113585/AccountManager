package com.example.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.Bean.User;
import com.example.accountmanager.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

import static com.example.accountmanager.R.layout.activity_splash;

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_splash);

        //延时操作
        Timer timer = new Timer();
        timer.schedule(timetask,2000);

        Bmob.initialize(this,"1b42d158118b8d63a9fae5079db4085a");


    }
        TimerTask timetask = new TimerTask() {
            @Override
            public void run() {
//                startActivity(new Intent(Splash.this, MainActivity.class));
                BmobUser bmobUser = BmobUser.getCurrentUser(User.class);
                if (bmobUser !=null){
                    startActivity(new Intent(Splash.this,MainActivity.class));
                    finish();
                }else {
                    //没有登录，跳转到登录界面
                    startActivity(new Intent(Splash.this,Login.class));
                    finish();
                }
            }
        };




}
