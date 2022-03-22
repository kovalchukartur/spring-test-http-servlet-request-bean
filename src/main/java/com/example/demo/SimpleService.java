package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleService {

    private final HttpServletRequest httpServletRequest;

    public String getServerName() {
        return httpServletRequest.getServerName();

    }
}