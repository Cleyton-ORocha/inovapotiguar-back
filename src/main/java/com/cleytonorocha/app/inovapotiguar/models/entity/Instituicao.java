package com.cleytonorocha.app.inovapotiguar.models.entity;

import java.util.List;

import org.hibernate.validator.constraints.br.CNPJ;

import com.cleytonorocha.app.inovapotiguar.models.Enum.InstituicaoCategoria;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Instituicao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "{inovapotiguar.entity.instituicao.nome.notNull}")
    @NotEmpty(message = "{inovapotiguar.entity.instituicao.nome.notEmpty}")
    private String nome;

    @NotNull(message = "{inovapotiguar.entity.instituicao.descricao.notNull}")
    @NotEmpty(message = "{inovapotiguar.entity.instituicao.descricao.notEmpty}")
    private String descricao;

    @CNPJ
    private String CNPJ;

    @Enumerated(EnumType.STRING)
    private InstituicaoCategoria categoria;

    private String site;
    private String email;
    private String linkedin;
    private String instagram;

    @ManyToMany
    @JoinTable(
        name = "instituicao_evento",
        joinColumns = @JoinColumn(name = "instituicao_id"),
        inverseJoinColumns = @JoinColumn(name = "eventos_id")
    )
    private List<Evento> eventos;

    @ManyToMany(mappedBy = "instituicoes")
    private List<Pesquisa> pesquisas;

    @ManyToMany(mappedBy = "instituicoes")
    private List<Atuacao> atuacoes;


}
