package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.Rol;
import com.coffe.flower.Coffe_flower.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    // Obtener todos
    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

    // Obtener por ID
    public Rol getRolById(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    // Crear
    public Rol createRol(Rol rol) {
        return rolRepository.save(rol);
    }

    // Actualizar
    public Rol updateRol(Long id, Rol datos) {
        return rolRepository.findById(id).map(rol -> {
            rol.setNombre(datos.getNombre());
            return rolRepository.save(rol);
        }).orElse(null);
    }

    // Eliminar
    public void deleteRol(Long id) {
        rolRepository.deleteById(id);
    }
}
