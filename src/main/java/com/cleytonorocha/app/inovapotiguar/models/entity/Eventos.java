package com.cleytonorocha.app.inovapotiguar.models.entity;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

import com.cleytonorocha.app.inovapotiguar.models.Enum.ProcessoEmpreendedor;

import jakarta.persistence.Entity;
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

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Eventos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{inovarpotiguar.entity.eventos.nome.notnull}")
    @NotEmpty(message = "{inovarpotiguar.entity.eventos.nome.notempty}")
    private String nome;

    private String textoApresentacao;

    private String texto;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "{inovarpotiguar.entity.eventos.processoEmpreendedor.notnull}")
    @NotEmpty(message = "{inovarpotiguar.entity.eventos.processoEmpreendedor.notempty}")
    private ProcessoEmpreendedor processoEmpreendedor;

    private final ZonedDateTime dataCriacao = ZonedDateTime.now();

    @NotNull(message = "{inovarpotiguar.entity.eventos.dataInicio.notnull}")
    @NotEmpty(message = "{inovarpotiguar.entity.eventos.dataInicio.notempty}")
    private LocalDateTime dataInicio;

    @NotNull(message = "{inovarpotiguar.entity.eventos.dataFinal.notnull}")
    @NotEmpty(message = "{inovarpotiguar.entity.eventos.dataFinal.notempty}")
    private LocalDateTime dataFinal;

    private List<Pesquisa> pesquisas;

    private Endereco endereco;

    private List<Instituicao> instituicoes;

    private List<Pesquisador> pesquisadores;

}
