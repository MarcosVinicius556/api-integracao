package com.info.integracao.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.integracao.repositories.AparelhoCamposRepository;

@Service
public class AparelhoCamposService implements Serializable {
    
    @Autowired
    private AparelhoCamposRepository aparelhoCamposRepository;

}
