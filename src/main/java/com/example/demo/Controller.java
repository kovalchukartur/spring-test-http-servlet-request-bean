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
    private final AsyncSimpleService asyncSimpleService;

    public Controller(EmployeeDetails employeeDetails,
                      SimpleService simpleService,
                      AsyncSimpleService asyncSimpleService) {
        this.employeeDetails = employeeDetails;
        this.simpleService = simpleService;
        this.asyncSimpleService = asyncSimpleService;
    }

    @GetMapping("/ping")
    public String ping() {
        UUID uuid = UUID.randomUUID();
        log.info("User uuid = {}", uuid);
        employeeDetails.setId(uuid.toString());
        String response = "pong" + " " + simpleService.getServerNameAndRequestQuery();
        log.info("Response: {}", response);
        return response;
    }

    @GetMapping("/async/ping")
    public String asyncPing() {
        asyncSimpleService.getAsyncServerNameAndRequestQuery();
        return "pong";
    }

}
