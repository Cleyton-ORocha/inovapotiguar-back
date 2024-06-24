package com.cleytonorocha.app.inovapotiguar.model.Enum;

import com.cleytonorocha.app.inovapotiguar.errors.EnumIdInvalid;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusPagamento {
    PENDENTE(0, "Pendente"),
    PAGO(1, "Pago"),
    CANCELADO(2, "Cancelado"),
    FALHOU(3, "Falhou"),
    REEMBOLSADO(4, "Reembolsado");

    private final Integer cod;
    private final String descricao;

    public static StatusPagamento toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (StatusPagamento status : StatusPagamento.values()) {
            if (cod.equals(status.getCod())) {
                return status;
            }
        }

        throw new EnumIdInvalid();
    }
}