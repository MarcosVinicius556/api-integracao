package com.info.integracao.resources;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.integracao.entities.AparelhoExame;
import com.info.integracao.services.AparelhoExameService;

@RestController
@RequestMapping( value = "/aparelho/exames" )
public class AparelhoExameResource implements Serializable {
    
    @Autowired
    private AparelhoExameService service;

    @GetMapping
    public ResponseEntity<List<AparelhoExame>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping( value = "/{id}" )
    public ResponseEntity<AparelhoExame> findById(@PathVariable int id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping( value = "/test" )
    public ResponseEntity<String> test(){
        return ResponseEntity.ok().body("REST Aparelho  Exame rodando!");
    }
}
