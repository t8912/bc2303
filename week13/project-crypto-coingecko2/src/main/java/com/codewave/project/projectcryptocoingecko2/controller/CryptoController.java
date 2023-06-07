package com.codewave.project.projectcryptocoingecko2.controller;

/* 
import com.codewave.project.projectcryptocoingecko2.model.dto.ChannelDto;
import com.codewave.project.projectcryptocoingecko2.service.CoinGeckoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/crypto/api/v1/coingecko")
public class CryptoController {

    private final CoinGeckoService coinGeckoService;

    @Autowired
    public CryptoController(CoinGeckoService coinGeckoService) {
        this.coinGeckoService = coinGeckoService;
    }

    @GetMapping("/simple-price")
    public ChannelDto getCryptoExchangeRate() {
        List<String> coins = Arrays.asList("bitcoin", "ethereum", "usdt", "xrp", "doge");
        List<String> currencies = Arrays.asList("usd", "hkd");

        return coinGeckoService.getCryptoExchangeRate(coins, currencies);
    }
}

*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.project.projectcryptocoingecko2.model.dto.CoinDTO;
import com.codewave.project.projectcryptocoingecko2.service.CryptoService;

import java.util.List;

@RestController
@RequestMapping("/crypto/api/v1/coin")
public class CryptoController {

    private final CryptoService cryptoService;

    //Information found: In modern versions of Spring, specifically Spring 4.3 and later, 
    //the @Autowired annotation is no longer required when there is only one constructor in the class. 
    //Spring automatically detects the constructor and injects the dependencies without the need for explicit @Autowired annotation.
    
    @Autowired 
    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/market")
    public List<CoinDTO> getMarketData() {
        return cryptoService.getMarketData();
    }
}


    //Information found: In modern versions of Spring, specifically Spring 4.3 and later, 
    //the @Autowired annotation is no longer required when there is only one constructor in the class. 
    //Spring automatically detects the constructor and injects the dependencies without the need for explicit @Autowired annotation.

/* 
import com.codewave.project.projectcryptocoingecko2.model.dto.CoinDTO;
import com.codewave.project.projectcryptocoingecko2.model.ExchangeRate;
import com.codewave.project.projectcryptocoingecko2.service.CryptoService;
import com.codewave.project.projectcryptocoingecko2.infra.response.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/crypto/api/v1/coin")
public class CryptoController {

    private final CryptoService cryptoService;
    private final RestTemplate restTemplate;

    @Autowired
    public CryptoController(CryptoService cryptoService, RestTemplate restTemplate) {
        this.cryptoService = cryptoService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/market")
    public List<CoinDTO> getMarketData() {
        return cryptoService.getMarketData();
    }

    @GetMapping("/coingecko/simple-price")
    public List<ExchangeRate> getExchangeRates(@RequestParam("coins") String coins, @RequestParam("currency") String currency) {
        String coingeckoUrl = "https://api.coingecko.com/api/v3/simple/price";

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(coingeckoUrl)
                .queryParam("ids", coins)
                .queryParam("vs_currencies", currency);

        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<Map<String, Map<String, BigDecimal>>> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Map<String, Map<String, BigDecimal>>>() {});

        if (response.getStatusCode().is2xxSuccessful()) {
            Map<String, Map<String, BigDecimal>> result = response.getBody();
            List<ExchangeRate> exchangeRates = new ArrayList<>();

            for (String coin : coins.split(",")) {
                Map<String, BigDecimal> coinData = result.get(coin);
                if (coinData != null) {
                    BigDecimal rate = coinData.get(currency.toUpperCase());
                    if (rate != null) {
                        ExchangeRate exchangeRate = new ExchangeRate();
                        exchangeRate.setFromCurr(coin);
                        exchangeRate.setToCurr(currency);
                        exchangeRate.setRate(rate);
                        exchangeRates.add(exchangeRate);
                    }
                }
            }

            return exchangeRates;
        } else {
            throw new ApiException("Failed to retrieve exchange rates from Coingecko API");
        }
    }
}
*/



