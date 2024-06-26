package com.cleytonorocha.app.inovapotiguar.model.entity;

import java.util.List;

import com.cleytonorocha.app.inovapotiguar.model.Enum.PesquisaCategoria;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
public class Pesquisa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{inovapotiguar.entity.pesquisa.nome.notnull}")
    @NotEmpty(message = "{inovapotiguar.entity.pesquisa.nome.notEmpty}")
    private String nome;

    @Lob
    @NotNull(message = "{inovapotiguar.entity.pesquisa.texto.notnull}")
    @NotEmpty(message = "{inovapotiguar.entity.pesquisa.texto.notEmpty}")
    private String texto;

    private List<String> fontes;
    private Long visualizacoes;
    private Long curtidas;

    @Enumerated(EnumType.STRING)
    private PesquisaCategoria categoria;

    @ManyToMany
    @JoinTable(name = "pesquisa_evento", joinColumns = @JoinColumn(name = "pesquisa_id"), inverseJoinColumns = @JoinColumn(name = "eventos_id"))
    private List<Evento> eventos;

    @ManyToMany
    @JoinTable(name = "pesquisa_instituicao", joinColumns = @JoinColumn(name = "pesquisa_id"), inverseJoinColumns = @JoinColumn(name = "instiuicao_id"))
    private List<Instituicao> instituicoes;

    @ManyToMany
    @JoinTable(name = "pesquisa_pesquisador", joinColumns = @JoinColumn(name = "pesquisa_id"), inverseJoinColumns = @JoinColumn(name = "pesquisador_id"))
    private List<Pesquisador> pesquisadores;

    @OneToMany(mappedBy = "pesquisa", fetch = FetchType.LAZY)
    private List<PesquisaImagens> imagens;
}
