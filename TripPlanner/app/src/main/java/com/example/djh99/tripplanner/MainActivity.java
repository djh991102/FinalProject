package com.example.djh99.tripplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createNewDestination(View view) {
        // Flights API call
        Intent intent = new Intent(this, SearchFlight.class);
        startActivity(intent);
        // send intent to setting activity
    }

    public void createNewOrigin(View view) {
        // Flights API call
        Intent intent = new Intent(this, SearchFlight.class);
        startActivity(intent);
        // send intent to setting activity
    }

    public void searchNewEvent(View view) {
        Intent intent = new Intent(this, UserPreference.class);
        startActivity(intent);
        // events API call
    }

    public void DisplayFlightInformation(View view) {
        Log.d("DisplayInformationMain", "Clicked");
        TextView frame_1_city = findViewById(R.id.frame_1_city);
        TextView frame_1_date = findViewById(R.id.frame_1_date);
        TextView frame_2_city = findViewById(R.id.frame_2_city);
        TextView frame_2_date = findViewById(R.id.frame_2_date);
        String frame_1_origin = SelectedInformation.frame_1_origin;
        String frame_1_departure_date = SelectedInformation.frame_1_departure_date;
        String frame_2_destination = SelectedInformation.frame_2_destination;
        String frame_2_return_date = SelectedInformation.frame_2_return_date;
        frame_1_city.setText(frame_1_origin);
        frame_1_date.setText(frame_1_departure_date);
        frame_2_city.setText(frame_2_destination);
        frame_2_date.setText(frame_2_return_date);
    }
}
