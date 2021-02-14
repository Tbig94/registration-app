package com.resgistration_app.service;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.resgistration_app.entity.CryptoCurrency;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

@Service
public class
CryptoCurrencyServiceImpl implements CryptoCurrencyService {

    private final String API_KEY = System.getenv("CRYPTO_API_KEY");


    public CryptoCurrency getCurrencyData() {

        // String totalMarketCap, String totalVolume24h
        CryptoCurrency currency = new CryptoCurrency();

        final String URL = "https://pro-api.coinmarketcap.com/v1/global-metrics/quotes/latest?CMC_PRO_API_KEY=" + API_KEY;

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
            System.out.println("\n" + "CRYPTO_API_DATA.....");
            System.out.println(result);

            Map<String, Object> respMap = jsonToMap(result.toString());
            Map<String, Object> dataMap = jsonToMap(respMap.get("status").toString());

            System.out.println("Data: " + dataMap.get("timestamp"));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>() {}.getType()
        );
        return map;
    }

}
