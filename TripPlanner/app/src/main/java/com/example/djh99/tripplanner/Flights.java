package com.example.djh99.tripplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Flights extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights);
        // receive Intents
        // display the data received from the Intents
        display();
    }

    void display() {
            for (int i = 0 ; i < 9; i++) {
                switch(i) {
                    case 0:
                        TextView duration0 = findViewById(R.id.duration_0);
                        TextView departureAt0 = findViewById(R.id.departure_date_time_0);
                        TextView origin0 = findViewById(R.id.origin_0);
                        TextView arriveAt0 = findViewById(R.id.arrival_date_time_0);
                        TextView price0 = findViewById(R.id.price_0);
                        TextView destination0 = findViewById(R.id.destination_0);
                        TextView airline0 = findViewById(R.id.airline_0);
                        duration0.setText(SearchFlight.duration0);
                        origin0.setText(SearchFlight.origin_display);
                        price0.setText(SearchFlight.price);
                        destination0.setText(SearchFlight.destination_display);
                        departureAt0.setText(SearchFlight.departsAt0);
                        arriveAt0.setText(SearchFlight.arriveAt0);
                        airline0.setText(SearchFlight.airline0);
                        break;

                    case 1:
                        TextView duration1 = findViewById(R.id.duration_1);
                        TextView departureAt1 = findViewById(R.id.departure_date_time_1);
                        TextView origin1 = findViewById(R.id.origin_1);
                        TextView arriveAt1 = findViewById(R.id.arrival_date_time_1);
                        TextView price1 = findViewById(R.id.price_1);
                        TextView airline1 = findViewById(R.id.airline_1);
                        TextView destination1 = findViewById(R.id.destination_1);
                        duration1.setText(SearchFlight.duration1);
                        departureAt1.setText(SearchFlight.departsAt1);
                        origin1.setText(SearchFlight.origin_display);
                        price1.setText(SearchFlight.price);
                        destination1.setText(SearchFlight.destination_display);
                        arriveAt1.setText(SearchFlight.arriveAt1);
                        airline1.setText(SearchFlight.airline1);
                        break;
                    case 2:
                        TextView duration2 = findViewById(R.id.duration_2);
                        TextView departureAt2 = findViewById(R.id.departure_date_time_2);
                        TextView origin2 = findViewById(R.id.origin_2);
                        TextView airline2 = findViewById(R.id.airline_2);
                        TextView arriveAt2 = findViewById(R.id.arrival_date_time_2);
                        TextView price2 = findViewById(R.id.price_2);
                        TextView destination2 = findViewById(R.id.destination_2);
                        duration2.setText(SearchFlight.duration2);
                        departureAt2.setText(SearchFlight.departsAt2);
                        origin2.setText(SearchFlight.origin_display);
                        price2.setText(SearchFlight.price);
                        destination2.setText(SearchFlight.destination_display);
                        arriveAt2.setText(SearchFlight.arriveAt2);
                        airline2.setText(SearchFlight.airline2);
                        break;
                    case 3:
                        TextView duration3 = findViewById(R.id.duration_3);
                        TextView departureAt3 = findViewById(R.id.departure_date_time_3);
                        TextView origin3 = findViewById(R.id.origin_3);
                        TextView airline3 = findViewById(R.id.airline_3);
                        TextView arriveAt3 = findViewById(R.id.arrival_date_time_3);
                        TextView price3 = findViewById(R.id.price_3);
                        TextView destination3 = findViewById(R.id.destination_3);
                        duration3.setText(SearchFlight.duration3);
                        departureAt3.setText(SearchFlight.departsAt3);
                        origin3.setText(SearchFlight.origin_display);
                        price3.setText(SearchFlight.price);
                        destination3.setText(SearchFlight.destination_display);
                        arriveAt3.setText(SearchFlight.arriveAt3);
                        airline3.setText(SearchFlight.airline3);
                        break;
                    case 4:
                        TextView duration4 = findViewById(R.id.duration_4);
                        TextView departureAt4 = findViewById(R.id.departure_date_time_4);
                        TextView origin4 = findViewById(R.id.origin_4);
                        TextView airline4 = findViewById(R.id.airline_4);
                        TextView arriveAt4 = findViewById(R.id.arrival_date_time_4);
                        TextView price4 = findViewById(R.id.price_4);
                        TextView destination4 = findViewById(R.id.destination_4);
                        duration4.setText(SearchFlight.duration4);
                        departureAt4.setText(SearchFlight.departsAt4);
                        origin4.setText(SearchFlight.origin_display);
                        price4.setText(SearchFlight.price);
                        destination4.setText(SearchFlight.destination_display);
                        arriveAt4.setText(SearchFlight.arriveAt4);
                        airline4.setText(SearchFlight.airline4);
                        break;
                    case 5:
                        TextView duration5 = findViewById(R.id.duration_5);
                        TextView departureAt5 = findViewById(R.id.departure_date_time_5);
                        TextView origin5 = findViewById(R.id.origin_5);
                        TextView airline5 = findViewById(R.id.airline_5);
                        TextView arriveAt5 = findViewById(R.id.arrival_date_time_5);
                        TextView price5 = findViewById(R.id.price_5);
                        TextView destination5 = findViewById(R.id.destination_5);
                        duration5.setText(SearchFlight.duration5);
                        departureAt5.setText(SearchFlight.departsAt5);
                        origin5.setText(SearchFlight.origin_display);
                        price5.setText(SearchFlight.price);
                        destination5.setText(SearchFlight.destination_display);
                        arriveAt5.setText(SearchFlight.arriveAt5);
                        airline5.setText(SearchFlight.airline5);
                        break;
                    case 6:
                        TextView duration6 = findViewById(R.id.duration_6);
                        TextView departureAt6 = findViewById(R.id.departure_date_time_6);
                        TextView origin6 = findViewById(R.id.origin_6);
                        TextView airline6 = findViewById(R.id.airline_6);
                        TextView arriveAt6 = findViewById(R.id.arrival_date_time_6);
                        TextView price6 = findViewById(R.id.price_6);
                        TextView destination6 = findViewById(R.id.destination_6);
                        duration6.setText(SearchFlight.duration6);
                        departureAt6.setText(SearchFlight.departsAt6);
                        origin6.setText(SearchFlight.origin_display);
                        price6.setText(SearchFlight.price);
                        destination6.setText(SearchFlight.destination_display);
                        arriveAt6.setText(SearchFlight.arriveAt6);
                        airline6.setText(SearchFlight.airline6);
                        break;
                    case 7:
                        TextView duration7 = findViewById(R.id.duration_7);
                        TextView departureAt7 = findViewById(R.id.departure_date_time_7);
                        TextView origin7 = findViewById(R.id.origin_7);
                        TextView airline7 = findViewById(R.id.airline_7);
                        TextView arriveAt7 = findViewById(R.id.arrival_date_time_7);
                        TextView price7 = findViewById(R.id.price_7);
                        TextView destination7 = findViewById(R.id.destination_7);
                        duration7.setText(SearchFlight.duration7);
                        departureAt7.setText(SearchFlight.departsAt7);
                        origin7.setText(SearchFlight.origin_display);
                        price7.setText(SearchFlight.price);
                        destination7.setText(SearchFlight.destination_display);
                        arriveAt7.setText(SearchFlight.arriveAt7);
                        airline7.setText(SearchFlight.airline7);
                    case 8:
                        TextView duration8 = findViewById(R.id.duration_8);
                        TextView departureAt8 = findViewById(R.id.departure_date_time_8);
                        TextView origin8 = findViewById(R.id.origin_8);
                        TextView airline8 = findViewById(R.id.airline_8);
                        TextView arriveAt8 = findViewById(R.id.arrival_date_time_8);
                        TextView price8 = findViewById(R.id.price_8);
                        TextView destination8 = findViewById(R.id.destination_8);
                        duration8.setText(SearchFlight.duration8);
                        departureAt8.setText(SearchFlight.departsAt8);
                        origin8.setText(SearchFlight.origin_display);
                        price8.setText(SearchFlight.price);
                        destination8.setText(SearchFlight.destination_display);
                        arriveAt8.setText(SearchFlight.arriveAt8);
                        airline8.setText(SearchFlight.airline8);
                        break;
                    default:
                        break;
                }
        }
    }
    public void ToastDisplay(View view) {
        SelectedInformation.frame_1_origin = SearchFlight.origin_display;
        SelectedInformation.frame_2_destination = SearchFlight.destination_display;
        SelectedInformation.frame_2_return_date = SearchFlight.return_Date.substring(0, 10);
        switch(view.getId()) {
            case R.id.flight_image_0:
                Toast.makeText(getApplicationContext(), "The Flight #1 is Selected", Toast.LENGTH_SHORT).show();
                SelectedInformation.frame_1_departure_date = SearchFlight.departsAt0.substring(0, 10);
                break;
            case R.id.flight_image_1:
                Toast.makeText(getApplicationContext(), "The Flight #2 is Selected", Toast.LENGTH_SHORT).show();
                SelectedInformation.frame_1_departure_date = SearchFlight.departsAt1.substring(0, 10);
                break;
            case R.id.flight_image_2:
                Toast.makeText(getApplicationContext(), "The Flight #3 is Selected", Toast.LENGTH_SHORT).show();
                SelectedInformation.frame_1_departure_date = SearchFlight.departsAt2.substring(0, 10);
                break;
            case R.id.flight_image_3:
                Toast.makeText(getApplicationContext(), "The Flight #4 is Selected", Toast.LENGTH_SHORT).show();
                SelectedInformation.frame_1_departure_date = SearchFlight.departsAt3.substring(0, 10);
                break;
            case R.id.flight_image_4:
                Toast.makeText(getApplicationContext(), "The Flight #5 is Selected", Toast.LENGTH_SHORT).show();
                SelectedInformation.frame_1_departure_date = SearchFlight.departsAt4.substring(0, 10);
                break;
            case R.id.flight_image_5:
                Toast.makeText(getApplicationContext(), "The Flight #6 is Selected", Toast.LENGTH_SHORT).show();
                SelectedInformation.frame_1_departure_date = SearchFlight.departsAt5.substring(0, 10);
                break;
            case R.id.flight_image_6:
                Toast.makeText(getApplicationContext(), "The Flight #7 is Selected", Toast.LENGTH_SHORT).show();
                SelectedInformation.frame_1_departure_date = SearchFlight.departsAt6.substring(0, 10);
                break;
            case R.id.flight_image_7:
                Toast.makeText(getApplicationContext(), "The Flight #8 is Selected", Toast.LENGTH_SHORT).show();
                SelectedInformation.frame_1_departure_date = SearchFlight.departsAt7.substring(0, 10);
                break;
            case R.id.flight_image_8:
                Toast.makeText(getApplicationContext(), "The Flight #9 is Selected", Toast.LENGTH_SHORT).show();
                SelectedInformation.frame_1_departure_date = SearchFlight.departsAt8.substring(0, 10);
                break;
            default:
                Toast.makeText(getApplicationContext(), "Nothing is Selected", Toast.LENGTH_SHORT).show();
        }
    }
}
