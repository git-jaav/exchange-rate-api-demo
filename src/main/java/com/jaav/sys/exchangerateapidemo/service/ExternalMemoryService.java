package com.jaav.sys.exchangerateapidemo.service;

import java.util.Optional;

public interface ExternalMemoryService {


    Optional<Double> getAmountRedis(String key);

    Optional<Double> setAmountRedis(String key, Double value);

}
