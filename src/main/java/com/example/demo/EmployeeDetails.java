package com.example.demo;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Data
@Service
@RequestScope
public class EmployeeDetails {

    private String id;
    private String name;
    private String dept;

}