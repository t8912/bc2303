package com.codewave.project.projectcryptocoingecko.model.dto;

import java.math.BigDecimal;

/* 
public class CoinMarketDataDto {
  private String id;
  private String name;
  private String symbol;
  private double current_price;
  private double price_change_percentage_24h;
  private double total_volume;
  private double market_cap;

  // getters and setters
}
*/

public class CoinMarketDataDto {
  private String id;
  private String name;
  private String symbol;
  private BigDecimal current_price;
  private BigDecimal  price_change_percentage_24h;
  private BigDecimal  total_volume;
  private BigDecimal market_cap;

  // Getters
  public String getId() {
      return id;
  }

  public String getName() {
      return name;
  }

  public String getSymbol() {
      return symbol;
  }

  public BigDecimal getCurrentPrice() {
      return current_price;
  }

  public BigDecimal getPriceChangePercentage24h() {
      return price_change_percentage_24h;
  }

  public BigDecimal getTotalVolume() {
      return total_volume;
  }

  public BigDecimal getMarketCap() {
      return market_cap;
  }

  // Setters
  public void setId(String id) {
      this.id = id;
  }

  public void setName(String name) {
      this.name = name;
  }

  public void setSymbol(String symbol) {
      this.symbol = symbol;
  }

  public void setCurrentPrice(BigDecimal currentPrice) {
      this.current_price = currentPrice;
  }

  public void setPriceChangePercentage24h(BigDecimal priceChangePercentage24h) {
      this.price_change_percentage_24h = priceChangePercentage24h;
  }

  public void setTotalVolume(BigDecimal totalVolume) {
      this.total_volume = totalVolume;
  }

  public void setMarketCap(BigDecimal marketCap) {
      this.market_cap = marketCap;
  }
}

