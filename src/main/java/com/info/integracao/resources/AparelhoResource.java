package com.info.integracao.resources;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.integracao.dto.AparelhoMinDTO;
import com.info.integracao.entities.Aparelho;
import com.info.integracao.services.AparelhoService;

@RestController
@RequestMapping( value = "/aparelho" )
public class AparelhoResource implements Serializable {
    
    @Autowired
    private AparelhoService service;

    @GetMapping
    public ResponseEntity<List<Aparelho>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping( value = "/{id}" )
    public ResponseEntity<AparelhoMinDTO> findById(@PathVariable int id){
        AparelhoMinDTO aparelho = new AparelhoMinDTO(service.findById(id));
        return ResponseEntity.ok().body(aparelho);
    } 

    @GetMapping( value = "/test" )
    public ResponseEntity<String> test(){
        return ResponseEntity.ok().body("REST Aparelho rodando!");
    }
}
