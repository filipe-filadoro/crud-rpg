package com.crudRPG.crudRPG.service;

import com.crudRPG.crudRPG.entities.ItensMagicos;
import com.crudRPG.crudRPG.repository.ItensMagicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItensMagicosService {

    @Autowired
    private ItensMagicosRepository itensMagicosRepository;

    public ResponseEntity<ItensMagicos> creaItem(ItensMagicos item){
        ItensMagicos newItem = itensMagicosRepository.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
    }

    public ResponseEntity<List<ItensMagicos>> getAllItens(){
        List<ItensMagicos> allItens = itensMagicosRepository.findAll();
        return ResponseEntity.ok(allItens);
    }

    public ResponseEntity<Optional<ItensMagicos>> getItemById(Long id){
        Optional<ItensMagicos> getItemById = itensMagicosRepository.findById(id);
        return ResponseEntity.ok(getItemById);
    }

    public ResponseEntity<?> deleteItemById(Long id){
        itensMagicosRepository.deleteById(id);
        return ResponseEntity.ok("Deletado com sucesso");
    }

    public ResponseEntity<ItensMagicos> updateItemById(ItensMagicos updateItem, Long id){
        return itensMagicosRepository.findById(id).map(item -> {
            item.setNome(updateItem.getNome());
            item.setTipo(updateItem.getTipo());
            item.setForca(updateItem.getForca());
            item.setDefesa(updateItem.getDefesa());

            ItensMagicos updatedItem = itensMagicosRepository.save(item);
            return ResponseEntity.ok(updatedItem);
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}

