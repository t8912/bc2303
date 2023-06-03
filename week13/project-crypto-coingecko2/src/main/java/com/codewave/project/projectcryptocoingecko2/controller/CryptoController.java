package com.codewave.project.projectcryptocoingecko2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.project.projectcryptocoingecko2.model.dto.CoinDTO;
import com.codewave.project.projectcryptocoingecko2.service.CryptoService;

import java.util.List;

@RestController
@RequestMapping("/crypto/api/v1/coin")
public class CryptoController {

    private final CryptoService cryptoService;

    //Information found: In modern versions of Spring, specifically Spring 4.3 and later, 
    //the @Autowired annotation is no longer required when there is only one constructor in the class. 
    //Spring automatically detects the constructor and injects the dependencies without the need for explicit @Autowired annotation.
    
    @Autowired 
    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/market")
    public List<CoinDTO> getMarketData() {
        return cryptoService.getMarketData();
    }
}


/* Note:
Information found: In modern versions of Spring, specifically Spring 4.3 and later, the @Autowired annotation is no longer required when there is only one constructor in the class. Spring automatically detects the constructor and injects the dependencies without the need for explicit @Autowired annotation.

As a result:
The @Autowired annotation is used to automatically inject dependencies into a class. In the case of the CryptoController class, the CryptoService dependency is being injected through constructor injection.
In modern versions of Spring, specifically Spring 4.3 and later, the @Autowired annotation is no longer required when there is only one constructor in the class. Spring automatically detects the constructor and injects the dependencies without the need for explicit @Autowired annotation.
Therefore, in your CryptoController class, since there is only one constructor that accepts the CryptoService dependency, the @Autowired annotation is unnecessary. Spring will automatically detect and inject the dependency based on the constructor's parameter.
You can safely remove the @Autowired annotation from the constructor in your CryptoController class, and the dependency injection will still work correctly.
 */