package com.br.employee.api.clients;

import com.br.employee.api.clients.dto.EmailResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${hubuco.domain.url}", name = "email-service")
public interface EmailValidatorClient {

    @GetMapping
    EmailResponse validateEmail(@RequestParam("email") String email, @RequestParam("api") String api, @RequestParam("timeout") Integer timeout);
}
