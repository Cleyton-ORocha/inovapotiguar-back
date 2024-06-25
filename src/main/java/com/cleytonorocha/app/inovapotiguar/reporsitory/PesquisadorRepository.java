package com.cleytonorocha.app.inovapotiguar.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleytonorocha.app.inovapotiguar.model.entity.Pesquisador;

public interface PesquisadorRepository extends JpaRepository<Pesquisador, Long>{
    
}
