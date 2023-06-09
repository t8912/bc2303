package com.codewave.project.projectcryptopolygon.service.impl;

import com.codewave.project.projectcryptopolygon.exception.ApiException;
import com.codewave.project.projectcryptopolygon.model.dto.ChannelDto;
import com.codewave.project.projectcryptopolygon.model.dto.ExchangeRate;
import com.codewave.project.projectcryptopolygon.service.PolygonCryptoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PolygonCryptoServiceImpl implements PolygonCryptoService {

    private static final String POLYGON_API_URL = "https://api.polygon.io/v2/aggs/ticker";
    private static final String API_KEY = "31m9PgPNd_WG2Jj95a06ER_0QrKfIGRt"; // Replace with your Polygon API key

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public PolygonCryptoServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        ChannelDto channelDto = new ChannelDto();
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        for (String coin : coins) {
            try {
                UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(POLYGON_API_URL)
                        .pathSegment("X:" + coin + "USD", "prev")
                        .queryParam("adjusted", true)
                        .queryParam("apiKey", API_KEY);

                ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);

                if (response.getStatusCode().is2xxSuccessful()) {
                    String responseBody = response.getBody();
                    if (responseBody != null) {
                        // Parse the response JSON
                        List<ExchangeRate> rates = parsePolygonResponse(responseBody, coin, currencies);
                        exchangeRates.addAll(rates);
                    }
                } else {
                    throw new ApiException("Failed to retrieve exchange rate for coin: " + coin);
                }
            } catch (Exception e) {
                throw new ApiException("Error retrieving exchange rate for coin: " + coin, e);
            }
        }

        channelDto.setExchangeRates(exchangeRates);
        return channelDto;
    }

    private List<ExchangeRate> parsePolygonResponse(String responseBody, String coin, List<String> currencies) throws IOException {
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        // Parse the response JSON using Jackson ObjectMapper
        // Adjust the parsing logic based on the actual structure of the response
        // Here, assuming the response contains a "results" array with objects representing exchange rates
        // Adjust the field names as per the actual response structure
        ExchangeRateResponse response = objectMapper.readValue(responseBody, ExchangeRateResponse.class);
        if (response != null && response.getStatus().equals("OK")) {
            List<ExchangeRateResult> results = response.getResults();
            if (results != null && !results.isEmpty()) {
                for (ExchangeRateResult result : results) {
                    String toCurr = coin + "HKD";
                    BigDecimal rate = result.getC().multiply(BigDecimal.valueOf(7.8));
                    ExchangeRate exchangeRate = new ExchangeRate(coin, toCurr, rate);
                    exchangeRates.add(exchangeRate);
                }
            }
        } else {
            throw new ApiException("Failed to retrieve exchange rate for coin: " + coin + ". Status: " + response.getStatus());
        }

        return exchangeRates;
    }

    // Inner classes to represent the response structure
    private static class ExchangeRateResponse {
        private String status;
        private List<ExchangeRateResult> results;

        public String getStatus() {
            return status;
        }

        public List<ExchangeRateResult> getResults() {
            return results;
        }
    }

    private static class ExchangeRateResult {
        private BigDecimal c;

        public BigDecimal getC() {
            return c;
        }
    }

    @Override
    public ChannelDto getCryptoExchangeRates(List<String> coins, List<String> currencies) {
        throw new UnsupportedOperationException("Unimplemented method 'getCryptoExchangeRates'");
    }
}


