package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.TipoDeLeche;
import com.coffe.flower.Coffe_flower.service.TipoLecheService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-leche")
public class TipoDeLecheController {

    private final TipoLecheService tipoDeLecheService;

    public TipoDeLecheController(TipoLecheService tipoDeLecheService) {
        this.tipoDeLecheService = tipoDeLecheService;
    }

    @GetMapping
    public List<TipoDeLeche> listar() {
        return tipoDeLecheService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDeLeche> obtener(@PathVariable Long id) {
        return tipoDeLecheService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipoDeLeche guardar(@RequestBody TipoDeLeche tipo) {
        return tipoDeLecheService.guardar(tipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDeLeche> actualizar(@PathVariable Long id, @RequestBody TipoDeLeche datos) {
        return tipoDeLecheService.actualizar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tipoDeLecheService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

