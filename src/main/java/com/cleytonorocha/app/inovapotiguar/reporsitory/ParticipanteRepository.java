package com.cleytonorocha.app.inovapotiguar.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleytonorocha.app.inovapotiguar.model.entity.Participante;

public interface ParticipanteRepository extends JpaRepository<Participante, Long>{
    
}