/* //OK with Ticker
import com.codewave.project.projectcryptopolygon.exception.ApiException;
import com.codewave.project.projectcryptopolygon.model.dto.ChannelDto;
import com.codewave.project.projectcryptopolygon.model.dto.ExchangeRate;
import com.codewave.project.projectcryptopolygon.service.PolygonCryptoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PolygonCryptoServiceImpl implements PolygonCryptoService {

    private static final String POLYGON_API_URL = "https://api.polygon.io/v2/aggs/ticker";
    private static final String API_KEY = "31m9PgPNd_WG2Jj95a06ER_0QrKfIGRt"; // Replace with your Polygon API key

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public PolygonCryptoServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        ChannelDto channelDto = new ChannelDto();
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        for (String coin : coins) {
            try {
                UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(POLYGON_API_URL)
                        .pathSegment("X:" + coin + "USD", "prev")
                        .queryParam("adjusted", true)
                        .queryParam("apiKey", API_KEY);

                ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);

                if (response.getStatusCode().is2xxSuccessful()) {
                    String responseBody = response.getBody();
                    if (responseBody != null) {
                        // Parse the response JSON
                        List<ExchangeRate> rates = parsePolygonResponse(responseBody, coin, currencies);
                        exchangeRates.addAll(rates);
                    }
                } else {
                    throw new ApiException("Failed to retrieve exchange rate for coin: " + coin);
                }
            } catch (Exception e) {
                throw new ApiException("Error retrieving exchange rate for coin: " + coin, e);
            }
        }

        channelDto.setExchangeRates(exchangeRates);
        return channelDto;
    }

    private List<ExchangeRate> parsePolygonResponse(String responseBody, String coin, List<String> currencies) throws IOException {
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        // Parse the response JSON using Jackson ObjectMapper
        ExchangeRateResponse response = objectMapper.readValue(responseBody, ExchangeRateResponse.class);
        List<ExchangeRateResult> results = response.getResults();
        if (results != null && !results.isEmpty()) {
            for (ExchangeRateResult result : results) {
                BigDecimal usdRate = result.getC();
                BigDecimal hkdRate = usdRate.multiply(BigDecimal.valueOf(7.8));
                ExchangeRate exchangeRate = new ExchangeRate(coin, "HKD", hkdRate);
                exchangeRates.add(exchangeRate);
            }
        }

        return exchangeRates;
    }

    // Inner classes to represent the response structure
    private static class ExchangeRateResponse {
        private String status;
        private List<ExchangeRateResult> results;

        public String getStatus() {
            return status;
        }

        public List<ExchangeRateResult> getResults() {
            return results;
        }
    }

    private static class ExchangeRateResult {
        private String ticker;
        private BigDecimal c;

        public String getTicker() {
            return ticker;
        }

        public BigDecimal getC() {
            return c;
        }
    }

    @Override
    public ChannelDto getCryptoExchangeRates(List<String> coins, List<String> currencies) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCryptoExchangeRates'");
    }
}
*/


/* /////////
import com.codewave.project.projectcryptopolygon.exception.ApiException;
import com.codewave.project.projectcryptopolygon.model.dto.ChannelDto;
import com.codewave.project.projectcryptopolygon.model.dto.ExchangeRate;
import com.codewave.project.projectcryptopolygon.service.PolygonCryptoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PolygonCryptoServiceImpl implements PolygonCryptoService {

    private static final String POLYGON_API_URL = "https://api.polygon.io/v2/aggs/ticker";
    private static final String API_KEY = "31m9PgPNd_WG2Jj95a06ER_0QrKfIGRt"; // Replace with your Polygon API key

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public PolygonCryptoServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        ChannelDto channelDto = new ChannelDto();
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        for (String coin : coins) {
            try {
                UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(POLYGON_API_URL)
                        .pathSegment("X:" + coin + "USD", "prev")
                        .queryParam("adjusted", true)
                        .queryParam("apiKey", API_KEY);

                ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);

                if (response.getStatusCode().is2xxSuccessful()) {
                    String responseBody = response.getBody();
                    if (responseBody != null) {
                        // Parse the response JSON
                        List<ExchangeRate> rates = parsePolygonResponse(responseBody, coin, currencies);
                        exchangeRates.addAll(rates);
                    }
                } else {
                    throw new ApiException("Failed to retrieve exchange rate for coin: " + coin);
                }
            } catch (Exception e) {
                throw new ApiException("Error retrieving exchange rate for coin: " + coin, e);
            }
        }

        channelDto.setExchangeRates(exchangeRates);
        return channelDto;
    }

    private List<ExchangeRate> parsePolygonResponse(String responseBody, String coin, List<String> currencies) throws IOException {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
    
        // Parse the response JSON using Jackson ObjectMapper
        // Adjust the parsing logic based on the actual structure of the response
        // Here, assuming the response contains an "exchangeRates" array
        ExchangeRateResponse response = objectMapper.readValue(responseBody, ExchangeRateResponse.class);
        List<ExchangeRateResult> results = response.getExchangeRates();
        if (results != null && !results.isEmpty()) {
            for (ExchangeRateResult result : results) {
                String ticker = result.getTicker();
                if (ticker != null) {
                    String toCurr = ticker.replace(coin + "USD", "HKD");
                    BigDecimal rate = result.getC();
                    ExchangeRate exchangeRate = new ExchangeRate(coin, toCurr, rate);
                    exchangeRates.add(exchangeRate);
                }
            }
        }
    
        return exchangeRates;
    }
    
    

    // private List<ExchangeRate> parsePolygonResponse(String responseBody, String coin, List<String> currencies) throws IOException {
    //     List<ExchangeRate> exchangeRates = new ArrayList<>();

    //     // Parse the response JSON using Jackson ObjectMapper
    //     // Adjust the parsing logic based on the actual structure of the response
    //     // Here, assuming the response contains a "results" array with objects representing exchange rates
    //     // Adjust the field names as per the actual response structure
    //     List<ExchangeRateResponse> responseList = objectMapper.readValue(responseBody, new TypeReference<List<ExchangeRateResponse>>() {});
    //     if (responseList != null && !responseList.isEmpty()) {
    //         ExchangeRateResponse response = responseList.get(0);
    //         if (response.getStatus().equals("OK")) {
    //             List<ExchangeRateResult> results = response.getResults();
    //             if (results != null && !results.isEmpty()) {
    //                 for (ExchangeRateResult result : results) {
    //                     String toCurr = result.getTicker().replace(coin + "USD", "HKD");
    //                     BigDecimal rate = result.getC();
    //                     ExchangeRate exchangeRate = new ExchangeRate(coin, toCurr, rate);
    //                     exchangeRates.add(exchangeRate);
    //                 }
    //             }
    //         } else {
    //             throw new ApiException("Failed to retrieve exchange rate for coin: " + coin + ". Status: " + response.getStatus());
    //         }
    //     }

    //     return exchangeRates;
    // }

    // Inner classes to represent the response structure
    private static class ExchangeRateResponse {
        private String status;
        private List<ExchangeRateResult> results;

        public String getStatus() {
            return status;
        }

        public List<ExchangeRateResult> getExchangeRates() {
            return null;
        }

        public List<ExchangeRateResult> getResults() {
            return results;
        }
    }

    private static class ExchangeRateResult {
        private String ticker;
        private BigDecimal c;

        public String getTicker() {
            return ticker;
        }

        public BigDecimal getC() {
            return c;
        }
    }

    @Override
    public ChannelDto getCryptoExchangeRates(List<String> coins, List<String> currencies) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCryptoExchangeRates'");
    }
}
*/



