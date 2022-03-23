package com.example.demo;

import javax.servlet.http.HttpServletRequest;
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
    @Scheduled(cron="0 0 * * * *")
    public void greetings() {
       log.info(employeeDetails.getId()); // accessing request scope bean
    }

}
