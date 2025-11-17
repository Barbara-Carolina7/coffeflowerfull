package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.Endulzante;
import com.coffe.flower.Coffe_flower.repository.EndulzanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EndulzanteService {

    private final EndulzanteRepository endulzanteRepository;

    public EndulzanteService(EndulzanteRepository endulzanteRepository) {
        this.endulzanteRepository = endulzanteRepository;
    }

    public List<Endulzante> listar() {
        return endulzanteRepository.findAll();
    }

    public Optional<Endulzante> obtenerPorId(Long id) {
        return endulzanteRepository.findById(id);
    }

    public Endulzante guardar(Endulzante endulzante) {
        return endulzanteRepository.save(endulzante);
    }

    public Optional<Endulzante> actualizar(Long id, Endulzante datos) {
        return endulzanteRepository.findById(id).map(endulzante -> {
            endulzante.setNombre(datos.getNombre());
            endulzante.setNivel(datos.getNivel());
            return endulzanteRepository.save(endulzante);
        });
    }

    public void eliminar(Long id) {
        endulzanteRepository.deleteById(id);
    }
}
