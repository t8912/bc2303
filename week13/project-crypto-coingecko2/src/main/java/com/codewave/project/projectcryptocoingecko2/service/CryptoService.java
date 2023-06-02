package com.codewave.project.projectcryptocoingecko2.service;


import java.util.List;

import com.codewave.project.projectcryptocoingecko2.model.dto.CoinDTO;

public interface CryptoService {
    List<CoinDTO> getCoinMarketData(String currency);

    List<CoinDTO> getMarketData();
}



