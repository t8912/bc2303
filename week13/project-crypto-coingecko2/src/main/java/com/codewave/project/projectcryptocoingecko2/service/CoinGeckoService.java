package com.codewave.project.projectcryptocoingecko2.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.codewave.project.projectcryptocoingecko2.infra.util.CryptoApiUtil;
import com.codewave.project.projectcryptocoingecko2.model.dto.ChannelDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CoinGeckoService {

    private static final String COINGECKO_API_URL = "https://api.coingecko.com/api/v3/simple/price";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public CoinGeckoService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(COINGECKO_API_URL)
                .queryParam("ids", String.join(",", coins))
                .queryParam("vs_currencies", String.join(",", currencies));

        HttpEntity<?> entity = new HttpEntity<>(CryptoApiUtil.createHeaders());
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                JsonNode responseNode = objectMapper.readTree(response.getBody());

                ChannelDto channelDto = new ChannelDto();
                List<ChannelDto.ExchangeRate> exchangeRates = new ArrayList<>();

                for (String coin : coins) {
                    for (String currency : currencies) {
                        BigDecimal rate = responseNode.path(coin.toLowerCase()).path(currency.toLowerCase()).decimalValue();

                        ChannelDto.ExchangeRate exchangeRate = new ChannelDto.ExchangeRate();
                        exchangeRate.setFromCurr(coin.toLowerCase());
                        exchangeRate.setToCurr(currency.toLowerCase());
                        exchangeRate.setRate(rate);

                        exchangeRates.add(exchangeRate);
                    }
                }

                channelDto.setExchangeRates(exchangeRates);
                return channelDto;
            } catch (IOException e) {
                // Handle the exception
            }
        }

        // Handle the API error or failure case
        return null;
    }
}




/* 
import com.codewave.project.projectcryptocoingecko2.infra.util.CryptoApiUtil;
import com.codewave.project.projectcryptocoingecko2.model.ExchangeRate;
import com.codewave.project.projectcryptocoingecko2.model.dto.ChannelDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoinGeckoService {

    private static final String COINGECKO_API_URL = "https://api.coingecko.com/api/v3/simple/price";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public CoinGeckoService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(COINGECKO_API_URL)
                .queryParam("ids", String.join(",", coins))
                .queryParam("vs_currencies", String.join(",", currencies));

        HttpEntity<?> entity = new HttpEntity<>(CryptoApiUtil.createHeaders());
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                JsonNode responseNode = objectMapper.readTree(response.getBody());

                ChannelDto channelDto = new ChannelDto();
                List<ExchangeRate> exchangeRates = new ArrayList<>();

                channelDto.setExchangeRates(exchangeRates); // Initialize exchangeRates with an empty list

                for (String coin : coins) {
                    ExchangeRate exchangeRate = new ExchangeRate();
                    exchangeRate.setFromCurr(coin);

                    for (String currency : currencies) {
                        BigDecimal rate = responseNode.path(coin).path(currency).decimalValue();
                        exchangeRate.setToCurr(currency);
                        exchangeRate.setRate(rate);
                    }

                    exchangeRates.add(exchangeRate);
                }

                return channelDto;
            } catch (IOException e) {
                // Handle the exception
            }
        }

        // Handle the API error or failure case
        return null;
    }
}
*/

/* 
import com.codewave.project.projectcryptocoingecko2.infra.util.CryptoApiUtil;
import com.codewave.project.projectcryptocoingecko2.model.ExchangeRate;
import com.codewave.project.projectcryptocoingecko2.model.dto.ChannelDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoinGeckoService {

    private static final String COINGECKO_API_URL = "https://api.coingecko.com/api/v3/simple/price";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public CoinGeckoService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(COINGECKO_API_URL)
                .queryParam("ids", String.join(",", coins))
                .queryParam("vs_currencies", String.join(",", currencies));

        HttpEntity<?> entity = new HttpEntity<>(CryptoApiUtil.createHeaders());
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                JsonNode responseNode = objectMapper.readTree(response.getBody());

                ChannelDto channelDto = new ChannelDto();
                List<ExchangeRate> exchangeRates = new ArrayList<>();

                for (String coin : coins) {
                    ExchangeRate exchangeRate = new ExchangeRate();
                    exchangeRate.setFromCurr(coin);

                    for (String currency : currencies) {
                        BigDecimal rate = responseNode.path(coin).path(currency).decimalValue();
                        exchangeRate.setToCurr(currency);
                        exchangeRate.setRate(rate);
                    }

                    exchangeRates.add(exchangeRate);
                }

                channelDto.setExchangeRates(exchangeRates);
                return channelDto;
            } catch (IOException e) {
                // Handle the exception
            }
        }

        // Handle the API error or failure case
        return null;
    }
}
*/

