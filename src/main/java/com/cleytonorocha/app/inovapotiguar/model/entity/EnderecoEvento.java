package com.cleytonorocha.app.inovapotiguar.model.entity;

import com.cleytonorocha.app.inovapotiguar.model.Enum.UF;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoEvento {

    // @NotNull(message = "{inovapotiguar.entity.enderecoEvento.CEP.notNull}")
    private String CEP;

    // @NotNull(message = "{inovapotiguar.entity.enderecoEvento.pais.notNull}")
    // @NotEmpty(message = "{inovapotiguar.entity.enderecoEvento.pais.notEmpty}")
    private String pais;

    // @NotNull(message = "{inovapotiguar.entity.enderecoEvento.UF.notNull}")
    // @NotEmpty(message = "{inovapotiguar.entity.enderecoEvento.UF.notEmpty}")
    @Enumerated(EnumType.STRING)
    private UF UF;

    // @NotNull(message = "{inovapotiguar.entity.enderecoEvento.cidade.notNull}")
    // @NotEmpty(message = "{inovapotiguar.entity.enderecoEvento.cidade.notEmpty}")
    private String cidade;

    // @NotNull(message = "{inovapotiguar.entity.enderecoEvento.bairro.notNull}")
    // @NotEmpty(message = "{inovapotiguar.entity.enderecoEvento.bairro.notEmpty}")
    private String bairro;

    // @NotNull(message = "{inovapotiguar.entity.enderecoEvento.rua.notNull}")
    // @NotEmpty(message = "{inovapotiguar.entity.enderecoEvento.rua.notEmpty}")
    private String rua;

    // @OneToOne
    // @JsonIgnore
    // @JoinColumn(name = "id_evento")
    // private Evento evento;

}
