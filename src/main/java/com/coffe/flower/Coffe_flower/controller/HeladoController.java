package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.Helado;
import com.coffe.flower.Coffe_flower.service.HeladoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/helados")
public class HeladoController {

    private final HeladoService heladoService;

    public HeladoController(HeladoService heladoService) {
        this.heladoService = heladoService;
    }

    @GetMapping
    public List<Helado> listar() {
        return heladoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Helado> obtener(@PathVariable Long id) {
        return heladoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Helado guardar(@RequestBody Helado helado) {
        return heladoService.guardar(helado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Helado> actualizar(@PathVariable Long id, @RequestBody Helado datos) {
        return heladoService.actualizar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        heladoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

