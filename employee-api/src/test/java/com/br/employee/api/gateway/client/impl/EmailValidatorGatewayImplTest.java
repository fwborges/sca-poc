package com.br.employee.api.gateway.client.impl;


import com.br.employee.api.clients.EmailValidatorClient;
import com.br.employee.api.clients.dto.EmailResponse;
import com.br.employee.api.gateway.client.EmailValidatorGateway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmailValidatorGatewayImplTest {

    private static final String INVALID_EMAIL = "dasdasd@fdsfds.com";

    private static final String VALID_EMAIL = "felipe@borges.com";

    public static final String API_KEY = "apiKey";

    public static final int TIMEOUT = 10;

    @Mock
    private EmailValidatorClient emailValidatorClient;

    private EmailValidatorGateway emailValidatorGateway;

    @Before
    public void setUp() {

        emailValidatorGateway = new EmailValidatorGatewayImpl(emailValidatorClient, API_KEY, TIMEOUT);
    }

    @Test
    public void shouldReturnInvalidEmail() {

        EmailResponse mockResponse = buildResponseEmail(INVALID_EMAIL, "error");

        when(emailValidatorClient.validateEmail(INVALID_EMAIL, API_KEY, TIMEOUT)).thenReturn(mockResponse);

        boolean invalidEmail = emailValidatorGateway.isInvalidEmail(INVALID_EMAIL);

        assertTrue(invalidEmail);
    }

    @Test
    public void shouldReturnValidEmail() {

        EmailResponse mockResponse = buildResponseEmail(VALID_EMAIL, "ok");

        when(emailValidatorClient.validateEmail(VALID_EMAIL, API_KEY, TIMEOUT)).thenReturn(mockResponse);

        boolean invalidEmail = emailValidatorGateway.isInvalidEmail(VALID_EMAIL);

        assertFalse(invalidEmail);
    }

    private EmailResponse buildResponseEmail(String email, String result) {

        EmailResponse response = new EmailResponse();
        response.setEmail(email);
        response.setResult(result);

        return response;
    }
}