/* 
import com.codewave.project.projectcryptocoingecko2.infra.util.CryptoApiUtil;
import com.codewave.project.projectcryptocoingecko2.model.ExchangeRate;
import com.codewave.project.projectcryptocoingecko2.model.dto.ChannelDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CoinGeckoService {

    private static final String COINGECKO_API_URL = "https://api.coingecko.com/api/v3/simple/price";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public CoinGeckoService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(COINGECKO_API_URL)
                .queryParam("ids", String.join(",", coins))
                .queryParam("vs_currencies", String.join(",", currencies));

        HttpEntity<?> entity = new HttpEntity<>(CryptoApiUtil.createHeaders());
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                JsonNode responseNode = objectMapper.readTree(response.getBody());

                ChannelDto channelDto = new ChannelDto();
                List<ExchangeRate> exchangeRates = channelDto.getExchangeRates(); //Type mismatch: cannot convert from List <ChannelDto.ExchangeRate> to List<ExchangeRate>

                for (String coin : coins) {
                    ExchangeRate exchangeRate = new ExchangeRate();
                    exchangeRate.setFromCurr(coin);

                    for (String currency : currencies) {
                        BigDecimal rate = responseNode.path(coin).path(currency).decimalValue();
                        exchangeRate.setToCurr(currency);
                        exchangeRate.setRate(rate);
                    }

                    exchangeRates.add(exchangeRate);
                }

                return channelDto;
            } catch (IOException e) {
                // Handle the exception
            }
        }

        // Handle the API error or failure case
        return null;
    }
}

*/

/* 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.codewave.project.projectcryptocoingecko2.infra.util.CryptoApiUtil;
import com.codewave.project.projectcryptocoingecko2.model.dto.ChannelDto;
import com.codewave.project.projectcryptocoingecko2.model.dto.ChannelDto.ExchangeRate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CoinGeckoService {

    private static final String COINGECKO_API_URL = "https://api.coingecko.com/api/v3/simple/price";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public CoinGeckoService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(COINGECKO_API_URL)
                .queryParam("ids", String.join(",", coins))
                .queryParam("vs_currencies", String.join(",", currencies));

        HttpEntity<?> entity = new HttpEntity<>(CryptoApiUtil.createHeaders());
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                JsonNode responseNode = objectMapper.readTree(response.getBody());

                ChannelDto channelDto = new ChannelDto();
                List<ExchangeRate> exchangeRates = channelDto.getExchangeRates();

                for (String coin : coins) {
                    ExchangeRate exchangeRate = new ExchangeRate();
                    exchangeRate.setFromCurr(coin);

                    for (String currency : currencies) {
                        BigDecimal rate = responseNode.path(coin).path(currency).decimalValue();
                        exchangeRate.setToCurr(currency);
                        exchangeRate.setRate(rate);
                    }

                    exchangeRates.add(exchangeRate);
                }

                return channelDto;
            } catch (IOException e) {
                // Handle the exception
            }
        }

        // Handle the API error or failure case
        return null;
    }
}
*/
/* 
@Service
public class CoinGeckoService {
    private static final String COINGECKO_API_BASE_URL = "https://api.coingecko.com/api/v3";
    private static final String COINGECKO_SIMPLE_PRICE_ENDPOINT = "/simple/price";

    private final RestTemplate restTemplate;

    @Autowired
    public CoinGeckoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Map<String, Double>> getCryptoExchangeRates(String coins, String currency) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(COINGECKO_API_BASE_URL)
                .path(COINGECKO_SIMPLE_PRICE_ENDPOINT)
                .queryParam("ids", coins)
                .queryParam("vs_currencies", currency);

        ResponseEntity<Map> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, Map.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        return new HashMap<>();
    }
}
*/

/* 
import com.codewave.project.projectcryptocoingecko2.infra.util.CryptoApiUtil;
import com.codewave.project.projectcryptocoingecko2.model.ExchangeRate;
import com.codewave.project.projectcryptocoingecko2.model.dto.ChannelDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoinGeckoService {

    private static final String COINGECKO_API_URL = "https://api.coingecko.com/api/v3/simple/price";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public CoinGeckoService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(COINGECKO_API_URL)
                .queryParam("ids", String.join(",", coins))
                .queryParam("vs_currencies", String.join(",", currencies));

        HttpEntity<?> entity = new HttpEntity<>(CryptoApiUtil.createHeaders());
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                JsonNode responseNode = objectMapper.readTree(response.getBody());

                ChannelDto channelDto = new ChannelDto();
                List<ChannelDto.ExchangeRate> exchangeRates = new ArrayList<>();

                for (String coin : coins) {
                    for (String currency : currencies) {
                        BigDecimal rate = responseNode.path(coin).path(currency).decimalValue();

                        ChannelDto.ExchangeRate exchangeRate = new ChannelDto.ExchangeRate();
                        exchangeRate.setFromCurr(coin);
                        exchangeRate.setToCurr(currency);
                        exchangeRate.setRate(rate);

                        exchangeRates.add(exchangeRate);
                    }
                }

                channelDto.setExchangeRates(exchangeRates);
                return channelDto;
            } catch (IOException e) {
                // Handle the exception
            }
        }

        // Handle the API error or failure case
        return null;
    }
}
*/


