package com.example.basicbankapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.basicbankapp.R;

public class SplashScreen extends AppCompatActivity {


    TextView txtBanking,txtSystem;
    RelativeLayout relativeLayout;
    Animation txtAnimation,layoutAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        txtAnimation = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.full_down);
        layoutAnimation = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.bottom_to_top);

        txtBanking = findViewById(R.id.txtBank);
        txtSystem = findViewById(R.id.txtSystem);

        relativeLayout = findViewById(R.id.relMain);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                relativeLayout.setVisibility(View.VISIBLE);
                relativeLayout.setAnimation(layoutAnimation);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        txtBanking.setVisibility(View.VISIBLE);
                        txtSystem.setVisibility(View.VISIBLE);

                        txtBanking.setAnimation(txtAnimation);
                        txtSystem.setAnimation(txtAnimation);
                    }
                },900);
            }
        },500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },6000);
    }
}