package com.example.djh99.tripplanner;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SearchFlight extends AppCompatActivity {

    public static String duration0;
    public static String duration1;
    public static String duration2;
    public static String duration3;
    public static String duration4;
    public static String duration5;
    public static String duration6;
    public static String duration7;
    public static String duration8;

    public static String departsAt0;
    public static String departsAt1;
    public static String departsAt2;
    public static String departsAt3;
    public static String departsAt4;
    public static String departsAt5;
    public static String departsAt6;
    public static String departsAt7;
    public static String departsAt8;

    public static String arriveAt0;
    public static String arriveAt1;
    public static String arriveAt2;
    public static String arriveAt3;
    public static String arriveAt4;
    public static String arriveAt5;
    public static String arriveAt6;
    public static String arriveAt7;
    public static String arriveAt8;

    public static String airline0;
    public static String airline1;
    public static String airline2;
    public static String airline3;
    public static String airline4;
    public static String airline5;
    public static String airline6;
    public static String airline7;
    public static String airline8;

    // TAG for Logcat Debugging and requestQueue
    private final static String TAG = "TripPlanner";
    private static RequestQueue requestQueue;

    // TextViews - Information
    private TextView textView_origin;
    private TextView textView_destination;
    private TextView textView_departure_date;
    private TextView textView_return_date;

    // Button - Travel Class
    private RadioButton radioButton_economy;
    private RadioButton radioButton_business;
    private RadioButton radioButton_first;

    // Save User's Information
    public String origin;
    public String destination;
    public String departure_date;
    public String return_date;
    public String travel_class;
    public static String url;

    public static String origin_display;
    public static String destination_display;
    public static String return_Date;
    public static String price;
    List<String> durations = new ArrayList<>();
    List<String> deparTureAts = new ArrayList<>();
    List<String> arriveAts = new ArrayList<>();
    List<String> arilines = new ArrayList<>();

    Intent flightsIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_flight);
        requestQueue = Volley.newRequestQueue(this);

        textView_origin = findViewById(R.id.search_origin);
        textView_destination = findViewById(R.id.search_destination);
        textView_departure_date = findViewById(R.id.search_departure_date);
        textView_return_date = findViewById(R.id.search_return_date);
        radioButton_economy = findViewById(R.id.button_economy);
        radioButton_business = findViewById(R.id.button_business);
        radioButton_first = findViewById(R.id.button_first_class);
    }

    public void showFlights(View view) {
        flightsIntent = new Intent(this, Flights.class);
        startActivity(flightsIntent);
    }

    void startAPICall() {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    url,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            Log.d(TAG, response.toString());
                            JSONParse(response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(final VolleyError error) {
                    Log.w(TAG, error.toString());
                }
            });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void JSONParse(JSONObject jsonObject) {
        try {
            int count = 0;
            JSONArray results = jsonObject.getJSONArray("results");
            origin_display = results.getJSONObject(0).getJSONArray("itineraries").getJSONObject(0).getJSONObject("outbound").getJSONArray("flights").getJSONObject(0).getJSONObject("origin").getString("airport");
            destination_display = results.getJSONObject(0).getJSONArray("itineraries").getJSONObject(0).getJSONObject("outbound").getJSONArray("flights").getJSONObject(0).getJSONObject("destination").getString("airport");
            return_Date = results.getJSONObject(0).getJSONArray("itineraries").getJSONObject(0).getJSONObject("inbound").getJSONArray("flights").getJSONObject(0).getString("arrives_at");
            for (int i = 0 ; i < results.length(); i++) {
                if (count == 9) {
                    break;
                }
                if (i == 0) {
                    price = (results.getJSONObject(i).getJSONObject("fare").getString("total_price"));
                    continue;
                }
                JSONArray itineraries = results.getJSONObject(i).getJSONArray("itineraries");
                for (int j = 0; j < itineraries.length(); j++) {
                    if (count == 9) {
                        break;
                    }
                    JSONObject outbound = itineraries.getJSONObject(j).getJSONObject("outbound");
                    durations.add(outbound.getString("duration"));
                    deparTureAts.add(outbound.getJSONArray("flights").getJSONObject(0).getString("departs_at"));
                    arriveAts.add(outbound.getJSONArray("flights").getJSONObject(0).getString("arrives_at"));
                    arilines.add(outbound.getJSONArray("flights").getJSONObject(0).getString("operating_airline"));
                    count++;
                }
            }
        } catch(JSONException e) {
            Log.d("DURATIONS", "failed");
        }
        for (int i = 0 ; i < 9; i++) {
            switch(i) {
                case 0:
                    duration0 = durations.get(i);
                    departsAt0 = deparTureAts.get(i);
                    arriveAt0 = arriveAts.get(i);
                    airline0 = arilines.get(i);
                case 1:
                    duration1 = durations.get(i);
                    departsAt1 = deparTureAts.get(i);
                    arriveAt1 = arriveAts.get(i);
                    airline1 = arilines.get(i);
                case 2:
                    duration2 = durations.get(i);
                    departsAt2 = deparTureAts.get(i);
                    arriveAt2 = arriveAts.get(i);
                    airline2 = arilines.get(i);
                case 3:
                    duration3 = durations.get(i);
                    departsAt3 = deparTureAts.get(i);
                    arriveAt3 = arriveAts.get(i);
                    airline3 = arilines.get(i);
                case 4:
                    duration4 = durations.get(i);
                    departsAt4 = deparTureAts.get(i);
                    arriveAt4 = arriveAts.get(i);
                    airline4 = arilines.get(i);
                case 5:
                    duration5 = durations.get(i);
                    departsAt5 = deparTureAts.get(i);
                    arriveAt5 = arriveAts.get(i);
                    airline5 = arilines.get(i);
                case 6:
                    duration6 = durations.get(i);
                    departsAt6 = deparTureAts.get(i);
                    arriveAt6 = arriveAts.get(i);
                    airline6 = arilines.get(i);
                case 7:
                    duration7 = durations.get(i);
                    departsAt7 = deparTureAts.get(i);
                    arriveAt7 = arriveAts.get(i);
                    airline7 = arilines.get(i);
                case 8:
                    duration8 = durations.get(i);
                    departsAt8 = deparTureAts.get(i);
                    arriveAt8 = arriveAts.get(i);
                    airline8 = arilines.get(i);
            }
        }
    }

    void checkedButton(boolean economyIsChecked, boolean businessIsChecked, boolean firstIsChecked) {
        if (economyIsChecked) {
            travel_class = "ECONOMY";
        } else if (businessIsChecked) {
            travel_class = "BUSINESS";
        } else if (firstIsChecked) {
            travel_class = "FIRST";
        } else {
            Log.d(TAG, "Travel Class is not Checked");
        }
    }

    public void Save(View view) {
        origin = textView_origin.getText().toString();
        destination = textView_destination.getText().toString();
        departure_date = textView_departure_date.getText().toString();
        return_date = textView_return_date.getText().toString();

        boolean economyIsChecked = radioButton_economy.isChecked();
        boolean businessIsChecked = radioButton_business.isChecked();
        boolean firstIsChecked = radioButton_first.isChecked();
        checkedButton(economyIsChecked, businessIsChecked, firstIsChecked);

        url = "https://api.sandbox.amadeus.com/v1.2/flights/low-fare-search?apikey=bPTezkr7v1MLP9ftBlw7brn8oq7Nr8Rr&origin="+origin+"&destination="+destination+"&departure_date="+departure_date+"&return_date="+return_date+"&nonstop=true&travel_class="+travel_class;
        startAPICall();
    }
}