/* 
import com.codewave.project.projectcryptocoingecko2.infra.util.CryptoApiUtil;
import com.codewave.project.projectcryptocoingecko2.model.ExchangeRate;
import com.codewave.project.projectcryptocoingecko2.model.dto.ChannelDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoinGeckoService {

    private static final String COINGECKO_API_URL = "https://api.coingecko.com/api/v3/simple/price";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public CoinGeckoService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(COINGECKO_API_URL)
                .queryParam("ids", String.join(",", coins))
                .queryParam("vs_currencies", String.join(",", currencies));

        HttpEntity<?> entity = new HttpEntity<>(CryptoApiUtil.createHeaders());
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                JsonNode responseNode = objectMapper.readTree(response.getBody());

                ChannelDto channelDto = new ChannelDto();
                List<ChannelDto.ExchangeRate> exchangeRates = new ArrayList<>();

                for (String coin : coins) {
                    for (String currency : currencies) {
                        BigDecimal rate = responseNode.path(coin).path(currency).decimalValue();

                        ChannelDto.ExchangeRate exchangeRate = new ChannelDto.ExchangeRate();
                        exchangeRate.setFromCurr(coin);
                        exchangeRate.setToCurr(currency);
                        exchangeRate.setRate(rate);

                        exchangeRates.add(exchangeRate);
                    }
                }

                channelDto.setExchangeRates(exchangeRates);
                return channelDto;
            } catch (IOException e) {
                // Handle the exception
            }
        }

        // Handle the API error or failure case
        return null;
    }
}

*/









/* 
import com.codewave.project.projectcryptocoingecko2.infra.util.CryptoApiUtil;
import com.codewave.project.projectcryptocoingecko2.model.ExchangeRate;
import com.codewave.project.projectcryptocoingecko2.model.dto.ChannelDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoinGeckoService {

    private static final String COINGECKO_API_URL = "https://api.coingecko.com/api/v3/simple/price";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public CoinGeckoService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(COINGECKO_API_URL)
                .queryParam("ids", String.join(",", coins))
                .queryParam("vs_currencies", String.join(",", currencies));

        HttpEntity<?> entity = new HttpEntity<>(CryptoApiUtil.createHeaders());
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                JsonNode responseNode = objectMapper.readTree(response.getBody());

                ChannelDto channelDto = new ChannelDto();
                List<ChannelDto.ExchangeRate> exchangeRates = new ArrayList<>();

                for (String coin : coins) {
                    for (String currency : currencies) {
                        BigDecimal rate = responseNode.path(coin).path(currency).decimalValue();

                        ChannelDto.ExchangeRate exchangeRate = new ChannelDto.ExchangeRate();
                        exchangeRate.setFromCurr(coin);
                        exchangeRate.setToCurr(currency);
                        exchangeRate.setRate(rate);

                        exchangeRates.add(exchangeRate);
                    }
                }

                channelDto.setExchangeRates(exchangeRates);
                return channelDto;
            } catch (IOException e) {
                // Handle the exception
            }
        }

        // Handle the API error or failure case
        return null;
    }
}
*/

/* 
import com.codewave.project.projectcryptocoingecko2.infra.util.CryptoApiUtil;
import com.codewave.project.projectcryptocoingecko2.model.ExchangeRate;
import com.codewave.project.projectcryptocoingecko2.model.dto.ChannelDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CoinGeckoService {

    private static final String COINGECKO_API_URL = "https://api.coingecko.com/api/v3/simple/price";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public CoinGeckoService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public ChannelDto getCryptoExchangeRate(List<String> coins, List<String> currencies) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(COINGECKO_API_URL)
                .queryParam("ids", String.join(",", coins))
                .queryParam("vs_currencies", String.join(",", currencies));

        HttpEntity<?> entity = new HttpEntity<>(CryptoApiUtil.createHeaders());
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                JsonNode responseNode = objectMapper.readTree(response.getBody());

                ChannelDto channelDto = new ChannelDto();
                List<ExchangeRate> exchangeRates = channelDto.getExchangeRates(); // please fix channelDto.getExchangeRates()

                for (String coin : coins) {
                    ExchangeRate exchangeRate = new ExchangeRate();
                    exchangeRate.setFromCurr(coin);

                    for (String currency : currencies) {
                        BigDecimal rate = responseNode.path(coin).path(currency).decimalValue();
                        exchangeRate.setToCurr(currency);
                        exchangeRate.setRate(rate);
                    }

                    exchangeRates.add(exchangeRate);
                }

                return channelDto;
            } catch (IOException e) {
                // Handle the exception
            }
        }

        // Handle the API error or failure case
        return null;
    }
}

*/