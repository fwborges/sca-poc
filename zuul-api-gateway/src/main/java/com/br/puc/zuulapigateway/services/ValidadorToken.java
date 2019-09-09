package com.br.puc.zuulapigateway.services;

import com.br.puc.zuulapigateway.exceptions.UnauthorizedException;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

@Component
public class ValidadorToken {

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
                throw new UnauthorizedException("JWT Invalido");
            }
        } else {
            throw new UnauthorizedException("Usuário não autenticado");
        }
    }
}
