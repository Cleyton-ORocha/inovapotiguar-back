package com.cleytonorocha.app.inovapotiguar.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleytonorocha.app.inovapotiguar.model.entity.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
    
}
