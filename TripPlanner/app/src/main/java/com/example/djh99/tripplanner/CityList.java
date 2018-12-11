package com.example.djh99.tripplanner;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CityList {
     City paris = new City("paris", 10.0, 9.7, 4.4, 4.4, 9.8, 6.2);
     City rome = new City("rome", 6.4, 4.5, 6.4, 4.3, 9.1, 6.6);
     City london = new City("london", 9.4, 5.8, 5.4, 5.5, 9.6, 7.2);
     City phuket = new City("phuket", 1.8, 3.6, 4.6, 3.6, 4.8, 5.7);
     City dubai = new City("dubai", 4.5, 3.2, 5.8, 6.0, 4.7, 9.2);
     City new_york = new City("new-york", 6.7, 7.1, 5.7, 5.2, 10.0, 7.0);
     City barcelona = new City("barcelona", 5.8, 6.4, 5.8, 3.7, 8.6, 7.4);
     City sydney = new City("sydney", 3.3, 4.7, 6.3, 7.8, 6.2, 7.6);
     City hong_kong = new City("hong-kong", 3.7, 6.2, 5.8, 4.5, 7.1, 9.4);
     City rio_de_janeiro = new City("rio-de-janeiro", 1.5, 2.3, 6.2, 3.3, 8.7, 5.3);
     City florence = new City("florence", 4.3, 4.4, 1.7, 6.0, 8.5, 7.8);
     City bali = new City("bali", 1.9, 3.2, 7.5, 4.1, 6.3, 8.7);
     City san_francisco_bay_area = new City("san-francisco-bay-area", 3.7, 5.6, 7.0, 6.5, 9.4, 5.7);

     static Map<String, Double> map = new HashMap<>();
     City[] cityLists;

     CityList() {
         cityLists = new City[] {paris, rome, london, phuket, dubai, new_york, barcelona, sydney, hong_kong, rio_de_janeiro
                 , florence, bali, san_francisco_bay_area};
     }

     public void InternetScore() {
         for (int i = 0; i < cityLists.length; i++) {
             map.put(cityLists[i].name, map.getOrDefault(cityLists[i], 0.0) + cityLists[i].getInternet_access());
         }
     }
     public void OutdoorsScore() {
         for (int i = 0; i < cityLists.length; i++) {
             map.put(cityLists[i].name, map.getOrDefault(cityLists[i], 0.0) + cityLists[i].getOutdoors());
         }
     }
     public void EnvironmentalQualityScore() {
        for (int i = 0; i < cityLists.length; i++) {
            map.put(cityLists[i].name, map.getOrDefault(cityLists[i], 0.0) + cityLists[i].getEnvironmental_quality());
        }
     }
     public void TravelConnectivityScore() {
         for (int i = 0; i < cityLists.length; i++) {
             map.put(cityLists[i].name, map.getOrDefault(cityLists[i], 0.0) + cityLists[i].getTravel_connectivity());
         }
     }
     public void LeisureScore() {
         for (int i = 0; i < cityLists.length; i++) {
             map.put(cityLists[i].name, map.getOrDefault(cityLists[i], 0.0) + cityLists[i].getLeisure());
         }
     }
     public void SafetyScore() {
         for (int i = 0; i < cityLists.length; i++) {
             map.put(cityLists[i].name, map.getOrDefault(cityLists[i], 0.0) + cityLists[i].getSafety());
         }
     }

     public void getResult() {
         List<Double> scores = new ArrayList<>(map.values());
         scores.sort(new Comparator<Double>() {
             @Override
             public int compare(Double o1, Double o2) {
                 if (o2 > o1) {
                     return 1;
                 } else if (o2 < o1) {
                     return -1;
                 } else {
                     return 0;
                 }
             }
         });
         for (int i = 0; i < 3; i ++) {
             switch (i) {
                 case 0:
                     UserPreference.place0 = getKeyByValue(map, scores.get(i));
                 case 1:
                     UserPreference.place1 = getKeyByValue(map, scores.get(i));
                 case 2:
                     UserPreference.place2 = getKeyByValue(map, scores.get(i));
                 default:
             }
         }
     }
    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            System.out.println(entry);
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}

class City {
    String name;
    double travel_connectivity;
    double internet_access;
    double outdoors;
    double environmental_quality;
    double leisure;
    double safety;
    City(String n, double t, double i, double o, double e, double l, double s) {
        name = n;
        travel_connectivity = t;
        internet_access = i;
        outdoors = o;
        environmental_quality = e;
        leisure = l;
        safety= s;
    }

    public double getInternet_access() {
        return internet_access;
    }

    public double getEnvironmental_quality() {
        return environmental_quality;
    }

    public double getLeisure() {
        return leisure;
    }

    public double getOutdoors() {
        return outdoors;
    }

    public double getSafety() {
        return safety;
    }

    public double getTravel_connectivity() {
        return travel_connectivity;
    }
}