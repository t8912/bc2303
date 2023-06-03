package com.codewave.project.projectcryptocoingecko2.service.impl;

//import org.springframework.beans.factory.annotation.Value;
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
public class CryptoServiceHolder implements CryptoService {
    private static final String COIN_GECKO_MARKET_DATA_URL = "https://api.coingecko.com/api/v3/coins/markets";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public CryptoServiceHolder(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<CoinDTO> getCoinMarketData(String currency) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(COIN_GECKO_MARKET_DATA_URL)
                //.queryParam("ids", "bitcoin,ethereum,tether,dogecoin,ripple,cardano,polkadot,binancecoin,uniswap,litecoin,chainlink,stellar,theta-token,wrapped-bitcoin,solana,filecoin,tron,vechain,cosmos,okb")
               // .queryParam("ids", "bitcoin,ethereum,tether,dogecoin,ripple,cardano,polkadot,binancecoin")
                .queryParam("vs_currency", currency)
                .queryParam("per_page", 20); // Set the per_page parameter to 20
                //.queryParam("per_page", 250);

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
import com.codewave.project.projectcryptocoingecko2.infra.response.ApiError;
import com.codewave.project.projectcryptocoingecko2.infra.response.ApiException;
import com.codewave.project.projectcryptocoingecko2.infra.util.CryptoApiUtil;
import com.codewave.project.projectcryptocoingecko2.model.dto.CoinDTO;
import com.codewave.project.projectcryptocoingecko2.service.CryptoService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CryptoServiceImpl implements CryptoService {
    private static final String COIN_GECKO_MARKET_DATA_URL = "https://api.coingecko.com/api/v3/coins/markets";

    private final RestTemplate restTemplate;

    public CryptoServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<CoinDTO> getCoinMarketData(String currency) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(COIN_GECKO_MARKET_DATA_URL)
                .queryParam("ids", "bitcoin,ethereum,tether,dogecoin,ripple")
                .queryParam("vs_currency", currency)
                .queryParam("per_page", 10); // Set the per_page parameter to 20

        HttpHeaders headers = CryptoApiUtil.createHeaders();
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<CoinDTO[]> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                CoinDTO[].class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            CoinDTO[] coinDTOs = response.getBody();

            List<CoinDTO> coins = new ArrayList<>(Arrays.asList(coinDTOs));

            return coins;
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
        // Replace the following line with your implementation
        return getCoinMarketData("usd");
    }
}

*/


/* 
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
public class CryptoServiceHolder implements CryptoService {
    private static final String COIN_GECKO_MARKET_DATA_URL = "https://api.coingecko.com/api/v3/coins/markets";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public CryptoServiceHolder(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<CoinDTO> getCoinMarketData(String currency) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(COIN_GECKO_MARKET_DATA_URL)
                .queryParam("ids", "bitcoin,ethereum,tether,dogecoin,ripple")
                .queryParam("vs_currency", currency);
                //.queryParam("per_page", 6); // retrieve the top 20 coins instead of the top 5 coins. output: show Top 20 (default only show Top 5)
                //.queryParam("per_page", 20);

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
            //apiError.setStatusCode(response.getStatusCodeValue());
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
*/


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
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CryptoServiceHolder implements CryptoService {
    private static final String COIN_GECKO_MARKET_DATA_URL = "https://api.coingecko.com/api/v3/coins/markets";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public CryptoServiceHolder(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<CoinDTO> getCoinMarketData(String currency) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(COIN_GECKO_MARKET_DATA_URL)
                .queryParam("vs_currency", currency)
                .queryParam("per_page", 250); // Set the per_page parameter to a larger value to fetch all coins

        HttpEntity<?> entity = new HttpEntity<>(CryptoApiUtil.createHeaders());
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                CoinDTO[] coinDTOs = objectMapper.readValue(response.getBody(), CoinDTO[].class);

                // Sort the coins by market cap in descending order
                List<CoinDTO> sortedCoins = Arrays.asList(coinDTOs);
                sortedCoins.sort(Comparator.comparing(CoinDTO::getMarketCap).reversed());

                // Return the top 20 coins
                return sortedCoins.stream().limit(20).collect(Collectors.toList());
            } catch (IOException e) {
                throw new ApiException("Failed to deserialize coin market data", e);
            }
        } else {
            ApiError apiError = new ApiError();
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
*/


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