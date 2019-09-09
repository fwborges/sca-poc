package com.br.puc.modulo.usuario.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "usuario_sca")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;
}
