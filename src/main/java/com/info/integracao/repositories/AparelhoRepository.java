package com.info.integracao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.info.integracao.entities.Aparelho;

public interface AparelhoRepository extends JpaRepository<Aparelho, Integer>{
    
}
