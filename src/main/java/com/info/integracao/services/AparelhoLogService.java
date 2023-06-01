package com.info.integracao.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.integracao.repositories.AparelhoLogRepository;

@Service
public class AparelhoLogService implements Serializable {
    
    @Autowired
    private AparelhoLogRepository aparelhoLogRepository;

}
