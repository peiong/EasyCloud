package com.peirong.config;

import org.springframework.context.annotation.Bean;


public class JavaMailSender {
    @Bean
    public JavaMailSender javaMailSender() {
        return new JavaMailSender();
    }
}
