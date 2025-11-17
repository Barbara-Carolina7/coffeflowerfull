package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.Tipo;
import com.coffe.flower.Coffe_flower.repository.TipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoService {

    private final TipoRepository tipoRepository;

    public TipoService(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    public List<Tipo> listar() {
        return tipoRepository.findAll();
    }

    public Optional<Tipo> obtenerPorId(Long id) {
        return tipoRepository.findById(id);
    }

    public Tipo guardar(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    public Optional<Tipo> actualizar(Long id, Tipo datos) {
        return tipoRepository.findById(id).map(tipo -> {
            tipo.setNombre(datos.getNombre());
            return tipoRepository.save(tipo);
        });
    }

    public void eliminar(Long id) {
        tipoRepository.deleteById(id);
    }
}
