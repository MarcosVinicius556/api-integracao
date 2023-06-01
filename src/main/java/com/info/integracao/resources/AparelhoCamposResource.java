package com.info.integracao.resources;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.integracao.services.AparelhoCamposService;

@RestController
@RequestMapping( value = "/aparelho-campos" )
public class AparelhoCamposResource implements Serializable{
    
    @Autowired
    private AparelhoCamposService service;

    @GetMapping( value = "/test" )
    public ResponseEntity<String> test(){
        return ResponseEntity.ok().body("REST Aparelho Campos rodando!");
    }
}
