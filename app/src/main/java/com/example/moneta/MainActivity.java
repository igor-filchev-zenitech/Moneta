package com.example.moneta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handleButtonCreate();
    }

    public void handleButtonCreate() {
        final Button flipCoinButton = (Button)findViewById(R.id.button2);
        final TextView flipCoinResult = (TextView) findViewById(R.id.textView2);
        final ImageView imageCoin = (ImageView) findViewById(R.id.imageView3);

        imageCoin.getLayoutParams().width = 300;
        imageCoin.getLayoutParams().height = 300;

        flipCoinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SpringAnimation anim = new SpringAnimation(imageCoin, DynamicAnimation.ROTATION_Y, 0f);

                anim.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);

                anim.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
                    // Overriding the method to notify view2 about the change in the view1’s property.
                    @Override
                    public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float value,
                                                  float velocity) {
                        // set the image to the beginning of the Y axis
                        imageCoin.setY(50f);

                        // Again starting the animation
                        anim.animateToFinalPosition(3600f);
                    }
                });

                anim.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
                    @Override
                    public void onAnimationEnd(DynamicAnimation animation1, boolean canceled, float value, float velocity) {
                        final int randomValue = rand.nextInt(2);

                        final String coinSide = randomValue == 1 ? "skaičius" : "herbas";
                        final String coinFlipText = "Jums iškrito " + coinSide;
                        final int finalImage = randomValue == 1
                                ? R.drawable.__cent_coin_united_states_transparent_png
                                : R.drawable.us_one_cent_obv;

                        flipCoinResult.setText(coinFlipText);
                        imageCoin.setImageResource(finalImage);
                    }
                });

                anim.start();
            }
        });
    }
}