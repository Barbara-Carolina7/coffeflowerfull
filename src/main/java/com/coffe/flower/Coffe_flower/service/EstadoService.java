package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.Estado;
import com.coffe.flower.Coffe_flower.repository.EstadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    private final EstadoRepository estadoRepository;

    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public List<Estado> listar() {
        return estadoRepository.findAll();
    }

    public Optional<Estado> obtenerPorId(Long id) {
        return estadoRepository.findById(id);
    }

    public Estado guardar(Estado estado) {
        return estadoRepository.save(estado);
    }

    public Optional<Estado> actualizar(Long id, Estado datos) {
        return estadoRepository.findById(id).map(est -> {
            est.setNombre(datos.getNombre());
            return estadoRepository.save(est);
        });
    }

    public void eliminar(Long id) {
        estadoRepository.deleteById(id);
    }
}
