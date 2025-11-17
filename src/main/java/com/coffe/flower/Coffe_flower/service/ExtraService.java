package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.Extra;
import com.coffe.flower.Coffe_flower.repository.ExtraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExtraService {

    private final ExtraRepository extraRepository;

    public ExtraService(ExtraRepository extraRepository) {
        this.extraRepository = extraRepository;
    }

    public List<Extra> listar() {
        return extraRepository.findAll();
    }

    public Optional<Extra> obtenerPorId(Long id) {
        return extraRepository.findById(id);
    }

    public Extra guardar(Extra extra) {
        return extraRepository.save(extra);
    }

    public Optional<Extra> actualizar(Long id, Extra datos) {
        return extraRepository.findById(id).map(extra -> {
            extra.setNombre(datos.getNombre());
            extra.setPrecio(datos.getPrecio());
            return extraRepository.save(extra);
        });
    }

    public void eliminar(Long id) {
        extraRepository.deleteById(id);
    }
}

