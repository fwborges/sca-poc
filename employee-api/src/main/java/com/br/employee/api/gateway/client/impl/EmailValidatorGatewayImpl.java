package com.br.employee.api.gateway.client.impl;

import com.br.employee.api.clients.EmailValidatorClient;
import com.br.employee.api.clients.dto.EmailResponse;
import com.br.employee.api.gateway.client.EmailValidatorGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailValidatorGatewayImpl implements EmailValidatorGateway {

    private final static String MESSAGE_OK = "ok";

    @Value("${hubuco.domain.key}")
    private String apiKey;

    @Value("${hubuco.domain.timeout}")
    private Integer timeout;

    @Autowired
    private EmailValidatorClient emailValidatorClient;

    @Override
    public boolean isInvalidEmail(String email) {

        EmailResponse emailResponse = emailValidatorClient.validateEmail(email, apiKey, timeout);
        return !emailResponse.getResult().equals(MESSAGE_OK);
    }
}
