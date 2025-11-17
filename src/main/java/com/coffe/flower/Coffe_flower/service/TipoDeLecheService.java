package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.TipoDeLeche;
import com.coffe.flower.Coffe_flower.repository.TipoDeLecheRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDeLecheService {

    private final TipoDeLecheRepository tipoDeLecheRepository;

    public TipoDeLecheService(TipoDeLecheRepository tipoDeLecheRepository) {
        this.tipoDeLecheRepository = tipoDeLecheRepository;
    }

    public List<TipoDeLeche> listar() {
        return tipoDeLecheRepository.findAll();
    }

    public Optional<TipoDeLeche> obtenerPorId(Long id) {
        return tipoDeLecheRepository.findById(id);
    }

    public TipoDeLeche guardar(TipoDeLeche tipo) {
        return tipoDeLecheRepository.save(tipo);
    }

    public Optional<TipoDeLeche> actualizar(Long id, TipoDeLeche datos) {
        return tipoDeLecheRepository.findById(id).map(tipo -> {
            tipo.setNombre(datos.getNombre());
            return tipoDeLecheRepository.save(tipo);
        });
    }

    public void eliminar(Long id) {
        tipoDeLecheRepository.deleteById(id);
    }
}
