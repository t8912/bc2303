package com.codewave.project.projectcryptocoingecko2.model.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class ChannelDto {
    private List<ExchangeRate> exchangeRates;

    public ChannelDto() {
        exchangeRates = new ArrayList<>();
    }

    @Data
    public static class ExchangeRate {
        private String fromCurr;
        private String toCurr;
        private BigDecimal rate;
    }

    
}


/* 
import java.util.ArrayList;
import java.util.List;

import com.codewave.project.projectcryptocoingecko2.model.ExchangeRate;

public class ChannelDto {
    private List<ExchangeRate> exchangeRates;

    public ChannelDto() {
        exchangeRates = new ArrayList<>();
    }

    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    public void setExchangeRates(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }
}
*/

/* 
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
public class ChannelDto {
    private List<ExchangeRate> exchangeRates;

    @Data
    public static class ExchangeRate {
        private String fromCurr;
        private String toCurr;
        private BigDecimal rate;
        public void setToCurrRates(Map<String, BigDecimal> currencyRateMap) {
        }
    }

    public void setExchangeRates(List<com.codewave.project.projectcryptocoingecko2.model.ExchangeRate> exchangeRates2) {
    }

  
}
*/

/* 
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.codewave.project.projectcryptocoingecko2.model.ExchangeRate;

@Data
public class ChannelDto {
    private List<ExchangeRate> exchangeRates;

    public ChannelDto() {
        exchangeRates = new ArrayList<>();
    }
}
*/

/* 
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

import com.codewave.project.projectcryptocoingecko2.model.ExchangeRate;

@Data
public class ChannelDto {
    private List<ExchangeRate> exchangeRates;


}
*/
/* 
import java.util.List;

import com.codewave.project.projectcryptocoingecko2.model.ExchangeRate;

public class ChannelDto {
    List<ExchangeRate> exchangeRates;

    public ChannelDto(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    public void setExchangeRates(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }
}
*/


