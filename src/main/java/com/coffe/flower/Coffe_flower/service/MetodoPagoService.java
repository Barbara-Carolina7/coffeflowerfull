package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.MetodoPago;
import com.coffe.flower.Coffe_flower.repository.MetodoPagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoService {

    private final MetodoPagoRepository metodoPagoRepository;

    public MetodoPagoService(MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
    }

    public List<MetodoPago> listar() {
        return metodoPagoRepository.findAll();
    }

    public Optional<MetodoPago> obtenerPorId(Long id) {
        return metodoPagoRepository.findById(id);
    }

    public MetodoPago guardar(MetodoPago metodo) {
        return metodoPagoRepository.save(metodo);
    }

    public Optional<MetodoPago> actualizar(Long id, MetodoPago datos) {
        return metodoPagoRepository.findById(id).map(m -> {
            m.setNombre(datos.getNombre());
            return metodoPagoRepository.save(m);
        });
    }

    public void eliminar(Long id) {
        metodoPagoRepository.deleteById(id);
    }
}
