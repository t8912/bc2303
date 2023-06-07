package com.codewave.project.projectcryptocoingecko2.model;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExchangeRate {
    private String fromCurr;
    private String toCurr;
    private BigDecimal rate;
}



/* 
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class ExchangeRate {
    private String fromCurr;
    private String toCurr;
    private BigDecimal rate;
    public void setToCurrRates(Map<String, BigDecimal> currencyRateMap) {
    }
}
*/

/* 
import java.math.BigDecimal;
import java.util.Map;

public class ExchangeRate {
    private String fromCurr;
    private String toCurr;
    private BigDecimal rate;

    public ExchangeRate(String fromCurr, String toCurr, BigDecimal rate) {
        this.fromCurr = fromCurr;
        this.toCurr = toCurr;
        this.rate = rate;
    }

    public String getFromCurr() {
        return fromCurr;
    }

    public void setFromCurr(String fromCurr) {
        this.fromCurr = fromCurr;
    }

    public String getToCurr() {
        return toCurr;
    }

    public void setToCurr(String toCurr) {
        this.toCurr = toCurr;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public void setToCurrRates(Map<String, BigDecimal> currencyRateMap) {
    }
}
*/