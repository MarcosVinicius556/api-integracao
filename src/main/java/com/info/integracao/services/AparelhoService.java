package com.info.integracao.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.integracao.repositories.AparelhoRepository;

@Service
public class AparelhoService implements Serializable {
    
    @Autowired
    private AparelhoRepository aparelhoRepository;

}
