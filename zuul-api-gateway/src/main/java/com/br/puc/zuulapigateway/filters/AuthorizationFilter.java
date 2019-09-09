package com.br.puc.zuulapigateway.filters;

import com.br.puc.zuulapigateway.services.ValidadorToken;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class AuthorizationFilter extends ZuulFilter {

    @Autowired
    private ValidadorToken validadorToken;

    @Value("${recurso.obrigatorio.autorizacao}")
    public String recursoObrigatorioAutorizacao;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {

        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

        List<String> uris = Arrays.asList(recursoObrigatorioAutorizacao.split(","));

        return uris.contains(request.getRequestURI());
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.debug("Request -> {} request URI -> {}", request, request.getRequestURI());

        try {
            validadorToken.validarToken(request);
        } catch (Exception exception) {
            // blocks the request
            ctx.setSendZuulResponse(false);

            // response to client
            ctx.setResponseBody("Requisição não autorizada");
            ctx.getResponse().setHeader("Content-Type", "application/json;charset=UTF-8");
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }

        return null;
    }
}