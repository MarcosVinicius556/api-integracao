package com.info.integracao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.info.integracao.entities.AparelhoLog;

public interface AparelhoLogRepository extends JpaRepository<AparelhoLog, Integer>{
    
}
