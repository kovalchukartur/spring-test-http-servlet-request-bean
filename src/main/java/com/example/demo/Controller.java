package com.example.demo;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller {

    private final EmployeeDetails employeeDetails;
    private final SimpleService simpleService;

    public Controller(EmployeeDetails employeeDetails,
                      SimpleService simpleService) {
        this.employeeDetails = employeeDetails;
        this.simpleService = simpleService;
    }

    @GetMapping("/ping")
    public String ping() {
        UUID uuid = UUID.randomUUID();
        log.info("User uuid = {}", uuid);
        employeeDetails.setId(uuid.toString());
        return "pong" + " " + simpleService.getServerNameAndRequestQuery();
    }

}
