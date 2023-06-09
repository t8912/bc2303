package com.codewave.project.projectcryptopolygon.service;


import com.codewave.project.projectcryptopolygon.model.dto.ChannelDto;

import java.util.List;

public interface PolygonCryptoService {
    ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies);

    ChannelDto getCryptoExchangeRates(List<String> coins, List<String> currencies);
}

