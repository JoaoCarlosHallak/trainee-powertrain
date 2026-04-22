package com.hallak.escuderiaIdeas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hallak.escuderiaIdeas.dtos.ExaustaoRequisicao;
import com.hallak.escuderiaIdeas.dtos.ExaustaoResposta;
import com.hallak.escuderiaIdeas.services.ExhaustService;



@RestController
@CrossOrigin(origins = "*")
public class EscuderiaIdeasController {

    private final ExhaustService exhaustService;

    @Autowired
    public EscuderiaIdeasController(ExhaustService exhaustService) {
        this.exhaustService = exhaustService;
    }



    @PostMapping("api/escapamento/calcular")
    public ResponseEntity<ExaustaoResposta> calculateExhaust(@RequestBody ExaustaoRequisicao exaustaoRequisicao){
        return new ResponseEntity<>(exhaustService.calculateExhaust(exaustaoRequisicao), HttpStatus.OK);
    }
    
}
