package com.example.demo.app.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Data
@Component
@RequestScope
public class EmployeeDetails {

    private final EmployeeDetailsDto employeeDetailsDto = new EmployeeDetailsDto();

}