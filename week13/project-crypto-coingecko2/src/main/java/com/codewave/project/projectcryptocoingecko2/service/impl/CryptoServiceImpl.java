package com.codewave.project.projectcryptocoingecko2.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.codewave.project.projectcryptocoingecko2.infra.response.ApiError;
import com.codewave.project.projectcryptocoingecko2.infra.response.ApiException;
import com.codewave.project.projectcryptocoingecko2.infra.util.CryptoApiUtil;
import com.codewave.project.projectcryptocoingecko2.model.dto.CoinDTO;
import com.codewave.project.projectcryptocoingecko2.service.CryptoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class CryptoServiceImpl implements CryptoService {
    private static final String COIN_GECKO_MARKET_DATA_URL = "https://api.coingecko.com/api/v3/coins/markets";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public CryptoServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<CoinDTO> getCoinMarketData(String currency) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(COIN_GECKO_MARKET_DATA_URL)
                .queryParam("ids", "bitcoin,ethereum,tether,dogecoin,ripple")
                .queryParam("vs_currency", currency);

        HttpEntity<?> entity = new HttpEntity<>(CryptoApiUtil.createHeaders());
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                CoinDTO[] coinDTOs = objectMapper.readValue(response.getBody(), CoinDTO[].class);
                return Arrays.asList(coinDTOs);
            } catch (IOException e) {
                throw new ApiException("Failed to deserialize coin market data", e);
            }
        } else {
            ApiError apiError = new ApiError();
           // apiError.setStatusCode(response.getStatusCodeValue());
            apiError.setStatusCode(response.getStatusCode().value()); 
            apiError.setMessage("Failed to retrieve coin market data");
            throw new ApiException(apiError);
        }
    }

    @Override
    public List<CoinDTO> getMarketData() {
        // TODO: Implement the logic for retrieving market data
        // Replace the following line with your implementation
        return getCoinMarketData("usd");
    }
}



/* 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.codewave.project.projectcryptocoingecko2.infra.response.ApiError;
import com.codewave.project.projectcryptocoingecko2.infra.response.ApiException;
import com.codewave.project.projectcryptocoingecko2.infra.util.CryptoApiUtil;
import com.codewave.project.projectcryptocoingecko2.model.dto.CoinDTO;
import com.codewave.project.projectcryptocoingecko2.service.CryptoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class CryptoServiceImpl implements CryptoService {
    private static final String COIN_GECKO_MARKET_DATA_URL = "https://api.coingecko.com/api/v3/coins/markets";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public CryptoServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<CoinDTO> getCoinMarketData(String currency) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(COIN_GECKO_MARKET_DATA_URL)
                .queryParam("ids", "bitcoin,ethereum,tether,dogecoin,ripple")
                .queryParam("vs_currency", currency);

        HttpEntity<?> entity = new HttpEntity<>(CryptoApiUtil.createHeaders());
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                CoinDTO[] coinDTOs = objectMapper.readValue(response.getBody(), CoinDTO[].class);
                return Arrays.asList(coinDTOs);
            } catch (IOException e) {
                throw new ApiException("Failed to deserialize coin market data", e);
            }
        } else {
            ApiError apiError = new ApiError();
            apiError.setStatusCode(response.getStatusCodeValue());
            apiError.setMessage("Failed to retrieve coin market data");
            throw new ApiException(apiError);
        }
    }

    @Override
    public List<CoinDTO> getMarketData() {
        // TODO: Implement the logic for retrieving market data
        throw new UnsupportedOperationException("Unimplemented method 'getMarketData'");
    }
}
*/