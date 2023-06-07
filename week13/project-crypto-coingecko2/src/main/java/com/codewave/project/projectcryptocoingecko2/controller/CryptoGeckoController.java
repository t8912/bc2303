package com.codewave.project.projectcryptocoingecko2.controller;

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
public class CryptoGeckoController {

    private final CoinGeckoService coinGeckoService;

    @Autowired
    public CryptoGeckoController(CoinGeckoService coinGeckoService) {
        this.coinGeckoService = coinGeckoService;
    }

    @GetMapping("/simple-price")
    public ChannelDto getCryptoExchangeRate() {
        List<String> coins = Arrays.asList("bitcoin", "ethereum", "usdt", "xrp", "doge");
        List<String> currencies = Arrays.asList("usd", "hkd");

        return coinGeckoService.getCryptoExchangeRate(coins, currencies);
    }
}





/* 
import com.codewave.project.projectcryptocoingecko2.service.CoinGeckoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/crypto/api/v1/coingecko")
public class CryptoGeckoController {
    private final CoinGeckoService coinGeckoService;

    @Autowired
    public CryptoGeckoController(CoinGeckoService coinGeckoService) {
        this.coinGeckoService = coinGeckoService;
    }

    @GetMapping("/simple-price")
    public Map<String, Map<String, Double>> getSimplePrice(@RequestParam String coins, @RequestParam String currencies) {
        return coinGeckoService.getCryptoExchangeRates(coins, currencies);
    }
}
*/

/* 

@RestController
@RequestMapping("/crypto/api/v1/coingecko")
public class CryptoGeckoController {
    private final CoinGeckoService coinGeckoService;

    @Autowired
    public CryptoGeckoController(CoinGeckoService coinGeckoService) {
        this.coinGeckoService = coinGeckoService;
    }

    @GetMapping("/simple-price")
    public Map<String, Map<String, Double>> getSimplePrice(@RequestParam String coins, @RequestParam String currency) {
        return coinGeckoService.getCryptoExchangeRates(coins, currency);
    }
}
*/

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
public class CryptoGeckoController {

    private final CoinGeckoService coinGeckoService;

    @Autowired
    public CryptoGeckoController(CoinGeckoService coinGeckoService) {
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


/* 
import com.codewave.project.projectcryptocoingecko2.model.dto.ChannelDto;
import com.codewave.project.projectcryptocoingecko2.service.CoinGeckoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/crypto/api/v1/coingecko")
public class CryptoGeckoController {

    private final CoinGeckoService coinGeckoService;

    @Autowired
    public CryptoGeckoController(CoinGeckoService coinGeckoService) {
        this.coinGeckoService = coinGeckoService;
    }

    @GetMapping("/simple-price")
    public ChannelDto getCryptoExchangeRate(
            @RequestParam(value = "coins", required = true) List<String> coins,
            @RequestParam(value = "currencies", required = true) List<String> currencies
    ) {
        return coinGeckoService.getCryptoExchangeRate(coins, currencies);
    }
}

*/
/* 
import com.codewave.project.projectcryptocoingecko2.model.dto.ChannelDto;
import com.codewave.project.projectcryptocoingecko2.service.CoinGeckoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/crypto/api/v1/coingecko")
public class CryptoGeckoController {

    private final CoinGeckoService coinGeckoService;

    @Autowired
    public CryptoGeckoController(CoinGeckoService coinGeckoService) {
        this.coinGeckoService = coinGeckoService;
    }

    @GetMapping("/simple-price")
    public ChannelDto getCryptoExchangeRate(
            @RequestParam(value = "coins", required = true) List<String> coins,
            @RequestParam(value = "currencies", required = true) List<String> currencies
    ) {
        return coinGeckoService.getCryptoExchangeRate(coins, currencies);
    }
}
*/

/* 
import com.codewave.project.projectcryptocoingecko2.model.dto.ChannelDto;
import com.codewave.project.projectcryptocoingecko2.service.CoinGeckoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/crypto/api/v1/coingecko")
public class CryptoGeckoController {

    private final CoinGeckoService coinGeckoService;

    @Autowired
    public CryptoGeckoController(CoinGeckoService coinGeckoService) {
        this.coinGeckoService = coinGeckoService;
    }

    @GetMapping("/simple-price")
    public ChannelDto getCryptoExchangeRate(@RequestParam("coins") List<String> coins,
                                            @RequestParam("currencies") List<String> currencies) {
        return coinGeckoService.getCryptoExchangeRate(coins, currencies);
    }
}
*/

/* 
import com.codewave.project.projectcryptocoingecko2.model.dto.ChannelDto;
import com.codewave.project.projectcryptocoingecko2.service.CoinGeckoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/crypto/api/v1/coingecko")
public class CryptoGeckoController {

    private final CoinGeckoService coinGeckoService;

    @Autowired
    public CryptoGeckoController (CoinGeckoService coinGeckoService) {
        this.coinGeckoService = coinGeckoService;
    }

    @GetMapping("/simple-price")
    public ChannelDto getCryptoExchangeRate(@RequestParam("coins") List<String> coins,
                                            @RequestParam("currencies") List<String> currencies) {
        return coinGeckoService.getCryptoExchangeRate(coins, currencies);
    }
}
*/

/* 
import com.codewave.project.projectcryptocoingecko2.model.dto.ChannelDto;
import com.codewave.project.projectcryptocoingecko2.service.CoinGeckoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/crypto/api/v1/coingecko")
public class CryptoGeckoController {

    private final CoinGeckoService coinGeckoService;

    @Autowired
    public CryptoGeckoController(CoinGeckoService coinGeckoService) {
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