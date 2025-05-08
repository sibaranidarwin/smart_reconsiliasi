package com.hackathon.smart_reconsiliasi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class App {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
