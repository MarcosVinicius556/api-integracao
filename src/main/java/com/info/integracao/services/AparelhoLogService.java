package com.info.integracao.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.integracao.entities.AparelhoLog;
import com.info.integracao.repositories.AparelhoLogRepository;

@Service
public class AparelhoLogService implements Serializable {
    
    @Autowired
    private AparelhoLogRepository aparelhoLogRepository;

    public List<AparelhoLog> findAll(){
        return aparelhoLogRepository.findAll();
    }

    public AparelhoLog findById(int id) {
        return aparelhoLogRepository.findById(id).get();
    }

}
