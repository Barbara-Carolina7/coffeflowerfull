package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.Etiqueta;
import com.coffe.flower.Coffe_flower.repository.EtiquetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EtiquetaService {

    @Autowired
    private EtiquetaRepository etiquetaRepository;

    public List<Etiqueta> getAll() {
        return etiquetaRepository.findAll();
    }

    public Etiqueta getById(Long id) {
        return etiquetaRepository.findById(id).orElse(null);
    }

    public Etiqueta save(Etiqueta etiqueta) {
        return etiquetaRepository.save(etiqueta);
    }

    public void delete(Long id) {
        etiquetaRepository.deleteById(id);
    }
}
