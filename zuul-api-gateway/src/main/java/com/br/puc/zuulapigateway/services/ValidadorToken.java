package com.br.puc.zuulapigateway.services;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

@Component
public class ValidadorToken {

    // EXPIRATION_TIME = 10 dias
    static final long EXPIRATION_TIME = 860_000_000;
    static final String SECRET = "secret-puc-sca-poc";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    public void validarToken(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            // faz parse do token
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            if (user == null) {
                throw new RuntimeException("JWT Invalido");
            }
        }
    }
}
