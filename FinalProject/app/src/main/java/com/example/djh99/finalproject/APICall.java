package com.example.djh99.finalproject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class APICall {
    List<String> durations = new ArrayList<>();
    List<String> companies = new ArrayList<>();
    List<String> return_date_time = new ArrayList<>();
    List<String> departure_date_time = new ArrayList<>();
    List<String> prices = new ArrayList<>();

    public String[] getDurations() {
        return durations.toArray(new String[12]);
    }

    public void getRequest() throws Exception {

        String url = "https://api.sandbox.amadeus.com/v1.2/flights/low-fare-search?apikey=bPTezkr7v1MLP9ftBlw7brn8oq7Nr8Rr&origin=CHI&destination=BOS&departure_date=2018-12-25&return_date=2018-12-29&nonstop=true&travel_class=ECONOMY";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();
        // JSONObject object
        String[] splitted = response.toString().split("[\\t\\s{}:,\"\\[\\]]");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < splitted.length; i++) {
            if (!splitted[i].isEmpty()) {
                list.add(splitted[i]);
            }
        }

        int countDuration = 0;
        int countCompany = 0;
        int countArrives = 0;
        int countPrice = 0;
        int countDeparts = 0;

        for (int i = 0 ; i < list.size(); i++) {
            if (list.get(i).equals("duration") && countDuration < 12) {
                String temp = list.get(i+1) + list.get(i+2);
                durations.add(temp);
                countDuration++;
            }
            if (list.get(i).equals("departs_at") && countDeparts < 12) {
                String temp = list.get(i + 1) + ":"+list.get(i + 2);
                departure_date_time.add(temp);
                countDeparts++;

            }
            if (list.get(i).equals("operating_airline") && countCompany < 12) {
                String temp = list.get(i+1);
                companies.add(temp);
                countCompany++;
            }
            if (list.get(i).equals("total_price") && countPrice < 12) {
                String temp = list.get(i+1);
                prices.add(temp);
                countPrice++;
            }
            if (list.get(i).equals("arrives_at") && countArrives < 12) {
                String temp = list.get(i + 1) + ":"+list.get(i + 2);
                return_date_time.add(temp);
                countArrives++;
            }
        }
    }
}
