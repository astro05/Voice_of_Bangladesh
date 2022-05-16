package com.example.voiceofbangladesh;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro);
        final ImageView imageView = findViewById(R.id.mapID);
        final TextView textView=findViewById(R.id.introTextID);
        final RelativeLayout relativeLayout = findViewById(R.id.introID);
        final Animation fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadine);
        final Animation fadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadeout);
        imageView.startAnimation(fadeIn);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.startAnimation(fadeOut);

            }
        }, 4000);
        final Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                relativeLayout.setBackgroundResource(R.drawable.black_gradient);
                relativeLayout.startAnimation(fadeIn);
                imageView.setBackgroundResource(R.drawable.bangladeshinvert);
                imageView.startAnimation(fadeIn);
                textView.setTextColor(getResources().getColor(R.color.colorWhite));
                textView.startAnimation(fadeIn);

            }
        }, 8000);
        final Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(12000);
                    Intent intent = new Intent(IntroActivity.this, Home.class);

                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
        thread.start();
    }
}
