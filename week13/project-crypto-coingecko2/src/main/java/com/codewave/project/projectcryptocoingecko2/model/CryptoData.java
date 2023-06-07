package com.codewave.project.projectcryptocoingecko2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CryptoData {
    private String id;
    private String symbol;
    private String name;
    @JsonProperty("image")
    private String imageUrl;

    public CryptoData() {}

    public CryptoData(String id, String symbol, String name, String imageUrl) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.imageUrl = imageUrl;
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
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
