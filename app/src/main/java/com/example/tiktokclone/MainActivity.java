package com.example.tiktokclone;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


import android.net.Uri;

import android.widget.VideoView;

import java.text.DecimalFormat;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {
    GestureDetector gestureDetector;
private int num = 6030;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MultiTouchListener touchListener = new MultiTouchListener(this);
        ImageButton onButton = (ImageButton) findViewById(R.id.imageButton);
        onButton.setOnTouchListener(touchListener);

        gestureDetector = new GestureDetector(MainActivity.this, MainActivity.this);
        ImageButton fl = (ImageButton) findViewById(R.id.profile_image2);
        TextView textView = (TextView) findViewById(R.id.txtmusic);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSelected(true);
        VideoView videoview = (VideoView) findViewById(R.id.videoview);
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoview.setVideoURI(uri);
        videoview.start();
        CircleImageView circleImageView = (CircleImageView) findViewById(R.id.profile_image1);
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(5000);
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setInterpolator(new LinearInterpolator());
        RotateAnimation rotate1 = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate1.setDuration(1000);
        rotate1.setRepeatCount(Animation.INFINITE);
        rotate1.setInterpolator(new LinearInterpolator());
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.5f, 0.0f, 1.5f, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);

        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fl.startAnimation(rotate1);
                fl.startAnimation(scaleAnimation);
            }
        });
        circleImageView.startAnimation(rotate);
        ImageButton img1 = (ImageButton) findViewById(R.id.imageButton);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                img1.setImageResource(R.drawable.heart);
                ScaleAnimation scaleAnimation1 = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation1.setDuration(1000);
                scaleAnimation1.setFillAfter(true);
                img1.startAnimation(scaleAnimation1);
                TextView txt = (TextView) findViewById(R.id.txtnumheart);

                txt.setText("6.030");
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {

        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {

        return false;
    }

    @Override
    public void onLongPress(MotionEvent event) {

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {

        return false;
    }

    @Override
    public void onShowPress(MotionEvent event) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {

        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        TextView txt = (TextView) findViewById(R.id.txtnumheart);
        ImageButton img = (ImageButton) findViewById(R.id.imageButton);
        num++;
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        txt.setText(formatter.format(num).toString());
        img.setImageResource(R.drawable.heart);
        ImageView iv = (ImageView) findViewById(R.id.imgheart);
        AlphaAnimation animation1 = new AlphaAnimation(1.0f, 0.0f);
        animation1.setDuration(1200);
        animation1.setFillAfter(true);
        iv.setAlpha(1.0f);
        iv.startAnimation(animation1);
        Toast.makeText(MainActivity.this, "Cảm ơn bạn đã thích video này.", Toast.LENGTH_SHORT).show();

        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {

        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {

        return false;
    }
}