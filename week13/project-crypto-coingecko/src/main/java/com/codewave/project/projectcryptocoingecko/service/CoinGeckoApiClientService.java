package com.codewave.project.projectcryptocoingecko.service;

import com.codewave.project.projectcryptocoingecko.model.dto.CoinMarketDataDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class CoinGeckoApiClientService {
    private static final String BASE_URL = "https://api.coingecko.com/api/v3";
    //private static final String BASE_URL = "https://api.coingecko.com/api/v3/coins/markets?ids=bitcoin,ethereum,tether,dogecoin,ripple&vs_currency=usd";
    private static final String MARKETS_ENDPOINT = "/coins/markets";
    private static final String VS_CURRENCY_PARAM = "vs_currency";
    private static final String DEFAULT_VS_CURRENCY = "usd";
    private static final String IDS_PARAM = "ids";
    private static final String DEFAULT_IDS = "bitcoin,ethereum,tether,dogecoin,ripple";

    private final ObjectMapper objectMapper;

    public CoinGeckoApiClientService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public CoinMarketDataDto[] getCoinMarketData() throws IOException {
        String url = BASE_URL + MARKETS_ENDPOINT + "?" + VS_CURRENCY_PARAM + "=" + DEFAULT_VS_CURRENCY + "&" + IDS_PARAM + "=" + DEFAULT_IDS;
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL apiUrl = new URL(url);
            connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            StringBuilder response = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return objectMapper.readValue(response.toString(), CoinMarketDataDto[].class);
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
