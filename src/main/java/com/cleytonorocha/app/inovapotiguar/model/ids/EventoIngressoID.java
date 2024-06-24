package com.cleytonorocha.app.inovapotiguar.model.ids;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class EventoIngressoID implements Serializable {
    @Column(name = "evento_id")
    private Long eventoId;
    @Column(name = "ingresso_id")
    private Long ingressoId;
}
