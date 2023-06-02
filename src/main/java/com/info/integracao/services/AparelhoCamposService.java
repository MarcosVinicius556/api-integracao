package com.info.integracao.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.integracao.entities.AparelhoCampos;
import com.info.integracao.repositories.AparelhoCamposRepository;

@Service
public class AparelhoCamposService implements Serializable {
    
    @Autowired
    private AparelhoCamposRepository aparelhoCamposRepository;

    public List<AparelhoCampos> findAll(){
        return aparelhoCamposRepository.findAll();
    }

    public AparelhoCampos findById(int id) {
        return aparelhoCamposRepository.findById(id).get();
    }

}
