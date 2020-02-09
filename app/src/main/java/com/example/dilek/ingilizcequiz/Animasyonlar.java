package com.example.dilek.ingilizcequiz;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.List;


public class Animasyonlar {
    public static void yaziAnimasyonu(TextView v, int i){

        switch (i){

            case 0:
                YoYo.with(Techniques.DropOut)
                        .duration(1500)
                        .playOn(v);
                break;

            case 1:
                YoYo.with(Techniques.Landing)
                        .duration(1500)
                        .playOn(v);
                break;
            case 2:
                YoYo.with(Techniques.Flash)
                        .duration(1500)
                        .playOn(v);
                break;

            case 3:
                YoYo.with(Techniques.RubberBand)
                        .duration(1500)
                        .playOn(v);
                break;

            case 4:
                YoYo.with(Techniques.Swing)
                        .duration(1500)
                        .playOn(v);
                break;

            case 5:
                YoYo.with(Techniques.Wobble)
                        .duration(1500)
                        .playOn(v);
                break;

            case 6:
                YoYo.with(Techniques.Bounce)
                        .duration(1500)
                        .playOn(v);
                break;

            case 7:
                YoYo.with(Techniques.Tada)
                        .duration(1500)
                        .playOn(v);
                break;
            case 8:
                YoYo.with(Techniques.StandUp)
                        .duration(1500)
                        .playOn(v);
                break;

            case 9:
                YoYo.with(Techniques.Wave)
                        .duration(1500)
                        .playOn(v);
                break;

            case 10:
                YoYo.with(Techniques.RollIn)
                        .duration(1500)
                        .playOn(v);
                break;
            case 11:
                YoYo.with(Techniques.BounceIn)
                        .duration(1500)
                        .playOn(v);
                break;

            case 12:
                YoYo.with(Techniques.BounceInDown)
                        .duration(1500)
                        .playOn(v);
                break;

            case 13:
                YoYo.with(Techniques.BounceInLeft)
                        .duration(1500)
                        .playOn(v);
                break;

            case 14:
                YoYo.with(Techniques.BounceInRight)
                        .duration(1500)
                        .playOn(v);
                break;
            case 15:
                YoYo.with(Techniques.BounceInUp)
                        .duration(1500)
                        .playOn(v);
                break;
            case 16:
                YoYo.with(Techniques.FadeInUp)
                        .duration(1500)
                        .playOn(v);
                break;

            case 17:
                YoYo.with(Techniques.FlipInX)
                        .duration(1500)
                        .playOn(v);
                break;

            case 18:
                YoYo.with(Techniques.RotateInDownLeft)
                        .duration(1500)
                        .playOn(v);
                break;

            case 19:
                YoYo.with(Techniques.RotateInDownRight)
                        .duration(1500)
                        .playOn(v);
                break;

            case 20:
                YoYo.with(Techniques.RotateInUpLeft)
                        .duration(1500)
                        .playOn(v);
                break;

            case 21:
                YoYo.with(Techniques.RotateInUpRight)
                        .duration(1500)
                        .playOn(v);
                break;

            case 22:
                YoYo.with(Techniques.SlideInLeft)
                        .duration(1500)
                        .playOn(v);
                break;

            case 23:
                YoYo.with(Techniques.SlideInRight)
                        .duration(1500)
                        .playOn(v);
                break;

            case 24:
                YoYo.with(Techniques.SlideInUp)
                        .duration(1500)
                        .playOn(v);
                break;

            case 25:
                YoYo.with(Techniques.SlideInDown)
                        .duration(1500)
                        .playOn(v);
                break;

            case 26:
                YoYo.with(Techniques.ZoomInDown)
                        .duration(1500)
                        .playOn(v);
                break;

            case 27:
                YoYo.with(Techniques.ZoomInLeft)
                        .duration(1500)
                        .playOn(v);
                break;

            case 28:
                YoYo.with(Techniques.ZoomInUp)
                        .duration(1500)
                        .playOn(v);
                break;

        }

    }

    public static void butonlarAnimasyonu(List<View> butonlar) {

        AnimatorSet animatorSet=new AnimatorSet();

        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(butonlar.get(0),"translationY",500,0);
        ObjectAnimator objectAnimator2=ObjectAnimator.ofFloat(butonlar.get(1),"translationY",600,0);
        ObjectAnimator objectAnimator3=ObjectAnimator.ofFloat(butonlar.get(2),"translationY",700,0);
        ObjectAnimator objectAnimator4=ObjectAnimator.ofFloat(butonlar.get(3),"translationY",800,0);

        objectAnimator.setDuration(750);
        objectAnimator2.setDuration(1000);
        objectAnimator3.setDuration(1250);
        objectAnimator4.setDuration(1500);

        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator3.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator4.setInterpolator(new AccelerateDecelerateInterpolator());


        animatorSet.playTogether(objectAnimator,objectAnimator2,objectAnimator3,objectAnimator4);
        animatorSet.start();


    }
    public static void tebrikAnimasyonu(TextView soru_tv){

        YoYo.with(Techniques.ZoomInUp)
                .duration(1000)
                .playOn(soru_tv);
    }
    public static void titremeAnimasyonu(RelativeLayout soruContainer){

        AnimatorSet animatorSet=new AnimatorSet();

        ObjectAnimator animator = ObjectAnimator.ofFloat(soruContainer, "translationX", -40, 40, -30, 30, -20, 20, 0);
        animator.setDuration(1500);

        animatorSet.play(animator);
        animatorSet.start();

        YoYo.with(Techniques.Shake).duration(1500).playOn(soruContainer);
    }
    public static void butontitremeAnimasyonu(Button button){
        AnimatorSet animatorSet = new AnimatorSet();

        ObjectAnimator animator = ObjectAnimator.ofFloat(button, "translationX", -40, 40, -30, 30, -20, 20, 0);
        animator.setDuration(1500);

        animatorSet.play(animator);
        animatorSet.start();

        YoYo.with(Techniques.Shake).duration(1500).playOn(button);

    }
}
