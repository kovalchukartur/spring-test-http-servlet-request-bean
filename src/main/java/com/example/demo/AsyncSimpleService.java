package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncSimpleService {

    private final SimpleService simpleService;

    public AsyncSimpleService(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    @Async
    public void getAsyncServerNameAndRequestQuery() {
        simpleService.getServerNameAndRequestQuery();
    }

}
