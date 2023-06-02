package com.codewave.project.projectcryptocoingecko2.service;

import org.springframework.data.domain.Page;

import com.codewave.project.projectcryptocoingecko2.model.dto.CoinDTO;


public interface CoinService {
    Page<CoinDTO> getTopMarketCapCoins();
}

