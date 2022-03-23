package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SimpleService {

    private final EmployeeDetails employeeDetails;
    private final HttpServletRequest httpServletRequest;

    public SimpleService(EmployeeDetails employeeDetails,
                         HttpServletRequest httpServletRequest) {
        this.employeeDetails = employeeDetails;
        this.httpServletRequest = httpServletRequest;
    }

    public String getServerNameAndRequestQuery() {
        log.info("User uuid = {}", employeeDetails.getId());
        String requestQueryString = httpServletRequest.getQueryString();
        log.info("Request query: {}", requestQueryString);
        return httpServletRequest.getServerName() + " " + requestQueryString;
    }

}
