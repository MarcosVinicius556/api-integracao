package com.info.integracao.resources;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.integracao.services.AparelhoService;

@RestController
@RequestMapping( value = "/aparelho" )
public class AparelhoResource implements Serializable{
    
    @Autowired
    private AparelhoService service;

    @GetMapping( value = "/test" )
    public ResponseEntity<String> test(){
        return ResponseEntity.ok().body("REST Aparelho rodando!");
    }
}
