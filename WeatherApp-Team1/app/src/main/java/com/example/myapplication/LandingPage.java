package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class LandingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}
