package com.crudRPG.crudRPG.controller;

import com.crudRPG.crudRPG.entities.Personagem;
import com.crudRPG.crudRPG.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @PostMapping("/")
    public ResponseEntity(Personagem) creaPersonagem(@RequestBody Personagem personagem){
        return personagemService,createProduto(personagem);

    }


}
