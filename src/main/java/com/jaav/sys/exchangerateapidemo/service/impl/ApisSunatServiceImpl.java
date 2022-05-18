package com.jaav.sys.exchangerateapidemo.service.impl;

import com.jaav.sys.exchangerateapidemo.client.ApisNetSunatClient;
import com.jaav.sys.exchangerateapidemo.model.ExchangeRateSunatResponse;
import com.jaav.sys.exchangerateapidemo.service.ApisSunatService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ApisSunatServiceImpl implements ApisSunatService {


    @Autowired
    ApisNetSunatClient apisNetSunatClient;

    @Override
    public Double getCurrentExchange() {
        return getExchangeRateSunatByPeriod()
                .map(e -> e.getCompra().doubleValue())
                .orElse(BigDecimal.ZERO.doubleValue());
    }

    private Optional<ExchangeRateSunatResponse> getExchangeRateSunatByPeriod() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault());

            String fecha = formatter.format(LocalDate.now());
            Response<ExchangeRateSunatResponse> response =
                    apisNetSunatClient.getExchangeRateSunatByDate(fecha).execute();
            if (response.isSuccessful()) {
                return Optional.of(response.body());
            }
        } catch(Exception ex) {
            log.error("ERROR on proccesExchangeToBuy:",ex);
        }
        return Optional.empty();
    }
}
