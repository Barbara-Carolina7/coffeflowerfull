package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.Endulzante;
import com.coffe.flower.Coffe_flower.service.EndulzanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endulzantes")
public class EndulzanteController {

    private final EndulzanteService endulzanteService;

    public EndulzanteController(EndulzanteService endulzanteService) {
        this.endulzanteService = endulzanteService;
    }

    @GetMapping
    public List<Endulzante> listar() {
        return endulzanteService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endulzante> obtener(@PathVariable Long id) {
        return endulzanteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Endulzante guardar(@RequestBody Endulzante endulzante) {
        return endulzanteService.guardar(endulzante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endulzante> actualizar(@PathVariable Long id, @RequestBody Endulzante datos) {
        return endulzanteService.actualizar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        endulzanteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

