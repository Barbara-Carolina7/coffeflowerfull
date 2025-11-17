package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.Venta;
import com.coffe.flower.Coffe_flower.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public List<Venta> listar() {
        return ventaRepository.findAll();
    }

    public Optional<Venta> obtenerPorId(Long id) {
        return ventaRepository.findById(id);
    }

    public Venta guardar(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Optional<Venta> actualizar(Long id, Venta datos) {
        return ventaRepository.findById(id).map(v -> {
            v.setUsuario(datos.getUsuario());
            v.setEstado(datos.getEstado());
            v.setMetodoPago(datos.getMetodoPago());
            v.setTotal(datos.getTotal());
            v.setFecha(datos.getFecha());
            return ventaRepository.save(v);
        });
    }

    public void eliminar(Long id) {
        ventaRepository.deleteById(id);
    }
}
