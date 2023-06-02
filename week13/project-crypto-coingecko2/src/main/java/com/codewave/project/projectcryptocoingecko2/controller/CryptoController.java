package com.codewave.project.projectcryptocoingecko2.controller;


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
