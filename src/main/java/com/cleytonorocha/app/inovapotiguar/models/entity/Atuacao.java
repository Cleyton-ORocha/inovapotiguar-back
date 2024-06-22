package com.cleytonorocha.app.inovapotiguar.models.entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany
    @JoinTable(
        name = "atuacao_evento",
        joinColumns = @JoinColumn(name = "atuacao_id"),
        inverseJoinColumns = @JoinColumn(name = "evento_id")
    )
    private List<Evento> eventos;

    @ManyToMany
    @JoinTable(
        name = "atuacao_instituicao",
        joinColumns = @JoinColumn(name = "atuacao_id"),
        inverseJoinColumns = @JoinColumn(name = "instituicao_id")
    )
    private List<Instituicao> instituicoes;
}
