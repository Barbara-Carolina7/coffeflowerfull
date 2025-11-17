package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.Tipo;
import com.coffe.flower.Coffe_flower.service.TipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    private final TipoService tipoService;

    public TipoController(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    @GetMapping
    public List<Tipo> listar() {
        return tipoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipo> obtener(@PathVariable Long id) {
        return tipoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tipo guardar(@RequestBody Tipo tipo) {
        return tipoService.guardar(tipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tipo> actualizar(@PathVariable Long id, @RequestBody Tipo datos) {
        return tipoService.actualizar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tipoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
