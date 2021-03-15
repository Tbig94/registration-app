package com.resgistration_app.web.controller;

import com.resgistration_app.service.CryptoCurrencyService;
import com.resgistration_app.service.CryptoCurrencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CryptoController {

    private CryptoCurrencyService cryptoCurrencyService;

    @Autowired
    public CryptoController(CryptoCurrencyServiceImpl cryptoCurrencyService) {
        this.cryptoCurrencyService = cryptoCurrencyService;
    }


    @GetMapping("/crypto-currency")
    public String showCurrency(Model model) {
        model.addAttribute("cryptoCurrencyData", cryptoCurrencyService.getCurrencyData());
        return "crypto-currency";
    }
}
