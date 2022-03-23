package com.example.demo.app.api;

import com.example.demo.app.dto.EmployeeDetails;
import com.example.demo.app.service.AsyncService;
import com.example.demo.app.service.SimpleService;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller {

    private final EmployeeDetails employeeDetails;
    private final SimpleService simpleService;
    private final AsyncService asyncService;

    public Controller(EmployeeDetails employeeDetails,
                      SimpleService simpleService,
                      AsyncService asyncService) {
        this.employeeDetails = employeeDetails;
        this.simpleService = simpleService;
        this.asyncService = asyncService;
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
        asyncService.getAsyncServerNameAndRequestQuery();
        return "pong";
    }

}
