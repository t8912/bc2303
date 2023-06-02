package com.codewave.project.projectcryptocoingecko.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.project.projectcryptocoingecko.model.dto.CoinMarketDataDto;
import com.codewave.project.projectcryptocoingecko.service.CoinGeckoApiClientService;

import java.io.IOException;

@RestController
@RequestMapping("/crypto/api/v1/coin")
public class CryptoController {
    private final CoinGeckoApiClientService coinGeckoApiClient;

    public CryptoController(CoinGeckoApiClientService coinGeckoApiClient) {
        this.coinGeckoApiClient = coinGeckoApiClient;
    }

    @GetMapping("/market")
    public CoinMarketDataDto[] getCoinMarketData() throws IOException {
        return coinGeckoApiClient.getCoinMarketData();
    }
}