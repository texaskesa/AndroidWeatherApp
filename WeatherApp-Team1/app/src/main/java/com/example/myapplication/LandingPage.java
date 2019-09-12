package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Calendar;
import java.util.Date;


public class LandingPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        day_night();
        time_animation();

    }
    public void time_animation() {
        ImageView sun = (ImageView) findViewById( R.id.imageView9 );
        float x_cur, y_cur, dx, dy;
        x_cur = sun.getLeft();
        y_cur = sun.getTop();
        dx = 1500;
        dy = 0;

        TranslateAnimation anim = new TranslateAnimation( x_cur, x_cur + dx, y_cur, y_cur + dy);
        anim.setDuration(5000);
        anim.setFillAfter( true );
        sun.startAnimation(anim);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void day_night(){
        Calendar right = Calendar.getInstance();
        int current = right.get(Calendar.HOUR_OF_DAY);
        RelativeLayout relativeLayout = findViewById(R.id.layout);
        if(current>=19 || current <5){
            relativeLayout.setBackgroundResource(R.drawable.night);
        }
        else{
            relativeLayout.setBackgroundResource(R.drawable.after_noon);
        }
    }
}
