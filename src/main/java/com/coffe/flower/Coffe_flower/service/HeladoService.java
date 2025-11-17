package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.Helado;
import com.coffe.flower.Coffe_flower.repository.HeladoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeladoService {

    private final HeladoRepository heladoRepository;

    public HeladoService(HeladoRepository heladoRepository) {
        this.heladoRepository = heladoRepository;
    }

    public List<Helado> listar() {
        return heladoRepository.findAll();
    }

    public Optional<Helado> obtenerPorId(Long id) {
        return heladoRepository.findById(id);
    }

    public Helado guardar(Helado helado) {
        return heladoRepository.save(helado);
    }

    public Optional<Helado> actualizar(Long id, Helado datos) {
        return heladoRepository.findById(id).map(helado -> {
            helado.setSabor(datos.getSabor());
            helado.setPrecio(datos.getPrecio());
            return heladoRepository.save(helado);
        });
    }

    public void eliminar(Long id) {
        heladoRepository.deleteById(id);
    }
}
