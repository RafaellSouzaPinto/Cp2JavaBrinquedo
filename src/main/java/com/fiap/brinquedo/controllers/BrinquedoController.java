package com.fiap.brinquedo.controllers;

import com.fiap.brinquedo.entities.Brinquedo;
import com.fiap.brinquedo.repositories.BrinquedoRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoRepository repository;

    @PostMapping
    public ResponseEntity<Brinquedo> criar(@Valid @RequestBody Brinquedo brinquedo) {
        return ResponseEntity.ok(repository.save(brinquedo));
    }

    @GetMapping
    public ResponseEntity<List<Brinquedo>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brinquedo> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Brinquedo>> buscarPorTipo(@PathVariable String tipo) {
        List<Brinquedo> brinquedos = repository.findAll()
                .stream()
                .filter(brinquedo -> brinquedo.getTipo() != null && brinquedo.getTipo().equalsIgnoreCase(tipo))
                .toList();
        return ResponseEntity.ok(brinquedos);
    }
}
