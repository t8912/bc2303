package com.codewave.project.projectcryptocoingecko2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Crypto {

    private String id;

    private String symbol;

    private String name;

    private String image;

    public Crypto() {}

    public Crypto(String id, String symbol, String name, String image) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.image = image;
    }

    public static Crypto fromCryptoData(CryptoData cryptoData) {
        return new Crypto(
                cryptoData.getId(),
                cryptoData.getSymbol(),
                cryptoData.getName(),
                cryptoData.getImageUrl()
        );
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
