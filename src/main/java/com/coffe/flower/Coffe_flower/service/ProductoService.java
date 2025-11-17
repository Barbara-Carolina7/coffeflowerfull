package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.Producto;
import com.coffe.flower.Coffe_flower.repository.ProductoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save( producto);
    }

    public Optional<Producto> actualizar(Long id, Producto datos) {
        return productoRepository.findById(id).map(producto -> {
            producto.setNombre(datos.getNombre());
            producto.setDescripcion(datos.getDescripcion());
            producto.setPrecio(datos.getPrecio());
            producto.setStock(datos.getStock());
            return productoRepository.save(producto);
        });
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}
