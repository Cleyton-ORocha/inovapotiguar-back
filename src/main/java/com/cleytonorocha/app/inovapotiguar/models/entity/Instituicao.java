package com.cleytonorocha.app.inovapotiguar.models.entity;

import org.hibernate.validator.constraints.br.CNPJ;

import com.cleytonorocha.app.inovapotiguar.models.Enum.InstituicaoCategoria;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Instituicao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;

    private String descricao;

    @CNPJ
    private String CNPJ;

    @Enumerated(EnumType.STRING)
    private InstituicaoCategoria categoria;

    private String site;
    private String email;
    private String linkedin;
    private String instagram;

}
