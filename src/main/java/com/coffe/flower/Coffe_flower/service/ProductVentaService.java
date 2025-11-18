package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.ProductVenta;
import com.coffe.flower.Coffe_flower.repository.ProductVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductVentaService {

    @Autowired
    private ProductVentaRepository productoVentaRepository;

    // Guardar ProductVenta calculando precio
    public ProductVenta saveProductoVenta(ProductVenta productoVenta) {
        double precioFinal = 0.0;
        // aquí iría el cálculo de precio que ya tienes...
        // precioFinal += ...
        productoVenta.setPrecioUnitario(precioFinal);
        return productoVentaRepository.save(productoVenta);
    }

    // Obtener todos los ProductVenta
    public List<ProductVenta> getAll() {
        return productoVentaRepository.findAll();
    }

    // Obtener ProductVenta por id
    public Optional<ProductVenta> getById(Long id) {
        return productoVentaRepository.findById(id);
    }

    // Eliminar ProductVenta por id
    public void delete(Long id) {
        productoVentaRepository.deleteById(id);
    }
}
