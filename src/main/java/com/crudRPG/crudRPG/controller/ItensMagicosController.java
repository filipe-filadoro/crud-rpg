package com.crudRPG.crudRPG.controller;

import com.crudRPG.crudRPG.entities.ItensMagicos;
import com.crudRPG.crudRPG.service.ItensMagicosService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItensMagicosController {

    @Autowired
    private ItensMagicosService itensMagicosService;

    @Operation(summary = "cria um novo item magico.")
    @PostMapping("/item-magico")
    public ResponseEntity<ItensMagicos> creaItem(ItensMagicos item) {
        return itensMagicosService.creaItem(item);
    }

    @Operation(summary = "lista todos os itens mágicos.")
    @GetMapping("/lista-item")
    public ResponseEntity<List<ItensMagicos>> getAllItens() {
        return itensMagicosService.getAllItens();
    }

    @Operation(summary = "lista item mágico por id.")
    @GetMapping("/itens-list/{id}")  // Corrigido para usar {id} corretamente
    public ResponseEntity<Optional<ItensMagicos>> getItemById(Long id) {
        return itensMagicosService.getItemById(id);
    }

    @Operation(summary = "deleta item mágico por id.")
    @DeleteMapping("/itens-delete/{id}")  // Corrigido para usar {id} corretamente
    public ResponseEntity<?> deleteItemById(Long id) {
        return itensMagicosService.deleteItemById(id);
    }

    @Operation(summary = "atualiza item mágico por id.")
    @PutMapping("/itens-update-id/{id}")  // Corrigido para usar {id} corretamente
    public ResponseEntity<ItensMagicos> updateItenMagico(ItensMagicos itensMagicos, Long id) {
        return itensMagicosService.updateItemById(itensMagicos, id);
    }
}