/* 
import com.codewave.project.projectcryptopolygon.exception.ApiException;
import com.codewave.project.projectcryptopolygon.model.dto.ChannelDto;
import com.codewave.project.projectcryptopolygon.model.dto.ExchangeRate;
import com.codewave.project.projectcryptopolygon.service.PolygonCryptoService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PolygonCryptoServiceImpl implements PolygonCryptoService {

    private static final String POLYGON_API_URL = "https://api.polygon.io/v2/aggs/ticker";
    private static final String API_KEY = "31m9PgPNd_WG2Jj95a06ER_0QrKfIGRt"; // Replace with your Polygon API key

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public PolygonCryptoServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        ChannelDto channelDto = new ChannelDto();
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        for (String coin : coins) {
            try {
                UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(POLYGON_API_URL)
                        .pathSegment("X:" + coin + "USD", "prev")
                        .queryParam("adjusted", true)
                        .queryParam("apiKey", API_KEY);

                ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);

                if (response.getStatusCode().is2xxSuccessful()) {
                    String responseBody = response.getBody();
                    if (responseBody != null) {
                        // Parse the response JSON
                        List<ExchangeRate> rates = parsePolygonResponse(responseBody, coin, currencies);
                        exchangeRates.addAll(rates);
                    }
                } else {
                    throw new ApiException("Failed to retrieve exchange rate for coin: " + coin);
                }
            } catch (HttpClientErrorException e) {
                if (e.getStatusCode().equals(HttpStatus.TOO_MANY_REQUESTS)) {
                    throw new ApiException("Too many requests. Please wait or upgrade your subscription to continue.", e);
                } else {
                    throw new ApiException("Failed to retrieve exchange rate for coin: " + coin, e);
                }
            } catch (Exception e) {
                throw new ApiException("Error retrieving exchange rate for coin: " + coin, e);
            }
        }

        channelDto.setExchangeRates(exchangeRates);
        return channelDto;
    }

    private List<ExchangeRate> parsePolygonResponse(String responseBody, String coin, List<String> currencies) throws IOException {
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(responseBody);

        JsonNode resultNode = rootNode.get("results");
        if (resultNode != null && resultNode.isArray()) {
            for (JsonNode node : resultNode) {
                String ticker = node.get("T").asText();
                BigDecimal rate = node.get("c").decimalValue();
                ExchangeRate exchangeRate = new ExchangeRate(ticker, rate);
                exchangeRates.add(exchangeRate);
            }
        }

        return exchangeRates;
    }

    @Override
    public ChannelDto getCryptoExchangeRates(List<String> coins, List<String> currencies) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCryptoExchangeRates'");
    }
}
*/

