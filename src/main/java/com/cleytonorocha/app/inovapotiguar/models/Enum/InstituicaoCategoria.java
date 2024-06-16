package com.cleytonorocha.app.inovapotiguar.models.Enum;

import com.cleytonorocha.app.inovapotiguar.errors.EnumIdInvalid;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InstituicaoCategoria {
    UNIVERSIDADE(0, "Universidade"),
    INDUSTRIA(1, "Indústria"),
    GOVERNO(2, "Governo"),
    SOCIEDADE_CIVIL(3, "Escala Comercial e Tecnologia");

    private final Integer cod;
    private final String texto;

    public static InstituicaoCategoria toEnum(Integer cod) {
        if (cod == null)
            return null;

        for (InstituicaoCategoria interable : InstituicaoCategoria.values()) {
            if (cod.equals(interable.getCod()))
                return interable;
        }

        
        throw new EnumIdInvalid();
    }
}
