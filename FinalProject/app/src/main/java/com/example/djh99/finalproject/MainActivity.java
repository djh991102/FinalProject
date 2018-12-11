package com.example.djh99.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "FinalProject.Main";
    private static RequestQueue requestQueue;

    // Pack the information inside the Intent for the following Activity
    private String origin;
    private String destination;
    private List<String> departureDates = new ArrayList<>();
    private List<String> returnDates = new ArrayList<>();
    private List<String> prices = new ArrayList<>();
    private List<String> airlines = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
    }

    public void showAPI(View view) {
        Log.d(TAG, "Button Clicked");
        startAPICall();
    }

    void startAPICall() {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "https://api.sandbox.amadeus.com/v1.2/flights/low-fare-search?apikey=bPTezkr7v1MLP9ftBlw7brn8oq7Nr8Rr&origin=BOS&destination=CHI&departure_date=2018-12-25&return_date=2019-01-02&nonstop=true&travel_class=ECONOMY",
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            Log.d(TAG, response.toString());
                            try {
                                JSONObject jsonObject = response.getJSONArray("results").getJSONObject(0);
                                TextView origin = findViewById(R.id.origin);
                                TextView destination = findViewById(R.id.destination);
                                TextView departure = findViewById(R.id.date);
                                TextView price = findViewById(R.id.price);
                                origin.setText(response.getString("origin"));
                                destination.setText(jsonObject.getString("destination"));
                                departure.setText(jsonObject.getString("departure_date"));
                                JSONParse(response);
                                price.setText(prices.get(9));
                                } catch (JSONException e) {
                                Log.d(TAG, "Parsing Failed");
                            }
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
            origin = jsonObject.getString("origin");
            for (int i = 0; i < results.length(); i++) {
                if (count == 10) {
                    break;
                }
                prices.add(results.getJSONObject(i).getString("price"));
                count++;
            }
        } catch(Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public void nextIntent(View view) {
        Intent intent = new Intent(this, Display.class);
        intent.putExtra("PRICES", prices.toArray(new String[10]));
        startActivity(intent);
    }
}
