package com.jaav.sys.exchangerateapidemo.main;

import com.jaav.sys.exchangerateapidemo.service.ExchangeRateService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@SpringBootApplication(scanBasePackages={
        "com.jaav.sys"})
//@EnableConfigurationProperties
@Log4j2
@Component
//@SpringBootApplication
@ConditionalOnNotWebApplication
public class MainDesk {

    @Autowired
    ExchangeRateService exchangeRateService;

    public static void main(String[] args) {
        SpringApplication.run(MainDesk.class, args);
        log.info("[INFO-DESK]::INIT::");
    }


    @PostConstruct
    public void displayUI() {
        log.info("[INFO-DESK]::INIT-DISPLAY::");

        BigDecimal value = BigDecimal.valueOf(2000.00);
        BigDecimal valueConvert = exchangeRateService.getCurrentExhangeUSD("PEN", value);

        log.info("[INFO-DESK]:: TIPO DE CAMBIO:: " + value + " ==> " + valueConvert);
    }

}
