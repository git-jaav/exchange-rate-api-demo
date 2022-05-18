package com.jaav.sys.exchangerateapidemo.service.impl;


import com.jaav.sys.exchangerateapidemo.service.ApisSunatService;
import com.jaav.sys.exchangerateapidemo.service.ExchangeRateService;
import com.jaav.sys.exchangerateapidemo.service.ExternalMemoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
@Log4j2
public class ExchangeRateServiceImpl implements ExchangeRateService {


    @Autowired
    ApisSunatService apisSunatService;

    @Autowired
    ExternalMemoryService externalMemoryService;

    public BigDecimal getCurrentExhangeUSD(String current, BigDecimal amount) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                .withZone(ZoneId.systemDefault());

        String keyDate = formatter.format(LocalDate.now());
        Double exchange = externalMemoryService.getAmountRedis(keyDate)
                .orElseGet(() -> getCurrentExchange(amount, keyDate));
        log.info("[getCurrentExhangeUSD]: value exchange:: " +  exchange);
        return amount.divide(BigDecimal.valueOf(exchange), 2);
    }

    public BigDecimal getCurrentExhangePEN(String current, BigDecimal amount) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                .withZone(ZoneId.systemDefault());

        String keyDate = formatter.format(LocalDate.now());
        Double exchange = externalMemoryService.getAmountRedis(keyDate)
                .orElseGet(() -> getCurrentExchange(amount, keyDate));
        log.info("[getCurrentExhangeUSD]: value exchange:: " +  exchange);
        return amount.multiply(BigDecimal.valueOf(exchange));
    }


    private Double getCurrentExchange(BigDecimal amount, String date){
        log.info("[getCurrentExchange]:APIs SUNAT IN:");
        Double exchange = apisSunatService.getCurrentExchange();
        return externalMemoryService.setAmountRedis(date, exchange).orElse(0D);
    }

}
