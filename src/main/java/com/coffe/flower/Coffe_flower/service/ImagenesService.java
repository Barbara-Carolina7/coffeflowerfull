package com.coffe.flower.Coffe_flower.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffe.flower.Coffe_flower.model.Imagenes;
import com.coffe.flower.Coffe_flower.repository.ImagenesRepository;

@Service
public class ImagenesService {

    @Autowired
    private ImagenesRepository imagenesRepository;

    public List<Imagenes> findAll() {
        return imagenesRepository.findAll();
    }

    public Imagenes findById(Long id) {   // <-- CAMBIO A LONG
        return imagenesRepository.findById(id).orElse(null);
    }

    public Imagenes save(Imagenes imagenes) {
        return imagenesRepository.save(imagenes);
    }

    public void deleteById(Long id) {     // <-- CAMBIO A LONG
        imagenesRepository.deleteById(id);
    }
}
