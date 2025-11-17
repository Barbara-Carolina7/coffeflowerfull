package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.Tamano;
import com.coffe.flower.Coffe_flower.repository.TamanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TamanoService {

    @Autowired
    private TamanoRepository tamanoRepository;

    public List<Tamano> getAll() {
        return tamanoRepository.findAll();
    }

    public Tamano getById(Long id) {
        return tamanoRepository.findById(id).orElse(null);
    }

    public Tamano save(Tamano tamano) {
        return tamanoRepository.save(tamano);
    }

    public void delete(Long id) {
        tamanoRepository.deleteById(id);
    }
}

