package com.br.puc.modulo.usuario.services;

import com.br.puc.modulo.usuario.dtos.usuario.UsuarioRequest;
import com.br.puc.modulo.usuario.dtos.usuario.UsuarioResponse;
import com.br.puc.modulo.usuario.entities.Usuario;
import com.br.puc.modulo.usuario.exceptions.UsuarioExistenteException;
import com.br.puc.modulo.usuario.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    private ModelMapper mapper;

    private SenhaService senhaService;

    @Autowired
    public UsuarioService(UsuarioRepository repository, ModelMapper mapper, SenhaService senhaService) {
        this.repository = repository;
        this.mapper = mapper;
        this.senhaService = senhaService;
    }

    public UsuarioResponse criarUsuario(UsuarioRequest usuarioRequest) {

        validarUsuario(usuarioRequest);

        Usuario usuario = mapper.map(usuarioRequest, Usuario.class);

        String hashSenha = senhaService.gerarHashBcryptSenha(usuarioRequest.getSenha());
        usuario.setSenha(hashSenha);

        repository.save(usuario);

        return mapper.map(usuario, UsuarioResponse.class);
    }

    private void validarUsuario(UsuarioRequest request) {

        Usuario usuario = repository.findByLogin(request.getLogin());

        if(usuario != null) {
            throw new UsuarioExistenteException("Login já existente, tente outro novamente");
        }
    }
}
