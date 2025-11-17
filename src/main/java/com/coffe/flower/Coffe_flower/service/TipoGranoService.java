package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.TipoGrano;
import com.coffe.flower.Coffe_flower.repository.TipoGranoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoGranoService {

    @Autowired
    private TipoGranoRepository tipoGranoRepository;

    public List<TipoGrano> getAll() {
        return tipoGranoRepository.findAll();
    }

    public TipoGrano getById(Long id) {
        return tipoGranoRepository.findById(id).orElse(null);
    }

    public TipoGrano save(TipoGrano tipoGrano) {
        return tipoGranoRepository.save(tipoGrano);
    }

    public void delete(Long id) {
        tipoGranoRepository.deleteById(id);
    }
}
