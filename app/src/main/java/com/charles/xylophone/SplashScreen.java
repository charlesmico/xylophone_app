package com.charles.xylophone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    //Variables
    private static final int SPLASH_SCREEN_DURATION = 2000;
    private SharedPreferences sharedPreferences;

    //Views
    private ImageView iconImg;

    //Libraries

    //Animations
    private Animation fadeAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Change status bar background color
        getWindow().setStatusBarColor(getResources().getColor(R.color.white_shade));
        setContentView(R.layout.activity_splash_screen);

        initialize();
        splashScreen();

    }

    private void initialize() {
        iconImg = findViewById(R.id.assIcon_ImageView);
        fadeAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_animation);
        iconImg.setAnimation(fadeAnimation);
    }

    private void splashScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                SplashScreen.this.finish();
            }
        }, SPLASH_SCREEN_DURATION);
    }

}