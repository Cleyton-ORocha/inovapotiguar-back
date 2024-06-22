package com.cleytonorocha.app.inovapotiguar.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{inovapotiguar.entity.enderecoEvento.CEP.notNull}")
    private String CEP;

    @NotNull(message = "{inovapotiguar.entity.enderecoEvento.pais.notNull}")
    @NotEmpty(message = "{inovapotiguar.entity.enderecoEvento.pais.notEmpty}")
    private String pais;

    @NotNull(message = "{inovapotiguar.entity.enderecoEvento.UF.notNull}")
    @NotEmpty(message = "{inovapotiguar.entity.enderecoEvento.UF.notEmpty}")
    private String UF;

    @NotNull(message = "{inovapotiguar.entity.enderecoEvento.cidade.notNull}")
    @NotEmpty(message = "{inovapotiguar.entity.enderecoEvento.cidade.notEmpty}")
    private String cidade;

    @NotNull(message = "{inovapotiguar.entity.enderecoEvento.bairro.notNull}")
    @NotEmpty(message = "{inovapotiguar.entity.enderecoEvento.bairro.notEmpty}")
    private String bairro;

    @NotNull(message = "{inovapotiguar.entity.enderecoEvento.rua.notNull}")
    @NotEmpty(message = "{inovapotiguar.entity.enderecoEvento.rua.notEmpty}")
    private String rua;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "id_evento")
    private Evento evento;

}
