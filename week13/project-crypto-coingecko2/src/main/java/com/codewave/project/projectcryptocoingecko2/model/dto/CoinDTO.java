package com.codewave.project.projectcryptocoingecko2.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoinDTO {
    private String id;
    private String name;
    private String symbol;
    private String image;
    private double current_price;
    private double price_change_percentage_24h;
    private double total_volume;
    private double market_cap;
    private int market_cap_rank;
}

/* 
public class CoinDTO {
    private String name;
    private String symbol;
    private String image;
    private double currentPrice;
    private double priceChangePercentage24h;
    // Add more fields as needed

    // Generate getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getPriceChangePercentage24h() {
        return priceChangePercentage24h;
    }

    public void setPriceChangePercentage24h(double priceChangePercentage24h) {
        this.priceChangePercentage24h = priceChangePercentage24h;
    }
}
*/