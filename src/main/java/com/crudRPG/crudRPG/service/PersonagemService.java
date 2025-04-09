package com.crudRPG.crudRPG.service;

import com.crudRPG.crudRPG.entities.Personagem;
import com.crudRPG.crudRPG.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public ResponseEntity<Personagem>


}

