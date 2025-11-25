package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.Extra;
import com.coffe.flower.Coffe_flower.service.ExtraService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/extras")
public class ExtraController {

    private final ExtraService extraService;

    public ExtraController(ExtraService extraService) {
        this.extraService = extraService;
    }

    @GetMapping
    public List<Extra> listar() {
        return extraService.getAll();  // ← corregido
    }

    @GetMapping("/{id}")
    public ResponseEntity<Extra> obtener(@PathVariable Long id) {
        Extra extra = extraService.getById(id);  // ← corregido
        if (extra == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(extra);
    }

    @PostMapping
    public Extra guardar(@RequestBody Extra extra) {
        return extraService.save(extra); // ← corregido
    }

    @PutMapping("/{id}")
    public ResponseEntity<Extra> actualizar(@PathVariable Long id, @RequestBody Extra datos) {
        Extra actualizado = extraService.update(id, datos); // ← corregido
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        extraService.delete(id); // ← corregido
        return ResponseEntity.noContent().build();
    }
}
