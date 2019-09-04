package com.br.puc.modulo.usuario.repositories;

import com.br.puc.modulo.usuario.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByLogin(String login);
}
