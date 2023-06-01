package com.info.integracao.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.integracao.repositories.AparelhoExameRepository;

@Service
public class AparelhoExameService implements Serializable {
    
    @Autowired
    private AparelhoExameRepository aparelhoExameRepository;

}