/* 
import com.codewave.project.projectcryptopolygon.exception.ApiException;
import com.codewave.project.projectcryptopolygon.model.dto.ChannelDto;
import com.codewave.project.projectcryptopolygon.model.dto.ExchangeRate;
import com.codewave.project.projectcryptopolygon.service.PolygonCryptoService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PolygonCryptoServiceImpl implements PolygonCryptoService {

    private static final String POLYGON_API_URL = "https://api.polygon.io/v2/aggs/ticker";
    private static final String API_KEY = "31m9PgPNd_WG2Jj95a06ER_0QrKfIGRt"; // Replace with your Polygon API key

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public PolygonCryptoServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        ChannelDto channelDto = new ChannelDto();
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        for (String coin : coins) {
            try {
                UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(POLYGON_API_URL)
                        .pathSegment("X:" + coin + "USD", "prev")
                        .queryParam("adjusted", true)
                        .queryParam("apiKey", API_KEY);

                ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);

                if (response.getStatusCode().is2xxSuccessful()) {
                    String responseBody = response.getBody();
                    if (responseBody != null) {
                        // Parse the response JSON
                        List<ExchangeRate> rates = parsePolygonResponse(responseBody, coin, currencies);
                        exchangeRates.addAll(rates);
                    }
                } else {
                    throw new ApiException("Failed to retrieve exchange rate for coin: " + coin);
                }
            } catch (Exception e) {
                throw new ApiException("Error retrieving exchange rate for coin: " + coin, e);
            }
        }

        channelDto.setExchangeRates(exchangeRates);
        return channelDto;
    }


    private List<ExchangeRate> parsePolygonResponse(String responseBody, String coin, List<String> currencies) throws IOException {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
    
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(responseBody);
    
        JsonNode resultNode = rootNode.get("results");
        if (resultNode != null && resultNode.isArray()) {
            for (JsonNode node : resultNode) {
                String ticker = node.get("T").asText();
                BigDecimal rate = node.get("c").decimalValue();
                String[] tickerSplit = ticker.split(":");
                if (tickerSplit.length == 2) {
                    String fromCurr = tickerSplit[0];
                    String toCurr = tickerSplit[1];
                    if (currencies.contains(fromCurr) && currencies.contains(toCurr)) {
                        ExchangeRate exchangeRate = new ExchangeRate();
                        exchangeRate.setTicker(ticker);
                        exchangeRate.setRate(rate);
                        exchangeRate.setFromCurr(fromCurr);
                        exchangeRate.setToCurr(toCurr);
                        exchangeRates.add(exchangeRate);
                    }
                }
            }
        } else {
            throw new ApiException("No valid results found in the Polygon API response for coin: " + coin);
        }
    
        return exchangeRates;
    }
    

    // private List<ExchangeRate> parsePolygonResponse(String responseBody, String coin, List<String> currencies) throws IOException {
    //     List<ExchangeRate> exchangeRates = new ArrayList<>();
    
    //     ObjectMapper objectMapper = new ObjectMapper();
    //     JsonNode rootNode = objectMapper.readTree(responseBody);
    
    //     JsonNode resultNode = rootNode.get("results");
    //     if (resultNode != null && resultNode.isArray()) {
    //         for (JsonNode node : resultNode) {
    //             String ticker = node.get("T").asText();
    //             BigDecimal rate = node.get("c").decimalValue();
    //             ExchangeRate exchangeRate = new ExchangeRate();
    //             exchangeRate.setTicker(ticker);
    //             exchangeRate.setRate(rate);
    //             String[] tickerSplit = ticker.split(":");
    //             if (tickerSplit.length == 2) {
    //                 String fromCurr = tickerSplit[0];
    //                 String toCurr = tickerSplit[1];
    //                 if (currencies.contains(fromCurr) && currencies.contains(toCurr)) {
    //                     exchangeRate.setFromCurr(fromCurr);
    //                     exchangeRate.setToCurr(toCurr);
    //                     exchangeRates.add(exchangeRate);
    //                 }
    //             }
    //         }
    //     } else {
    //         throw new ApiException("No valid results found in the Polygon API response for coin: " + coin);
    //     }
    
    //     return exchangeRates;
    // }
    




    // private List<ExchangeRate> parsePolygonResponse(String responseBody, String coin, List<String> currencies) throws IOException {
    //     List<ExchangeRate> exchangeRates = new ArrayList<>();
    
    //     ObjectMapper objectMapper = new ObjectMapper();
    //     JsonNode rootNode = objectMapper.readTree(responseBody);
    
    //     JsonNode resultNode = rootNode.get("results");
    //     if (resultNode != null && resultNode.isArray()) {
    //         for (JsonNode node : resultNode) {
    //             String ticker = node.get("T").asText();
    //             BigDecimal rate = node.get("c").decimalValue();
    //             ExchangeRate exchangeRate = new ExchangeRate(ticker, rate); // The constructor ExchangeRate is undefined, need create it in ExchangeRate.java
    //             exchangeRates.add(exchangeRate);
    //         }
    //     } else {
    //         throw new ApiException("No valid results found in the Polygon API response for coin: " + coin);
    //     }
    
    //     return exchangeRates;
    // }
    

//     private List<ExchangeRate> parsePolygonResponse(String responseBody, String coin, List<String> currencies) throws IOException {
//         List<ExchangeRate> exchangeRates = new ArrayList<>();

//         ObjectMapper objectMapper = new ObjectMapper();
//         JsonNode rootNode = objectMapper.readTree(responseBody);
//         JsonNode resultsNode = rootNode.get("results");

//         if (resultsNode != null && resultsNode.isArray()) {
//             for (JsonNode resultNode : resultsNode) {
//                 String ticker = resultNode.get("ticker").asText();
//                 BigDecimal rate = resultNode.get("c").decimalValue();
//                 ExchangeRate exchangeRate = new ExchangeRate(ticker, ticker, rate);
//                 exchangeRates.add(exchangeRate);
//             }
//         }

//         return exchangeRates;
//     }

    @Override
    public ChannelDto getCryptoExchangeRates(List<String> coins, List<String> currencies) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCryptoExchangeRates'");
    }
}
*/

 /*
import com.codewave.project.projectcryptopolygon.exception.ApiException;
import com.codewave.project.projectcryptopolygon.model.dto.ChannelDto;
import com.codewave.project.projectcryptopolygon.model.dto.ExchangeRate;
import com.codewave.project.projectcryptopolygon.service.PolygonCryptoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PolygonCryptoServiceImpl implements PolygonCryptoService {

    private static final String POLYGON_API_URL = "https://api.polygon.io/v2/aggs/ticker";
    private static final String API_KEY = "31m9PgPNd_WG2Jj95a06ER_0QrKfIGRt"; // Replace with your Polygon API key

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public PolygonCryptoServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        ChannelDto channelDto = new ChannelDto();
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        for (String coin : coins) {
            try {
                UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(POLYGON_API_URL)
                        .pathSegment("X:" + coin + "USD", "prev")
                        .queryParam("adjusted", true)
                        .queryParam("apiKey", API_KEY);

                ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);

                if (response.getStatusCode().is2xxSuccessful()) {
                    String responseBody = response.getBody();
                    if (responseBody != null) {
                        // Parse the response JSON
                        List<ExchangeRate> rates = parsePolygonResponse(responseBody, coin, currencies);
                        exchangeRates.addAll(rates);
                    }
                } else {
                    throw new ApiException("Failed to retrieve exchange rate for coin: " + coin);
                }
            } catch (Exception e) {
                throw new ApiException("Error retrieving exchange rate for coin: " + coin, e);
            }
        }

        channelDto.setExchangeRates(exchangeRates);
        return channelDto;
    }

    private List<ExchangeRate> parsePolygonResponse(String responseBody, String coin, List<String> currencies) throws IOException {
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        // Parse the response JSON using Jackson ObjectMapper
        // Adjust the parsing logic based on the actual structure of the response
        // Here, assuming the response contains a "results" array with objects representing exchange rates
        // Adjust the field names as per the actual response structure
        List<ExchangeRateResponse> responseList = objectMapper.readValue(responseBody, new TypeReference<List<ExchangeRateResponse>>() {});
        if (responseList != null && !responseList.isEmpty()) {
            ExchangeRateResponse response = responseList.get(0);
            if (response.getStatus().equals("OK")) {
                List<ExchangeRateResult> results = response.getResults();
                if (results != null && !results.isEmpty()) {
                    for (ExchangeRateResult result : results) {
                        String toCurr = result.getTicker().replace(coin + "USD", "HKD");
                        BigDecimal rate = result.getC();
                        ExchangeRate exchangeRate = new ExchangeRate(coin, toCurr, rate);
                        exchangeRates.add(exchangeRate);
                    }
                }
            } else {
                throw new ApiException("Failed to retrieve exchange rate for coin: " + coin + ". Status: " + response.getStatus());
            }
        }

        return exchangeRates;
    }

    // Inner classes to represent the response structure
    public static class ExchangeRateResponse {
        private String status;
        private List<ExchangeRateResult> results;

        public String getStatus() {
            return status;
        }

        public List<ExchangeRateResult> getResults() {
            return results;
        }
    }

    public static class ExchangeRateResult {
        private String ticker;
        private BigDecimal c;

        public String getTicker() {
            return ticker;
        }

        public BigDecimal getC() {
            return c;
        }
    }

    @Override
    public ChannelDto getCryptoExchangeRates(List<String> coins, List<String> currencies) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCryptoExchangeRates'");
    }

    private List<ExchangeRate> parsePolygonResponse(String responseBody, String coin, List<String> currencies) throws IOException { // Duplicate method 
        List<ExchangeRate> exchangeRates = new ArrayList<>();
    
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(responseBody);
        JsonNode resultsNode = rootNode.get("results");
    
        if (resultsNode != null && resultsNode.isArray()) {
            for (JsonNode resultNode : resultsNode) {
                String ticker = resultNode.get("ticker").asText();
                BigDecimal rate = resultNode.get("c").decimalValue();
                ExchangeRate exchangeRate = new ExchangeRate(ticker, rate);
                exchangeRates.add(exchangeRate);
            }
        }
    
        return exchangeRates;
    }
    

}
*/

