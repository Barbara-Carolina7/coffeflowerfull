package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.Rol;
import com.coffe.flower.Coffe_flower.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    public Optional<Rol> obtenerPorId(Long id) {
        return rolRepository.findById(id);
    }

    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    public Optional<Rol> actualizar(Long id, Rol datos) {
        return rolRepository.findById(id).map(rol -> {
            rol.setNombre(datos.getNombre());
            return rolRepository.save(rol);
        });
    }

    public void eliminar(Long id) {
        rolRepository.deleteById(id);
    }
}

