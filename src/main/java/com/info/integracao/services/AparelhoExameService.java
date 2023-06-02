package com.info.integracao.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.integracao.entities.AparelhoExame;
import com.info.integracao.repositories.AparelhoExameRepository;

@Service
public class AparelhoExameService implements Serializable {
    
    @Autowired
    private AparelhoExameRepository aparelhoExameRepository;

    public List<AparelhoExame> findAll(){
        return aparelhoExameRepository.findAll();
    }

    public AparelhoExame findById(int id){
        return aparelhoExameRepository.findById(id).get();
    }

}
