package com.crudRPG.crudRPG.controller;

import com.crudRPG.crudRPG.entities.Personagem;
import com.crudRPG.crudRPG.service.PersonagemService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @Operation(summary = "criar um novo personagem.")
    @PostMapping("/personagem")
    public ResponseEntity<Personagem> creaPersonagem(@RequestBody Personagem personagem) {
        return personagemService.creaPersonagem(personagem);
    }

    @Operation(summary = "lista todos os personagens.")
    @GetMapping("/lista-personagem")
    public ResponseEntity<List<Personagem>> getAllPersonagem() {
        return personagemService.getAllPersonagem();
    }

    @Operation(summary = "busca personagem por id.")
    @GetMapping("/personagem-list/{id}")  // Corrigido para usar {id} corretamente
    public ResponseEntity<Optional<Personagem>> getPersonagemById(Long id) {
        return personagemService.getPersonagemById(id);
    }

    @Operation(summary = "deleta personagem por id.")
    @DeleteMapping("/delete-id/{id}")  // Corrigido para usar {id} corretamente
    public ResponseEntity<?> deletePersonagemById(Long id) {
        return personagemService.deletePersonagemById(id);
    }

    @Operation(summary = "atualiza personagem por id.")
    @PutMapping("/update-id/{id}")
    public ResponseEntity<Personagem> updatePersonagem(Personagem personagem, Long id) {
        return personagemService.updatePersonagemById(personagem, id);
    }

}
