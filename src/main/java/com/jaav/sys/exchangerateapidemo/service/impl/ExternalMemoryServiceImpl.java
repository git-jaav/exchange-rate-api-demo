package com.jaav.sys.exchangerateapidemo.service.impl;

import com.jaav.sys.exchangerateapidemo.service.ExternalMemoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class ExternalMemoryServiceImpl implements ExternalMemoryService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Optional<Double> getAmountRedis(String key) {
        try {
            ValueOperations<String, Double> ops = this.redisTemplate.opsForValue();
            if (this.redisTemplate.hasKey(key)) {
                log.info("[getAmountRedis]: GET DATA FROM REDIS:");
                return Optional.ofNullable(ops.get(key));
            }
            return Optional.empty();
        } catch(Exception e) {
            log.error("EXCEPTION::GET FROM REDIS" , e);
            return Optional.empty();
        }

    }

    @Override
    public Optional<Double> setAmountRedis(String key, Double value) {
        try {
            ValueOperations<String, Double> ops = this.redisTemplate.opsForValue();
            if (!this.redisTemplate.hasKey(key)) {
                ops.set(key, value);
                // prueba de invocacion del guardado con otra entidad
                //saveData2(data);
            }
            log.info("[setAmountRedis]: PUT DATA ON REDIS:");
        } catch (Exception e) {
            log.error("[EXC]:: SETING ON REDIS", e);
        }
        return Optional.of(value);
    }

}
