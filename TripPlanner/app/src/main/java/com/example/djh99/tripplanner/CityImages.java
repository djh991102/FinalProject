package com.example.djh99.tripplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CityImages extends AppCompatActivity {

    public static String Travel0;
    public static String Safety0;
    public static String Environmental0;
    public static String Internet0;
    public static String Leisure0;
    public static String Outdoors0;

    public static String Travel1;
    public static String Safety1;
    public static String Environmental1;
    public static String Internet1;
    public static String Leisure1;
    public static String Outdoors1;

    public static String Travel2;
    public static String Safety2;
    public static String Environmental2;
    public static String Internet2;
    public static String Leisure2;
    public static String Outdoors2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_images);
        display();
    }

    void display() {
        TextView text_travel0 = findViewById(R.id.travel0);
        TextView text_internet0 = findViewById(R.id.internet0);
        TextView text_safety0 = findViewById(R.id.safety0);
        TextView text_leisure0 = findViewById(R.id.leisure0);
        TextView text_environmental0 = findViewById(R.id.environmental0);
        TextView text_name0 = findViewById(R.id.name0);
        String name0 = UserPreference.place0;
        text_name0.setText(name0);
        text_travel0.setText(Travel0);
        text_internet0.setText(Internet0);
        text_leisure0.setText(Leisure0);
        text_safety0.setText(Safety0);
        text_environmental0.setText(Environmental0);

        TextView text_travel1 = findViewById(R.id.travel1);
        TextView text_internet1 = findViewById(R.id.internet1);
        TextView text_safety1 = findViewById(R.id.safety1);
        TextView text_leisure1 = findViewById(R.id.leisure1);
        TextView text_environmental1 = findViewById(R.id.environmental1);
        TextView text_name1 = findViewById(R.id.name1);
        String name1 = UserPreference.place1;
        text_name1.setText(name1);
        text_travel1.setText(Travel1);
        text_internet1.setText(Internet1);
        text_leisure1.setText(Leisure1);
        text_safety1.setText(Safety1);
        text_environmental1.setText(Environmental1);

        TextView text_travel2 = findViewById(R.id.travel2);
        TextView text_internet2 = findViewById(R.id.internet2);
        TextView text_safety2 = findViewById(R.id.safety2);
        TextView text_leisure2 = findViewById(R.id.leisure2);
        TextView text_environmental2 = findViewById(R.id.environmental2);
        TextView text_name2 = findViewById(R.id.name2);
        String name2 = UserPreference.place2;
        text_name2.setText(name2);
        text_travel2.setText(Travel2);
        text_internet2.setText(Internet2);
        text_leisure2.setText(Leisure2);
        text_safety2.setText(Safety2);
        text_environmental2.setText(Environmental2);
    }
}
