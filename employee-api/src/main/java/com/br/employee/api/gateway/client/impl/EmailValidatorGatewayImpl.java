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

    private String apiKey;

    private Integer timeout;

    private EmailValidatorClient emailValidatorClient;

    @Autowired
    public EmailValidatorGatewayImpl(EmailValidatorClient emailValidatorClient,
                                     @Value("${hubuco.domain.key}") String apiKey,
                                     @Value("${hubuco.domain.timeout}") Integer timeout) {

        this.emailValidatorClient = emailValidatorClient;
        this.apiKey = apiKey;
        this.timeout = timeout;
    }

    @Override
    public boolean isInvalidEmail(String email) {

        EmailResponse emailResponse = emailValidatorClient.validateEmail(email, apiKey, timeout);
        return !emailResponse.getResult().equals(MESSAGE_OK);
    }
}
