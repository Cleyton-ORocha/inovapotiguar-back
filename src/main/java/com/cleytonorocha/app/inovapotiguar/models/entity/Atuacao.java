package com.cleytonorocha.app.inovapotiguar.models.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Atuacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{inovapotiguar.entity.atuacao.nome.notNull}")
    @NotEmpty(message = "{inovapotiguar.entity.atuacao.nome.notEmpty}")
    private String nome;

    @NotNull(message = "{inovapotiguar.entity.atuacao.descricao.notNull}")
    @NotEmpty(message = "{inovapotiguar.entity.atuacao.descricao.notEmpty}")
    private String descricao;
}
