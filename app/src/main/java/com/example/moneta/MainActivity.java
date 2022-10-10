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
        final View imageCoin = (ImageView) findViewById(R.id.imageView3);

        flipCoinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String coinSide = rand.nextInt(2) == 1 ? "skaičius" : "herbas";
                final String coinFlipText = "Jums iškrito " + coinSide;

                flipCoinResult.setText(coinFlipText);

                /*
                imageCoin.animate().apply {
                    duration = 2000;
                    rotationYBy(1800f);
                    coinImage.isClickable = false
                }.withEndAction {
                    imageCoin.setImageResource(R.id.coinImage);
                    flipCoinResult.setText(coinFlipText);
                    imageCoin.isClickable = true
                }.start()


                 */

            }
        });

    }
}