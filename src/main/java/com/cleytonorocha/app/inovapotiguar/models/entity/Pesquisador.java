package com.cleytonorocha.app.inovapotiguar.models.entity;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Pesquisador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CPF
    @NotNull(message = "${inovapotiguar.entity.enderecoEvento.cpf.notNull}")
    @NotEmpty(message = "${inovapotiguar.entity.enderecoEvento.cpf.notEmpty}")
    private String CPF;

    @NotNull(message = "${inovapotiguar.entity.enderecoEvento.nome.notNull}")
    @NotEmpty(message = "${inovapotiguar.entity.enderecoEvento.nome.notEmpty}")
    private String nome;

    @NotNull(message = "${inovapotiguar.entity.enderecoEvento.cargo.notNull}")
    @NotEmpty(message = "${inovapotiguar.entity.enderecoEvento.cargo.notEmpty}")
    private String cargo;

    @NotNull(message = "${inovapotiguar.entity.enderecoEvento.email.notNull}")
    @NotEmpty(message = "${inovapotiguar.entity.enderecoEvento.email.notEmpty}")
    private String email;

    @NotNull(message = "${inovapotiguar.entity.enderecoEvento.telefone.notNull}")
    @NotEmpty(message = "${inovapotiguar.entity.enderecoEvento.telefone.notEmpty}")
    private String telefone;

    private String descricao;
    private String fotoPerfil;
    private String site;
    private String linkedin;
    private String instagram;
    private String twitter;

}
