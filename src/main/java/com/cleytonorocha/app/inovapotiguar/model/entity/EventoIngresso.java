package com.cleytonorocha.app.inovapotiguar.model.entity;

import com.cleytonorocha.app.inovapotiguar.model.ids.EventoIngressoID;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EventoIngresso {

    @EmbeddedId
    private EventoIngressoID id;

    @ManyToOne
    @MapsId("eventoId")
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @ManyToOne
    @MapsId("ingressoId")
    @JoinColumn(name = "ingresso_id")
    private Ingresso ingresso;

    
}