/* 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.codewave.project.projectcryptocoingecko2.model.ExchangeRate;
import com.codewave.project.projectcryptocoingecko2.model.dto.CoinDTO;
import com.codewave.project.projectcryptocoingecko2.service.CryptoService;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/crypto/api/v1/coin")
public class CryptoController {

    private final CryptoService cryptoService;
    private final RestTemplate restTemplate;

    @Autowired
    public CryptoController(CryptoService cryptoService, RestTemplate restTemplate) {
        this.cryptoService = cryptoService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/market")
    public List<CoinDTO> getMarketData() {
        return cryptoService.getMarketData();
    }

    @GetMapping("/coingecko/simple-price")
    public List<ExchangeRate> getExchangeRates() {
        // Make a call to the Coingecko API to retrieve the exchange rates
        // You can use the RestTemplate to make the HTTP request

        // Replace the following code with your implementation
        ExchangeRate exchangeRate1 = new ExchangeRate();
        exchangeRate1.setFromCurr("BTC");
        exchangeRate1.setToCurr("USD");
        exchangeRate1.setRate(new BigDecimal("50000"));

        ExchangeRate exchangeRate2 = new ExchangeRate();
        exchangeRate2.setFromCurr("ETH");
        exchangeRate2.setToCurr("USD");
        exchangeRate2.setRate(new BigDecimal("3000"));

        // Return a list of ExchangeRate objects
        return List.of(exchangeRate1, exchangeRate2);
    }
}
*/

/* 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.project.projectcryptocoingecko2.model.dto.CoinDTO;
import com.codewave.project.projectcryptocoingecko2.service.CryptoService;

import java.util.List;


@RestController
@RequestMapping("/crypto/api/v1/coin")
public class CryptoController {

    private final CryptoService cryptoService;

    
    @Autowired 
    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/market")
    public List<CoinDTO> getMarketData() {
        return cryptoService.getMarketData();
    }
}
*/

    //Information found: In modern versions of Spring, specifically Spring 4.3 and later, 
    //the @Autowired annotation is no longer required when there is only one constructor in the class. 
    //Spring automatically detects the constructor and injects the dependencies without the need for explicit @Autowired annotation.
    

/* Note:
Information found: In modern versions of Spring, specifically Spring 4.3 and later, the @Autowired annotation is no longer required when there is only one constructor in the class. Spring automatically detects the constructor and injects the dependencies without the need for explicit @Autowired annotation.

As a result:
The @Autowired annotation is used to automatically inject dependencies into a class. In the case of the CryptoController class, the CryptoService dependency is being injected through constructor injection.
In modern versions of Spring, specifically Spring 4.3 and later, the @Autowired annotation is no longer required when there is only one constructor in the class. Spring automatically detects the constructor and injects the dependencies without the need for explicit @Autowired annotation.
Therefore, in your CryptoController class, since there is only one constructor that accepts the CryptoService dependency, the @Autowired annotation is unnecessary. Spring will automatically detect and inject the dependency based on the constructor's parameter.
You can safely remove the @Autowired annotation from the constructor in your CryptoController class, and the dependency injection will still work correctly.
 */






 /* 
 import com.codewave.project.projectcryptocoingecko2.model.dto.ChannelDto;
import com.codewave.project.projectcryptocoingecko2.model.dto.CoinDTO;
import com.codewave.project.projectcryptocoingecko2.model.ExchangeRate;
import com.codewave.project.projectcryptocoingecko2.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/crypto/api/v1")
public class CryptoController {

    private final CryptoService cryptoService;

    @Autowired
    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/coin/market")
    public List<CoinDTO> getMarketData() {
        return cryptoService.getMarketData();
    }

    @GetMapping("/coingecko/simple-price")
    public ResponseEntity<ChannelDto> getExchangeRates(
            @RequestParam("coins") String coins,
            @RequestParam("currency") String currency
    ) {
        String apiUrl = "https://api.coingecko.com/api/v3/simple/price";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("ids", coins)
                .queryParam("vs_currencies", currency);

        ChannelDto channelDto = new ChannelDto();
        channelDto.setExchangeRates(new ArrayList<>());

        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(builder.toUriString(), Object.class); // Please fix the "restTemple", it cannot be resolved
        Object responseBody = responseEntity.getBody();

        // Parse the response and map it to ChannelDto
        // Assuming the response is in the following format:
        // { "bitcoin": { "usd": 40000 }, "ethereum": { "usd": 3000 }, ... }
        // Modify the parsing logic based on the actual response structure
        if (responseBody instanceof java.util.Map) {
            java.util.Map<String, java.util.Map<String, BigDecimal>> exchangeRatesMap =
                    (java.util.Map<String, java.util.Map<String, BigDecimal>>) responseBody;
            for (String coin : coins.split(",")) {
                java.util.Map<String, BigDecimal> coinExchangeRateMap = exchangeRatesMap.get(coin);
                if (coinExchangeRateMap != null) {
                    for (String curr : currency.split(",")) {
                        BigDecimal rate = coinExchangeRateMap.get(curr);
                        if (rate != null) {
                            ExchangeRate exchangeRate = new ExchangeRate();
                            exchangeRate.setFromCurr(coin);
                            exchangeRate.setToCurr(curr);
                            exchangeRate.setRate(rate);
                            channelDto.getExchangeRates().add(exchangeRate);
                        }
                    }
                }
            }
        }

        return ResponseEntity.ok(channelDto);
    }
}
*/