/* /////////
import com.codewave.project.projectcryptopolygon.exception.ApiException;
import com.codewave.project.projectcryptopolygon.model.dto.ChannelDto;
import com.codewave.project.projectcryptopolygon.model.dto.ExchangeRate;
import com.codewave.project.projectcryptopolygon.service.PolygonCryptoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PolygonCryptoServiceImpl implements PolygonCryptoService {

    private static final String POLYGON_API_URL = "https://api.polygon.io/v2/aggs/ticker";
    private static final String API_KEY = "31m9PgPNd_WG2Jj95a06ER_0QrKfIGRt"; // Replace with your Polygon API key

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public PolygonCryptoServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        ChannelDto channelDto = new ChannelDto();
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        for (String coin : coins) {
            try {
                UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(POLYGON_API_URL)
                        .pathSegment("X:" + coin + "USD", "prev")
                        .queryParam("adjusted", true)
                        .queryParam("apiKey", API_KEY);

                ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);

                if (response.getStatusCode().is2xxSuccessful()) {
                    String responseBody = response.getBody();
                    if (responseBody != null) {
                        // Parse the response JSON
                        List<ExchangeRate> rates = parsePolygonResponse(responseBody, coin, currencies);
                        exchangeRates.addAll(rates);
                    }
                } else {
                    throw new ApiException("Failed to retrieve exchange rate for coin: " + coin);
                }
            } catch (Exception e) {
                throw new ApiException("Error retrieving exchange rate for coin: " + coin, e);
            }
        }

        channelDto.setExchangeRates(exchangeRates);
        return channelDto;
    }

    private List<ExchangeRate> parsePolygonResponse(String responseBody, String coin, List<String> currencies) throws IOException {
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        // Parse the response JSON using Jackson ObjectMapper
        // Adjust the parsing logic based on the actual structure of the response
        // Here, assuming the response contains a "results" array with objects representing exchange rates
        // Adjust the field names as per the actual response structure
        List<ExchangeRateResponse> responseList = objectMapper.readValue(responseBody, new TypeReference<List<ExchangeRateResponse>>() {});
        if (responseList != null && !responseList.isEmpty()) {
            ExchangeRateResponse response = responseList.get(0);
            if (response.getStatus().equals("OK")) {
                List<ExchangeRateResult> results = response.getResults();
                if (results != null && !results.isEmpty()) {
                    for (ExchangeRateResult result : results) {
                        String toCurr = result.getTicker().replace(coin + "USD", "HKD");
                        BigDecimal rate = result.getC();
                        ExchangeRate exchangeRate = new ExchangeRate(coin, toCurr, rate);
                        exchangeRates.add(exchangeRate);
                    }
                }
            } else {
                throw new ApiException("Failed to retrieve exchange rate for coin: " + coin + ". Status: " + response.getStatus());
            }
        }

        return exchangeRates;
    }

    // Inner classes to represent the response structure
    private static class ExchangeRateResponse {
        private String status;
        private List<ExchangeRateResult> results;

        public String getStatus() {
            return status;
        }

        public List<ExchangeRateResult> getResults() {
            return results;
        }
    }

    private static class ExchangeRateResult {
        private String ticker;
        private BigDecimal c;

        public String getTicker() {
            return ticker;
        }

        public BigDecimal getC() {
            return c;
        }
    }

    @Override
    public ChannelDto getCryptoExchangeRates(List<String> coins, List<String> currencies) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCryptoExchangeRates'");
    }
}
*/

