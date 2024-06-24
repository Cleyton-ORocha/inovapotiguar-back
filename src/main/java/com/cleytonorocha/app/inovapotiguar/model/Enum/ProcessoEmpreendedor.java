package com.cleytonorocha.app.inovapotiguar.model.Enum;

import com.cleytonorocha.app.inovapotiguar.errors.EnumIdInvalid;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProcessoEmpreendedor {
    DESPERTAR_EMPREENDEDOR(0, "Despertar Empreendedor"),
    PRIMEIRA_IDEIA(1, "Primeira Idéia"),
    PRIMEIRA_VENDA(2, "Primeira Venda"),
    ESCALADA_COMERCIAL_TECNOLOGICA(3, "Escala Comercial e Tecnologia"),
    RENOVACAO(4, "Renovação");

    private final Integer cod;
    private final String texto;

    public static ProcessoEmpreendedor toEnum(Integer cod) {
        if (cod == null)
            return null;

        for (ProcessoEmpreendedor interable : ProcessoEmpreendedor.values()) {
            if (cod.equals(interable.getCod()))
                return interable;
        }

        
        throw new EnumIdInvalid();
    }
}
