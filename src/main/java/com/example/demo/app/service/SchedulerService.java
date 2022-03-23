package com.example.demo.app.service;

import com.example.demo.app.dto.EmployeeDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SchedulerService {

    private final EmployeeDetails employeeDetails;

    public SchedulerService(EmployeeDetails employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    // todo source of data - it's app context ot external store
    //  so here not need @RequestScope
    //  @Scheduled(fixedRate = 5000)
    public void loggingRandomData() {
       log.info(employeeDetails.getEmployeeDetailsDto().getId()); // accessing request scope bean
    }

}
