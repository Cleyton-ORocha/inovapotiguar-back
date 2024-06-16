package com.cleytonorocha.app.inovapotiguar.models.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class EnderecoEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "${inovapotiguar.entity.enderecoEvento.CEP.notNull}")
    private String CEP;

    @NotNull(message = "${inovapotiguar.entity.enderecoEvento.pais.notNull}")
    @NotEmpty(message = "${inovapotiguar.entity.enderecoEvento.pais.notEmpty}")
    private String pais;

    @NotNull(message = "${inovapotiguar.entity.enderecoEvento.UF.notNull}")
    @NotEmpty(message = "${inovapotiguar.entity.enderecoEvento.UF.notEmpty}")
    private String UF;

    @NotNull(message = "${inovapotiguar.entity.enderecoEvento.cidade.notNull}")
    @NotEmpty(message = "${inovapotiguar.entity.enderecoEvento.cidade.notEmpty}")
    private String cidade;

    @NotNull(message = "${inovapotiguar.entity.enderecoEvento.bairro.notNull}")
    @NotEmpty(message = "${inovapotiguar.entity.enderecoEvento.bairro.notEmpty}")
    private String bairro;

    @NotNull(message = "${inovapotiguar.entity.enderecoEvento.rua.notNull}")
    @NotEmpty(message = "${inovapotiguar.entity.enderecoEvento.rua.notEmpty}")
    private String rua;

}
