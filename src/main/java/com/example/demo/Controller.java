package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final SimpleService simpleService;

    @GetMapping("/ping")
    public String ping() {
        return "pong" + " " + simpleService.getServerNameAndRequestQuery();
    }

}
