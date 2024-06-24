package com.cleytonorocha.app.inovapotiguar.model.entity;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.cleytonorocha.app.inovapotiguar.model.Enum.StatusPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    private BigDecimal valor;

    // private LocalDateTime dataPagamento;

    @CreationTimestamp
    private ZonedDateTime dataCriacao;

    @OneToMany(mappedBy = "pagamento")
    private Set<Ingresso> ingressos;

    @ManyToOne
    @JoinColumn(name = "")
    private Participante participante;
    
}
