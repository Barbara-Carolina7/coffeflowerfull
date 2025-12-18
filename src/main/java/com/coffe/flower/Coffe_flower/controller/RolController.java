package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.Rol;
import com.coffe.flower.Coffe_flower.service.RolService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/roles") // <-- La ruta base es /api/roles
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    // Obtener todos los roles
    @GetMapping // Mapea a: GET /api/roles
    public ResponseEntity<List<Rol>> getAllRoles() {
        return ResponseEntity.ok(rolService.getAllRoles());
    }

    // Obtener un rol por ID
    @GetMapping("/{id}") // Mapea a: GET /api/roles/{id}
    public ResponseEntity<Rol> getRolById(@PathVariable Long id) {
        Rol rol = rolService.getRolById(id);
        if (rol == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(rol);
    }

    // Crear rol (¡El que necesitas para llenar la DB!)
    @PostMapping // Mapea a: POST /api/roles
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        // Mejor práctica: Devolver 201 Created si la entidad se crea con éxito
        return ResponseEntity.ok(rolService.createRol(rol));
    }

    // Actualizar rol
    @PutMapping("/{id}") // Mapea a: PUT /api/roles/{id}
    public ResponseEntity<Rol> updateRol(@PathVariable Long id, @RequestBody Rol datos) {
        Rol actualizado = rolService.updateRol(id, datos);
        if (actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar rol
    @DeleteMapping("/{id}") // Mapea a: DELETE /api/roles/{id}
    public ResponseEntity<Void> deleteRol(@PathVariable Long id) {
        rolService.deleteRol(id);
        return ResponseEntity.noContent().build();
    }
}