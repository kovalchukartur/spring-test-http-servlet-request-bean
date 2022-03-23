package com.example.demo.app.service;

import com.example.demo.app.dto.EmployeeDetailsDto;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncService {

    private final SimpleService simpleService;

    public AsyncService(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    @Async
    public void getAsyncServerNameAndRequestQuery(EmployeeDetailsDto employeeDetails, HttpServletRequest httpServletRequest) {
        simpleService.getServerNameAndRequestQuery(employeeDetails, httpServletRequest);
    }

}
