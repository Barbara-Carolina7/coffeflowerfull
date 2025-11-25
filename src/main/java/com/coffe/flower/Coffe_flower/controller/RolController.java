package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.Rol;
import com.coffe.flower.Coffe_flower.service.RolService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    // Obtener todos los roles
    @GetMapping
    public ResponseEntity<List<Rol>> getAllRoles() {
        return ResponseEntity.ok(rolService.getAllRoles());
    }

    // Obtener un rol por ID
    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Long id) {
        Rol rol = rolService.getRolById(id);
        if (rol == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(rol);
    }

    // Crear rol
    @PostMapping
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        return ResponseEntity.ok(rolService.createRol(rol));
    }

    // Actualizar rol
    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable Long id, @RequestBody Rol datos) {
        Rol actualizado = rolService.updateRol(id, datos);
        if (actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar rol
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id) {
        rolService.deleteRol(id);
        return ResponseEntity.noContent().build();
    }
}
