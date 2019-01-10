package com.example.nostudy.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import com.example.nostudy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity {

    @BindView(R.id.iv)
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);
        initData();
    }
    private void initData() {
        getSupportActionBar().hide();
        DisplayMetrics displayMetrics=getResources().getDisplayMetrics();
        int height=displayMetrics.heightPixels;
        //动画
        ObjectAnimator objectAnimator1=ObjectAnimator.ofFloat(iv,"scaleX",2,1);
        ObjectAnimator objectAnimator2=ObjectAnimator.ofFloat(iv,"alpha",0,1);
        ObjectAnimator objectAnimator3=ObjectAnimator.ofFloat(iv,"rotation",0,360);
        ObjectAnimator objectAnimator4=ObjectAnimator.ofFloat(iv,"translationY",0,height/2-iv.getHeight()/2);
        //组合
        AnimatorSet set=new AnimatorSet();
        set.play(objectAnimator1).with(objectAnimator2).with(objectAnimator3).with(objectAnimator4);
        set.setDuration(3000);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }
            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(ShowActivity.this,MainActivity.class));
            }
            @Override
            public void onAnimationCancel(Animator animation) {

            }
            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
