package com.codewave.project.projectcryptopolygon.controller.impl;

import com.codewave.project.projectcryptopolygon.model.dto.ChannelDto;
import com.codewave.project.projectcryptopolygon.service.PolygonCryptoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crypto/v1/polygon")
public class PolygonCryptoControllerImpl {

    private final PolygonCryptoService cryptoService;

    @Autowired
    public PolygonCryptoControllerImpl(PolygonCryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/price")
    public ChannelDto getCryptoExchangeRate(@RequestParam("coins") List<String> coins,
                                            @RequestParam("currencies") List<String> currencies) {
        return cryptoService.getCryptoExchangeRate(coins, currencies);
    }
}


