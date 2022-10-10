package com.example.moneta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        final Button flipCoinButton = (Button)findViewById(R.id.flipCoinButton);
        final TextView flipCoinResult = (TextView) findViewById(R.id.flipCoinResult);

        flipCoinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String coinSide = rand.nextInt(2) == 1 ? "skaičius" : "herbas";
                final String coinFlipText = String.join("Jums iškrito ", coinSide);

                flipCoinResult.setText(coinFlipText);
            }
        });

    }
}