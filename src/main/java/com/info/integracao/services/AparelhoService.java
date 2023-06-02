package com.info.integracao.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.integracao.entities.Aparelho;
import com.info.integracao.repositories.AparelhoRepository;

@Service
public class AparelhoService implements Serializable {
    
    @Autowired
    private AparelhoRepository aparelhoRepository;

    public List<Aparelho> findAll(){
        return aparelhoRepository.findAll();
    }

    public Aparelho findById(int id){
        return aparelhoRepository.findById(id).get();
    }

}
