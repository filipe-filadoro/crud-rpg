package com.crudRPG.crudRPG.service;

import com.crudRPG.crudRPG.entities.Personagem;
import com.crudRPG.crudRPG.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

//    public ResponseEntity<Personagem> creaPersonagem(Personagem personagem){
//        Personagem newPersonagem = personagemRepository.save(personagem);
//        return ResponseEntity.status(HttpStatus.CREATED).body(newPersonagem);
//    }

    public ResponseEntity<Personagem> creaPersonagem(Personagem personagem) {
        int total = personagem.getForca() + personagem.getDefesa();
        if (total > 10) {
            return ResponseEntity.badRequest().body(null);
        }

        Personagem newPersonagem = personagemRepository.save(personagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPersonagem);
    }


    public ResponseEntity<List<Personagem>> getAllPersonagem(){
        List<Personagem> allPersonagem = personagemRepository.findAll();
        return ResponseEntity.ok(allPersonagem);
    }

    public ResponseEntity<Optional<Personagem>> getPersonagemById(Long id){
        Optional<Personagem> getPersonagemById = personagemRepository.findById(id);
        return ResponseEntity.ok(getPersonagemById);
    }

    public ResponseEntity<?> deletePersonagemById(Long id){
        personagemRepository.deleteById(id);
        return ResponseEntity.ok("Deletado com sucesso");
    }

    public ResponseEntity<Personagem> updatePersonagemById(Personagem updatePersonagem, Long id) {
        return personagemRepository.findById(id).map(personagem -> {
            // Atualizando os campos do personagem
            personagem.setNome(updatePersonagem.getNome());
            personagem.setNomeAventureiro(updatePersonagem.getNomeAventureiro());
            personagem.setClasse(updatePersonagem.getClasse());
            personagem.setLevel(updatePersonagem.getLevel());
            personagem.setForca(updatePersonagem.getForca());
            personagem.setDefesa(updatePersonagem.getDefesa());

            // Salvando o personagem atualizado
            Personagem updatedPersonagem = personagemRepository.save(personagem);
            return ResponseEntity.ok(updatedPersonagem);
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }




}


