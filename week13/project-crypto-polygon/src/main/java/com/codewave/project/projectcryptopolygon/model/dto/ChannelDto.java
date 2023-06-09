package com.codewave.project.projectcryptopolygon.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ChannelDto {
    private List<ExchangeRate> exchangeRates;
}
