package com.jaav.sys.exchangerateapidemo.service;

import java.math.BigDecimal;

public interface ExchangeRateService {

    public BigDecimal getCurrentExhangeUSD(String current, BigDecimal amount);
    public BigDecimal getCurrentExhangePEN(String current, BigDecimal amount);

}
