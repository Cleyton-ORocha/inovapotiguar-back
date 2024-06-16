package com.cleytonorocha.app.inovapotiguar.models.entity;

import java.util.List;

import com.cleytonorocha.app.inovapotiguar.models.Enum.PesquisaCategoria;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pesquisa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "{inovapotiguar.entity.pesquisa.nome.notnull}")
    @NotEmpty(message = "{inovapotiguar.entity.pesquisa.nome.notEmpty}")
    private String nome;

    @NotNull(message = "{inovapotiguar.entity.pesquisa.texto.notnull}")
    @NotEmpty(message = "{inovapotiguar.entity.pesquisa.texto.notEmpty}")
    private String texto;

    private List<String> fontes;
    private Long visualizacoes;
    private Long curtidas;

    @Enumerated(EnumType.STRING)
    private PesquisaCategoria categoria;
}