package com.codewave.project.projectcryptopolygon.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExchangeRate {
    private String fromCurr;
    private String toCurr;
    private BigDecimal rate;

    //private String ticker;

    public ExchangeRate() {
    }

//     public ExchangeRate(String ticker, BigDecimal rate) {
//       this.ticker = ticker;
//       this.rate = rate;
//   }

    public ExchangeRate(String fromCurr, String toCurr, BigDecimal rate) {
        this.fromCurr = fromCurr;
        this.toCurr = toCurr;
        this.rate = rate;
    }

}
