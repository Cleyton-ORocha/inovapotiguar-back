package com.cleytonorocha.app.inovapotiguar.models.entity;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    @ManyToMany
    @JoinTable(
        name = "pesquisador_eventos",
        joinColumns = @JoinColumn(name = "pesquisador_id"),
        inverseJoinColumns = @JoinColumn(name = "eventos_id")
    )
    private List<Evento> eventos;

    @ManyToMany
    @JoinTable(
        name = "pesquisador_atuacao",
        joinColumns = @JoinColumn(name = "pesquisador_id"),
        inverseJoinColumns = @JoinColumn(name = "atuacao_id")
    )
    private List<Atuacao> atuacoes;

    @ManyToMany(mappedBy = "pesquisadores" ,fetch = FetchType.LAZY)
    private List<Pesquisa> pesquisas;

}
