package com.cleytonorocha.app.inovapotiguar.models.Enum;

import com.cleytonorocha.app.inovapotiguar.errors.EnumIdInvalid;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PesquisaCategoria {
    TECNOLOGIA(1, "Tecnologia"),
    SAUDE(2, "Saúde"),
    EDUCACAO(3, "Educação"),
    NEGOCIOS(4, "Negócios"),
    ENTRETENIMENTO(5, "Entretenimento"),
    ESPORTES(6, "Esportes"),
    CULINARIA(7, "Culinária"),
    VIAGENS(8, "Viagens"),
    MODA(9, "Moda"),
    ARTE_CULTURA(10, "Arte e Cultura"),
    CIENCIA(11, "Ciência"),
    HISTORIA(12, "História"),
    MEIO_AMBIENTE(13, "Meio Ambiente"),
    FINANCAS(14, "Finanças"),
    RELIGIAO(15, "Religião"),
    AUTOMOVEIS(16, "Automóveis"),
    ANIMAIS(17, "Animais"),
    FOTOGRAFIA(18, "Fotografia"),
    JOGOS(19, "Jogos"),
    POLITICA(20, "Política"),
    LITERATURA(21, "Literatura"),
    SAUDAVEL(22, "Estilo de Vida Saudável"),
    FUTURO(23, "Futuro e Tecnologias Emergentes"),
    VIAGEM_ESPACIAL(24, "Viagem Espacial"),
    MUSICA(25, "Música"),
    CINEMA(26, "Cinema"),
    ARTES_MARCIAIS(27, "Artes Marciais"),
    PSICOLOGIA(28, "Psicologia"),
    CRIATIVIDADE(29, "Criatividade"),
    SOCIEDADE(30, "Sociedade e Cultura");

    private final Integer cod;
    private final String texto;

    public static PesquisaCategoria toEnum(Integer cod) {
        if (cod == null)
            return null;

        for (PesquisaCategoria interable : PesquisaCategoria.values()) {
            if (cod.equals(interable.getCod()))
                return interable;
        }

        throw new EnumIdInvalid();
    }
}
