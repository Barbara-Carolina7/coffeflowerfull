package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.TipoBebida;
import com.coffe.flower.Coffe_flower.repository.TipoBebidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoBebidaService {

    private final TipoBebidaRepository tipoBebidaRepository;

    public TipoBebidaService(TipoBebidaRepository tipoBebidaRepository) {
        this.tipoBebidaRepository = tipoBebidaRepository;
    }

    public List<TipoBebida> listar() {
        return tipoBebidaRepository.findAll();
    }

    public Optional<TipoBebida> obtenerPorId(Long id) {
        return tipoBebidaRepository.findById(id);
    }

    public TipoBebida guardar(TipoBebida tipo) {
        return tipoBebidaRepository.save(tipo);
    }

    public Optional<TipoBebida> actualizar(Long id, TipoBebida datos) {
        return tipoBebidaRepository.findById(id).map(tipo -> {
            tipo.setNombre(datos.getNombre());
            return tipoBebidaRepository.save(tipo);
        });
    }

    public void eliminar(Long id) {
        tipoBebidaRepository.deleteById(id);
    }
}
