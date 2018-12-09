package com.example.akshaya.spinbottle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView bottle;
    Random  random = new Random();
    int lastDir;
    boolean spinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottle=findViewById(R.id.bottle);
        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!spinning)
                {
                    int newDir =random.nextInt(1800);
                    float x=bottle.getWidth()/2;
                    float y=bottle.getHeight()/2;
                    Animation rotate = new RotateAnimation(lastDir,newDir,x,y);
                    rotate.setDuration(3000);
                    rotate.setFillAfter(true);
                    bottle.startAnimation(rotate);
                    rotate.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            spinning=true;
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            spinning=false;

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                }

            }
        });
    }
}
