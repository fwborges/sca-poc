package com.br.puc.modulo.usuario.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {


    static final long EXPIRATION_TIME = 600000;
    static final String SECRET = "secret-puc-sca-poc";

    public String gerarToken(String login) {

        String token = Jwts.builder()
                .setSubject(login)
               // .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();

        return token;
    }



}