/* 
import com.codewave.project.projectcryptopolygon.exception.ApiException;
import com.codewave.project.projectcryptopolygon.model.dto.ChannelDto;
import com.codewave.project.projectcryptopolygon.model.dto.ExchangeRate;
import com.codewave.project.projectcryptopolygon.service.PolygonCryptoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PolygonCryptoServiceImpl implements PolygonCryptoService {

    private static final String POLYGON_API_URL = "https://api.polygon.io/v2/aggs/ticker";
    private static final String API_KEY = "31m9PgPNd_WG2Jj95a06ER_0QrKfIGRt"; // Replace with your Polygon API key

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public PolygonCryptoServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        ChannelDto channelDto = new ChannelDto();
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        for (String coin : coins) {
            try {
                UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(POLYGON_API_URL)
                        .pathSegment("X:" + coin + "USD", "prev")
                        .queryParam("adjusted", true)
                        .queryParam("apiKey", API_KEY);

                ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);

                if (response.getStatusCode().is2xxSuccessful()) {
                    String responseBody = response.getBody();
                    if (responseBody != null) {
                        // Parse the response JSON
                        List<ExchangeRate> rates = parsePolygonResponse(responseBody, coin, currencies);
                        exchangeRates.addAll(rates);
                    }
                } else {
                    throw new ApiException("Failed to retrieve exchange rate for coin: " + coin);
                }
            } catch (Exception e) {
                throw new ApiException("Error retrieving exchange rate for coin: " + coin, e);
            }
        }

        channelDto.setExchangeRates(exchangeRates);
        return channelDto;
    }

    @Override
    public ChannelDto getCryptoExchangeRates(List<String> coins, List<String> currencies) { // Duplicate method getCrytoExchangeRates(List<String>, List<String>) in type PolygonCryptoServiceImpl
        ChannelDto channelDto = new ChannelDto();
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        // Implementation of the getCryptoExchangeRates method
        // Replace or modify the code as per your requirements
        // Example implementation:
        for (String coin : coins) {
            // Perform operations to get exchange rates
            // Add exchange rates to the exchangeRates list
        }

        channelDto.setExchangeRates(exchangeRates);
        return channelDto;
    }

    private List<ExchangeRate> parsePolygonResponse(String responseBody, String coin, List<String> currencies) throws IOException {
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        // Parse the response JSON using Jackson ObjectMapper
        // Adjust the parsing logic based on the actual structure of the response
        // Here, assuming the response contains a "results" array with objects representing exchange rates
        // Adjust the field names as per the actual response structure
        List<ExchangeRateResponse> responseList = objectMapper.readValue(responseBody, new TypeReference<List<ExchangeRateResponse>>() {});
        if (responseList != null && !responseList.isEmpty()) {
            ExchangeRateResponse response = responseList.get(0);
            if (response.getStatus().equals("OK")) {
                List<ExchangeRateResult> results = response.getResults();
                if (results != null && !results.isEmpty()) {
                    for (ExchangeRateResult result : results) {
                        String toCurr = result.getTicker().replace(coin + "USD", "HKD");
                        BigDecimal rate = result.getC();
                        ExchangeRate exchangeRate = new ExchangeRate(coin, toCurr, rate);
                        exchangeRates.add(exchangeRate);
                    }
                }
            } else {
                throw new ApiException("Failed to retrieve exchange rate for coin: " + coin + ". Status: " + response.getStatus());
            }
        }

        return exchangeRates;
    }

    // Inner classes to represent the response structure
    private static class ExchangeRateResponse {
        private String status;
        private List<ExchangeRateResult> results;

        public String getStatus() {
            return status;
        }

        public List<ExchangeRateResult> getResults() {
            return results;
        }
    }

    private static class ExchangeRateResult {
        private String ticker;
        private BigDecimal c;

        public String getTicker() {
            return ticker;
        }

        public BigDecimal getC() {
            return c;
        }
    }

    @Override
    public void getCryptoExchangeRates(List<String> currencies, List<String> symbols) { // Duplicate method getCrytoExchangeRates(List<String>, List<String>) in type PolygonCryptoServiceImpl
        // Implementation of the getCryptoExchangeRates method
        // ...
        // Replace or modify the code as per your requirements
    }
}
*/

