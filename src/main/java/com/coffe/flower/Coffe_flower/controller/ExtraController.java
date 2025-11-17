package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.Extra;
import com.coffe.flower.Coffe_flower.service.ExtraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/extras")
public class ExtraController {

    private final ExtraService extraService;

    public ExtraController(ExtraService extraService) {
        this.extraService = extraService;
    }

    @GetMapping
    public List<Extra> listar() {
        return extraService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Extra> obtener(@PathVariable Long id) {
        return extraService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Extra guardar(@RequestBody Extra extra) {
        return extraService.guardar(extra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Extra> actualizar(@PathVariable Long id, @RequestBody Extra datos) {
        return extraService.actualizar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        extraService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

