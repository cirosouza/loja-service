package org.javaexercises.lojaservice.controller;

import org.javaexercises.lojaservice.exception.ResourceNotFoundException;
import org.javaexercises.lojaservice.model.Loja;
import org.javaexercises.lojaservice.payload.DetailPayload;
import org.javaexercises.lojaservice.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/lojas")
public class LojaController {

    @Autowired
    private LojaService lojaService;

    @GetMapping
    public ResponseEntity<List<Loja>> getAll() {
        List<Loja> lojas = lojaService.getAll();
        return ResponseEntity.ok().body(lojas);
    }

    @PostMapping
    public ResponseEntity<Loja> create(@RequestBody Loja loja) {
        Loja novoLoja = lojaService.save(loja);
        return ResponseEntity.ok().body(novoLoja);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            Optional<Loja> loja = lojaService.getById(id);
            return ResponseEntity.ok().body(loja);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DetailPayload(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Loja loja, @PathVariable Long id) {
        try {
            Loja updatedLoja = lojaService.update(id, loja);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedLoja);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DetailPayload(ex.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            lojaService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(new DetailPayload("Deletado com sucesso: Loja " + id));
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DetailPayload(ex.getMessage()));
        }
    }

}
