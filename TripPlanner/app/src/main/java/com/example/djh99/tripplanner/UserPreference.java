package com.example.djh99.tripplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserPreference extends AppCompatActivity {

    private static RequestQueue requestQueue;

    public static boolean internetIsSelected = false;
    public static boolean outdoorsIsSelected = false;
    public static boolean environmentalIsSelected = false;
    public static boolean travelConnectivityIsSelected = false;
    public static boolean safetyIsSelected = false;
    public static boolean leisureIsSelected = false;


    public static String place0;
    public static String place1;
    public static String place2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_preference);
        requestQueue = Volley.newRequestQueue(this);
    }

    public void showFlights(View view) {
        Intent intent = new Intent(this, Flights.class);
        startActivity(intent);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show();
    }

    public void InternetAccess(View view) {
        if (!internetIsSelected) {
            internetIsSelected = true;
            displayToast("\"Internet Access\" is Selected.");
        } else {
            internetIsSelected = false;
            displayToast("\"Internet Access\" is Unselected.");
        }
    }

    public void Outdoors(View view) {
        if (!outdoorsIsSelected) {
            outdoorsIsSelected = true;
            displayToast("\"Outdoors\" is Selected.");
        } else {
            outdoorsIsSelected = false;
            displayToast("\"Outdoors\" is Unselected.");
        }
    }
    public void Environmental(View view) {
        if (!environmentalIsSelected) {
            environmentalIsSelected = true;
            displayToast("\"Environmental Quality\" is Selected.");
        } else {
            environmentalIsSelected = false;
            displayToast("\"Environmental Quality\" is Unselected.");
        }
    }
    public void Leisure(View view) {
        if (!leisureIsSelected) {
            leisureIsSelected = true;
            displayToast("\"Leisure\" is Selected.");
        } else {
            leisureIsSelected = false;
            displayToast("\"Leisure\" is Unselected.");
        }
    }

    public void Safety(View view) {
        if (!safetyIsSelected) {
            safetyIsSelected = true;
            displayToast("\"Safety\" is Selected.");
        } else {
            safetyIsSelected = false;
            displayToast("\"Safety\" is Unselected.");
        }
    }

    public void TravelConnectivity(View view) {
        if (!travelConnectivityIsSelected) {
            travelConnectivityIsSelected = true;
            displayToast("\"Travel Connectivity\" is Selected.");
        } else {
            travelConnectivityIsSelected = false;
            displayToast("\"Travel Connectivity\" is Unselected.");
        }
    }
    public void Recommendation(View view) {
        CityList cityList = new CityList();
        if (internetIsSelected) {
            cityList.InternetScore();
        }
        if (outdoorsIsSelected) {
            cityList.OutdoorsScore();
        }
        if (environmentalIsSelected) {
            cityList.EnvironmentalQualityScore();
        }
        if (leisureIsSelected) {
            cityList.LeisureScore();
        }
        if (safetyIsSelected) {
            cityList.SafetyScore();
        }
        if (travelConnectivityIsSelected) {
            cityList.TravelConnectivityScore();
        }
        cityList.getResult();
        String url1 = "https://api.teleport.org/api/urban_areas/slug:"+place0+"/scores/";
        String url2 = "https://api.teleport.org/api/urban_areas/slug:"+place1+"/scores/";
        String url3 = "https://api.teleport.org/api/urban_areas/slug:"+place2+"/scores/";
        startAPICall(url1, 0);
        startAPICall(url2, 1);
        startAPICall(url3, 2);
    }
    void startAPICall(String url, final int message) {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    url,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            Log.d("tripplanner", response.toString());
                            JSONParse(response, message);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(final VolleyError error) {
                }
            });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void JSONParse(JSONObject response, int i) {
        try {
            JSONArray categories = response.getJSONArray("categories");
            if (i == 0) {
                CityImages.Travel0 = categories.getJSONObject(4).getString("score_out_of_10");
                CityImages.Safety0 = categories.getJSONObject(7).getString("score_out_of_10");
                CityImages.Environmental0 = categories.getJSONObject(10).getString("score_out_of_10");
                CityImages.Internet0 = categories.getJSONObject(13).getString("score_out_of_10");
                CityImages.Leisure0 = categories.getJSONObject(14).getString("score_out_of_10");
                CityImages.Outdoors0 = categories.getJSONObject(16).getString("score_out_of_10");
            } else if (i == 1) {
                CityImages.Travel1 = categories.getJSONObject(4).getString("score_out_of_10");
                CityImages.Safety1 = categories.getJSONObject(7).getString("score_out_of_10");
                CityImages.Environmental1 = categories.getJSONObject(10).getString("score_out_of_10");
                CityImages.Internet1 = categories.getJSONObject(13).getString("score_out_of_10");
                CityImages.Leisure1 = categories.getJSONObject(14).getString("score_out_of_10");
                CityImages.Outdoors1 = categories.getJSONObject(16).getString("score_out_of_10");
            } else if (i == 2) {
                CityImages.Travel2 = categories.getJSONObject(4).getString("score_out_of_10");
                CityImages.Safety2 = categories.getJSONObject(7).getString("score_out_of_10");
                CityImages.Environmental2 = categories.getJSONObject(10).getString("score_out_of_10");
                CityImages.Internet2 = categories.getJSONObject(13).getString("score_out_of_10");
                CityImages.Leisure2 = categories.getJSONObject(14).getString("score_out_of_10");
                CityImages.Outdoors2 = categories.getJSONObject(16).getString("score_out_of_10");
            }
        } catch(JSONException e) {
            Log.d("ERROR", e.getMessage());
        }
    }

    public void nextIntent(View view) {
        Intent intent = new Intent(this, CityImages.class);
        startActivity(intent);
    }
}
