package com.example.djh99.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent = getIntent();
        String[] prices = intent.getStringArrayExtra("PRICES");
        Log.d("PRICES", "Successful");
        display(prices);
    }

    void display(String[] prices) {
        if (prices != null) {
            for (int i = 0 ; i < prices.length; i++) {
                switch(i) {
                    case 0:
                        TextView price0 = findViewById(R.id.price_0);
                        price0.setText(prices[i]);
                    case 1:
                        TextView price1 = findViewById(R.id.price_1);
                        price1.setText(prices[6]);
                    case 2:
                        TextView price2 = findViewById(R.id.price_2);
                        price2.setText(prices[7]);
                    case 3:
                        TextView price3 = findViewById(R.id.price_3);
                        price3.setText(prices[8]);
                    case 4:
                        TextView price4 = findViewById(R.id.price_4);
                        price4.setText(prices[9]);
                    default:
                        Log.d("PRICES", "N/A");
                }
            }
        }
    }
}
