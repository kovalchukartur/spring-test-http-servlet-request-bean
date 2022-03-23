package com.example.demo.app.api;

import com.example.demo.app.dto.EmployeeDetails;
import com.example.demo.app.service.AsyncService;
import com.example.demo.app.service.SimpleService;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller {

    private final HttpServletRequest httpServletRequest;
    private final EmployeeDetails employeeDetails;
    private final SimpleService simpleService;
    private final AsyncService asyncService;

    public Controller(HttpServletRequest httpServletRequest,
                      EmployeeDetails employeeDetails,
                      SimpleService simpleService,
                      AsyncService asyncService) {
        this.httpServletRequest = httpServletRequest;
        this.employeeDetails = employeeDetails;
        this.simpleService = simpleService;
        this.asyncService = asyncService;
    }

    @GetMapping("/ping")
    public String ping() {
        setUuid();

        String response = "pong" + " " + simpleService.getServerNameAndRequestQuery();
        log.info("Response: {}", response);
        return response;
    }

    @GetMapping("/async/ping")
    public String asyncPing() {
        setUuid();

        asyncService.getAsyncServerNameAndRequestQuery(employeeDetails.getEmployeeDetailsDto().toBuilder().build(), null);
        return "pong";
    }

    private void setUuid() {
        UUID uuid = UUID.randomUUID();
        log.info("User uuid = {}", uuid);
        employeeDetails.getEmployeeDetailsDto().setId(uuid.toString());
    }

}
