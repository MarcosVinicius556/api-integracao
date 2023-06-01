package com.info.integracao.resources;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.integracao.services.AparelhoLogService;

@RestController
@RequestMapping( value = "/aparelho-log" )
public class AparelhoLogResource implements Serializable{
    
    @Autowired
    private AparelhoLogService service;

    @GetMapping( value = "/test" )
    public ResponseEntity<String> test(){
        return ResponseEntity.ok().body("REST Aparelho Log rodando!");
    }
}