/* 
import com.codewave.project.projectcryptopolygon.exception.ApiException;
import com.codewave.project.projectcryptopolygon.infra.util.CryptoApiUtil;
import com.codewave.project.projectcryptopolygon.model.dto.ExchangeRate;
import com.codewave.project.projectcryptopolygon.service.PolygonCryptoService;
import com.codewave.project.projectcryptopolygon.model.dto.ChannelDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PolygonCryptoServiceImpl implements PolygonCryptoService {

    private static final String POLYGON_API_URL = "https://api.polygon.io/v2/aggs/ticker";
    private static final String API_KEY = "YOUR_POLYGON_API_KEY"; // Replace with your Polygon API key

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public PolygonCryptoServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public ChannelDto getCryptoExchangeRates(List<String> coins, List<String> currencies) {
        ChannelDto channelDto = new ChannelDto();
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        for (String coin : coins) {
            try {
                UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(POLYGON_API_URL)
                        .pathSegment("X:" + coin + "USD", "prev")
                        .queryParam("adjusted", true)
                        .queryParam("apiKey", API_KEY);

                ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);

                if (response.getStatusCode().is2xxSuccessful()) {
                    String responseBody = response.getBody();
                    if (responseBody != null) {
                        // Parse the response JSON
                        List<ExchangeRate> rates = parsePolygonResponse(responseBody, coin, currencies);
                        exchangeRates.addAll(rates);
                    }
                } else {
                    throw new ApiException("Failed to retrieve exchange rate for coin: " + coin);
                }
            } catch (Exception e) {
                throw new ApiException("Error retrieving exchange rate for coin: " + coin, e);
            }
        }

        channelDto.setExchangeRates(exchangeRates);
        return channelDto;
    }

    private List<ExchangeRate> parsePolygonResponse(String responseBody, String coin, List<String> currencies) throws IOException {
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        // Parse the response JSON using Jackson ObjectMapper
        // Adjust the parsing logic based on the actual structure of the response
        // Here, assuming the response contains a "results" array with objects representing exchange rates
        // Adjust the field names as per the actual response structure
        List<ExchangeRateResponse> responseList = objectMapper.readValue(responseBody, new TypeReference<List<ExchangeRateResponse>>() {});
        if (responseList != null && !responseList.isEmpty()) {
            ExchangeRateResponse response = responseList.get(0);
            if (response.getStatus().equals("OK")) {
                List<ExchangeRateResult> results = response.getResults();
                if (results != null && !results.isEmpty()) {
                    for (ExchangeRateResult result : results) {
                        String toCurr = result.getTicker().replace(coin + "USD", "HKD");
                        BigDecimal rate = result.getC();
                        ExchangeRate exchangeRate = new ExchangeRate(coin, toCurr, rate);
                        exchangeRates.add(exchangeRate);
                    }
                }
            } else {
                throw new ApiException("Failed to retrieve exchange rate for coin: " + coin + ". Status: " + response.getStatus());
            }
        }

        return exchangeRates;
    }

    // Inner classes to represent the response structure
    private static class ExchangeRateResponse {
        private String status;
        private List<ExchangeRateResult> results;

        public String getStatus() {
            return status;
        }

        public List<ExchangeRateResult> getResults() {
            return results;
        }
    }

    private static class ExchangeRateResult {
        private String ticker;
        private BigDecimal c;

        public String getTicker() {
            return ticker;
        }

        public BigDecimal getC() {
            return c;
        }
    }

    @Override
    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCryptoExchangeRate'");
    }
}
*/


