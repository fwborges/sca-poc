package com.br.puc.modulo.usuario.services;

import com.br.puc.modulo.usuario.dtos.login.LoginRequest;
import com.br.puc.modulo.usuario.dtos.login.LoginResponse;
import com.br.puc.modulo.usuario.entities.Usuario;
import com.br.puc.modulo.usuario.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private UsuarioRepository usuarioRepository;

    private SenhaService senhaService;

    private TokenService tokenService;

    @Autowired
    public LoginService(UsuarioRepository usuarioRepository, SenhaService senhaService, TokenService tokenService) {
        this.usuarioRepository = usuarioRepository;
        this.senhaService = senhaService;
        this.tokenService = tokenService;
    }

    public LoginResponse login(LoginRequest loginRequest) {

        Usuario usuario = usuarioRepository.findByLogin(loginRequest.getLogin());

        if(usuario == null) {
            throw new RuntimeException("Usuario não encontrado");
        }

        boolean senhaValida = senhaService.validarHashSenha(loginRequest.getSenha(), usuario.getSenha());

        if(senhaValida) {

            String token = tokenService.gerarToken(loginRequest.getLogin());
            return LoginResponse.builder().token(token).build();
        } else {

            throw new RuntimeException("Senha inválida");
        }
    }


}