package com.cleytonorocha.app.inovapotiguar.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleytonorocha.app.inovapotiguar.model.entity.Ingresso;

public interface IngressoRepository extends JpaRepository<Ingresso, Long>{
    
}
