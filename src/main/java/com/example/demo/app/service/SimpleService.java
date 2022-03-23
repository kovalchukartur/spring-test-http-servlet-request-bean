package com.example.demo.app.service;

import com.example.demo.app.dto.EmployeeDetails;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SimpleService {

    private final AsyncService asyncService;
    private final EmployeeDetails employeeDetails;
    private final HttpServletRequest httpServletRequest;

    public SimpleService(AsyncService asyncService, EmployeeDetails employeeDetails,
                         HttpServletRequest httpServletRequest) {
        this.asyncService = asyncService;
        this.employeeDetails = employeeDetails;
        this.httpServletRequest = httpServletRequest;
    }

    public String getServerNameAndRequestQuery() {
        return asyncService.getServerNameAndRequestQuery(employeeDetails.getEmployeeDetailsDto(), httpServletRequest);
    }

}
