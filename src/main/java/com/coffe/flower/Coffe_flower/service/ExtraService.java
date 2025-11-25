package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.Extra;
import com.coffe.flower.Coffe_flower.repository.ExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExtraService {

    @Autowired
    private ExtraRepository extraRepository;

    public List<Extra> getAll() {
        return extraRepository.findAll();
    }

    public Extra getById(Long id) {
        Optional<Extra> optionalExtra = extraRepository.findById(id);
        return optionalExtra.orElse(null);
    }

    public Extra save(Extra extra) {
        return extraRepository.save(extra);
    }

    public Extra update(Long id, Extra datos) {
        Optional<Extra> optionalExtra = extraRepository.findById(id);

        if (optionalExtra.isPresent()) {
            Extra extra = optionalExtra.get();
            extra.setNombre(datos.getNombre());
            extra.setPrecio(datos.getPrecio());
            return extraRepository.save(extra);
        }

        return null;
    }

    public void delete(Long id) {
        extraRepository.deleteById(id);
    }
}
