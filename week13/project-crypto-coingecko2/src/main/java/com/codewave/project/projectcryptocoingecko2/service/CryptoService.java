package com.codewave.project.projectcryptocoingecko2.service;


import java.util.List;
import java.util.Map;

import com.codewave.project.projectcryptocoingecko2.model.Crypto;
//import com.codewave.project.projectcryptocoingecko2.model.ExchangeRate;
import com.codewave.project.projectcryptocoingecko2.model.dto.CoinDTO;

public interface CryptoService {
    List<CoinDTO> getCoinMarketData(String currency);

    List<CoinDTO> getMarketData();
    
    // List<ExchangeRate> getExchangeRates();

    // List<Crypto> getCryptos();
    
    Map<String, Map<String, Double>> getCoinGeckoPrices(String coins, String currencies);
    //CoinDTO getExchangeRates();


  
    
}



