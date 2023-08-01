package com.peirong.config;

import com.peirong.entity.User;
import com.peirong.service.client.UserClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.cloud.openfeign.FeignContext;
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
}
