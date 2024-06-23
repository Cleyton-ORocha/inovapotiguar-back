package com.cleytonorocha.app.inovapotiguar.models.entity;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

import com.cleytonorocha.app.inovapotiguar.models.Enum.ProcessoEmpreendedor;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
public class Evento {

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
    
    @OneToOne(mappedBy = "evento", fetch = FetchType.LAZY)
    private EnderecoEvento endereco;

    @OneToMany(mappedBy = "evento", fetch = FetchType.LAZY)
    private List<ImagensEvento> imagens;

    @ManyToMany(mappedBy = "eventos")
    private List<Pesquisa> pesquisas;

    @ManyToMany(mappedBy = "eventos")
    private List<Instituicao> instituicoes;

    @ManyToMany(mappedBy = "eventos")
    private List<Pesquisador> pesquisadores;

    @ManyToMany(mappedBy = "eventos")
    private List<Atuacao> atuacoes;

}
