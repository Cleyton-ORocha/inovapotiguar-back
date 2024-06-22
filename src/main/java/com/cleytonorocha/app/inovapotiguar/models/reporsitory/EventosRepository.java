package com.cleytonorocha.app.inovapotiguar.models.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleytonorocha.app.inovapotiguar.models.entity.Evento;

public interface EventosRepository extends JpaRepository<Evento, Long>{
    
}
