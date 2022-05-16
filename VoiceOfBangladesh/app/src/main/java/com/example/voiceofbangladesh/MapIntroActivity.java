package com.example.voiceofbangladesh;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import pl.droidsonroids.gif.GifImageView; //gif
import java.io.IOException;
import java.io.InputStream;

public class MapIntroActivity extends Activity {

    private GifImageView intro_bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_intro);
        intro_bd = (GifImageView) findViewById(R.id.Map_intro);
        Animation intro_anim = AnimationUtils.loadAnimation(this,R.anim.intro_transition);
        intro_bd.startAnimation(intro_anim);

        final Intent i=new Intent(this,LoginRegistrationActivity.class);
       // final Intent i=new Intent(this,Home.class);

        final Thread intro = new Thread(){
            public void run(){
                try {
                    sleep(5000);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        intro.start();


    }

}
