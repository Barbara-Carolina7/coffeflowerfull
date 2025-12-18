package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.TipoDeLeche;
import com.coffe.flower.Coffe_flower.repository.TipoLecheRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoLecheService {

    private final TipoLecheRepository tipoDeLecheRepository;

    public TipoLecheService(TipoLecheRepository tipoDeLecheRepository) {
        this.tipoDeLecheRepository = tipoDeLecheRepository;
    }

    // LISTAR
    public List<TipoDeLeche> listar() {
        return tipoDeLecheRepository.findAll();
    }

    // OBTENER POR ID
    public Optional<TipoDeLeche> obtenerPorId(Long id) {
        return tipoDeLecheRepository.findById(id);
    }

    // GUARDAR
    public TipoDeLeche guardar(TipoDeLeche tipo) {
        return tipoDeLecheRepository.save(tipo);
    }

    // ACTUALIZAR
    public Optional<TipoDeLeche> actualizar(Long id, TipoDeLeche datos) {
        return tipoDeLecheRepository.findById(id)
                .map(tipo -> {
                    tipo.setNombre(datos.getNombre());
                    return tipoDeLecheRepository.save(tipo);
                });
    }

    // ELIMINAR
    public void eliminar(Long id) {
        tipoDeLecheRepository.deleteById(id);
    }
}
