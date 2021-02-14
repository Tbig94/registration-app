package com.resgistration_app.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.resgistration_app.entity.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class WeatherServiceImpl implements  WeatherService {

    private final String API_KEY = System.getenv("WEATHER_API_KEY");

    @Value("${WEATHER_API_LOCATION1}")
    private String LOCATION1;

    @Value("${WEATHER_API_LOCATION2}")
    private String LOCATION2;

    @Value("${WEATHER_API_LOCATION3}")
    private String LOCATION3;

    @Value("${WEATHER_API_LOCATION4}")
    private String LOCATION4;

    public List<Weather> allWeatherData() {
        List<Weather> allWeathers = new ArrayList<Weather>();
        allWeathers.add(getWeatherData(LOCATION1));
        allWeathers.add(getWeatherData(LOCATION2));
        allWeathers.add(getWeatherData(LOCATION3));
        allWeathers.add(getWeatherData(LOCATION4));
        return allWeathers;
    }

    public Weather getWeatherData(String LOCATION) {

        //  String temperature, String humidity, String windSpeed
        Weather weatherObj = new Weather();

        final String URL = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&units=metric&appid=" + API_KEY;

        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(URL);
            URLConnection conn = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            br.close();
            System.out.println("\n" + "WEATHER_API_DATA.....");
            System.out.println(result);

            Map<String, Object> respMap = jsonToMap(result.toString());
            Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
            Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());

            System.out.println("Current Temperature: " + mainMap.get("temp"));
            System.out.println("Current Humidity: " + mainMap.get("humidity"));
            System.out.println("Wind Speeds: " + windMap.get("speed"));

            weatherObj.setTemperature(mainMap.get("temp").toString());
            weatherObj.setHumidity(mainMap.get("humidity").toString());
            weatherObj.setWindSpeed(windMap.get("speed").toString());
            weatherObj.setLocation(LOCATION);

            System.out.println("weatherObj: " + weatherObj.getTemperature() + weatherObj.getHumidity() + weatherObj.getWindSpeed());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return weatherObj;
    }

    public static Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>() {}.getType()
        );
        return map;
    }

}
