package com.info.integracao.resources;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.integracao.entities.AparelhoLog;
import com.info.integracao.services.AparelhoLogService;

@RestController
@RequestMapping( value = "/aparelho/log" )
public class AparelhoLogResource implements Serializable {
    
    @Autowired
    private AparelhoLogService service;

    @GetMapping
    public ResponseEntity<List<AparelhoLog>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping( value = "/{id}" )
    public ResponseEntity<AparelhoLog> findById(@PathVariable int id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping( value = "/test" )
    public ResponseEntity<String> test(){
        return ResponseEntity.ok().body("REST Aparelho Log rodando!");
    }
}