/* 
import com.codewave.project.projectcryptopolygon.exception.ApiException;
import com.codewave.project.projectcryptopolygon.infra.util.CryptoApiUtil;
import com.codewave.project.projectcryptopolygon.model.dto.ExchangeRate;
import com.codewave.project.projectcryptopolygon.service.PolygonCryptoService;
import com.codewave.project.projectcryptopolygon.model.dto.ChannelDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PolygonCryptoServiceImpl implements PolygonCryptoService {

    private static final String POLYGON_API_URL = "https://api.polygon.io/v2/aggs/ticker";
    private static final String API_KEY = "YOUR_POLYGON_API_KEY"; // Replace with your Polygon API key

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public PolygonCryptoServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        ChannelDto channelDto = new ChannelDto();
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        for (String coin : coins) {
            try {
                UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(POLYGON_API_URL)
                        .pathSegment("X:" + coin + "USD", "prev")
                        .queryParam("adjusted", true)
                        .queryParam("apiKey", API_KEY);

                ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);

                if (response.getStatusCode().is2xxSuccessful()) {
                    String responseBody = response.getBody();
                    if (responseBody != null) {
                        // Parse the response JSON
                        List<ExchangeRate> rates = parsePolygonResponse(responseBody, coin, currencies);
                        exchangeRates.addAll(rates);
                    }
                } else {
                    throw new ApiException("Failed to retrieve exchange rate for coin: " + coin);
                }
            } catch (Exception e) {
                throw new ApiException("Error retrieving exchange rate for coin: " + coin, e);
            }
        }

        channelDto.setExchangeRates(exchangeRates);
        return channelDto;
    }

    private List<ExchangeRate> parsePolygonResponse(String responseBody, String coin, List<String> currencies) throws IOException {
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        // Parse the response JSON using Jackson ObjectMapper
        // Adjust the parsing logic based on the actual structure of the response
        // Here, assuming the response contains a "results" array with objects representing exchange rates
        // Adjust the field names as per the actual response structure
        List<ExchangeRateResponse> responseList = objectMapper.readValue(responseBody, new TypeReference<List<ExchangeRateResponse>>() {});
        if (responseList != null && !responseList.isEmpty()) {
            ExchangeRateResponse response = responseList.get(0);
            if (response.getStatus().equals("OK")) {
                List<ExchangeRateResult> results = response.getResults();
                if (results != null && !results.isEmpty()) {
                    for (ExchangeRateResult result : results) {
                        String toCurr = result.getTicker().replace(coin + "USD", "HKD");
                        BigDecimal rate = result.getC();
                        ExchangeRate exchangeRate = new ExchangeRate(coin, toCurr, rate);
                        exchangeRates.add(exchangeRate);
                    }
                }
            } else {
                throw new ApiException("Failed to retrieve exchange rate for coin: " + coin + ". Status: " + response.getStatus());
            }
        }

        return exchangeRates;
    }

    // Inner classes to represent the response structure
    private static class ExchangeRateResponse {
        private String status;
        private List<ExchangeRateResult> results;

        public String getStatus() {
            return status;
        }

        public List<ExchangeRateResult> getResults() {
            return results;
        }
    }

    private static class ExchangeRateResult {
        private String ticker;
        private BigDecimal c;

        public String getTicker() {
            return ticker;
        }

        public BigDecimal getC() {
            return c;
        }
    }

    @Override
    public ChannelDto getCryptoExchangeRates(List<String> coins, List<String> currencies) { // Please fix
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCryptoExchangeRates'");
    }

    @Override
    public void getCryptoExchangeRates(List<String> currencies, List<String> symbols) { // Please fix
        // Implementation of the getCryptoExchangeRates method
    }
}
*/