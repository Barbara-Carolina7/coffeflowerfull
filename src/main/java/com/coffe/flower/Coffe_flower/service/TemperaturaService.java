package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.Temperatura;
import com.coffe.flower.Coffe_flower.repository.TemperaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TemperaturaService {

    @Autowired
    private TemperaturaRepository temperaturaRepository;

    public List<Temperatura> getAll() {
        return temperaturaRepository.findAll();
    }

    public Temperatura getById(Long id) {
        return temperaturaRepository.findById(id).orElse(null);
    }

    public Temperatura save(Temperatura temperatura) {
        return temperaturaRepository.save(temperatura);
    }

    public void delete(Long id) {
        temperaturaRepository.deleteById(id);
    }
}

