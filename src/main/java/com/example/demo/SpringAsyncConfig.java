package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.context.request.RequestContextListener;

@Configuration
@EnableAsync
public class SpringAsyncConfig {

    @Bean
    RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

}
