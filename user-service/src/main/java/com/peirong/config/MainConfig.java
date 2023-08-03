package com.peirong.config;

import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class MainConfig {
    @Bean
    public ExecutorService executorService() {
        return Executors.newCachedThreadPool();
    }
    @Bean
    public FeignClientProperties feignClientProperties() {
        return new FeignClientProperties();
    }
}
