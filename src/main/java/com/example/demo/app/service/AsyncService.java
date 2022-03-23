package com.example.demo.app.service;

import com.example.demo.app.dto.EmployeeDetailsDto;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncService {

    @Async
    public void getAsyncServerNameAndRequestQuery(EmployeeDetailsDto employeeDetails, HttpServletRequest httpServletRequest) {
        getServerNameAndRequestQuery(employeeDetails, httpServletRequest);
    }

    public String getServerNameAndRequestQuery(@NotNull EmployeeDetailsDto employeeDetails,
                                               @Nullable HttpServletRequest httpServletRequest) {
        log.info("User uuid = {}", employeeDetails.getId());

        String requestQueryString = Optional.ofNullable(httpServletRequest)
            .map(HttpServletRequest::getQueryString)
            .orElse(null);
        log.info("Request query: {}", requestQueryString);

        String serverName = Optional.ofNullable(httpServletRequest)
            .map(HttpServletRequest::getServerName)
            .orElse(null);
        return serverName + " " + requestQueryString;
    }

}
