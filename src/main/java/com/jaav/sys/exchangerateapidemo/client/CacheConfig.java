package com.jaav.sys.exchangerateapidemo.client;

import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

//@Configuration
public class CacheConfig extends RedisAutoConfiguration {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    /*@Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory
                = new JedisConnectionFactory();
        jedisConFactory.setHostName("mycache01.redis.cache.windows.net");
        jedisConFactory.setPort(6379);
        jedisConFactory.setPassword("+MGD4oSUkPeV9Dwwaq+4qLWyuuF81JlHTsJRO5wm06A=");
        return jedisConFactory;
    }*/

    @Bean
    public RedisTemplate<String, Double> redisTemplate() {
        RedisTemplate<String, Double> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}
