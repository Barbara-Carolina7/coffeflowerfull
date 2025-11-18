package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.ProductVenta;
import com.coffe.flower.Coffe_flower.service.ProductVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product-ventas")
public class ProductVentaController {

    @Autowired
    private ProductVentaService productVentaService;

    // Obtener todos los ProductVenta
    @GetMapping
    public List<ProductVenta> getAllProductVentas() {
        return productVentaService.getAll();
    }

    // Obtener ProductVenta por id
    @GetMapping("/{id}")
    public ResponseEntity<ProductVenta> getProductVentaById(@PathVariable Long id) {
        Optional<ProductVenta> optional = productVentaService.getById(id);
        return optional.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo ProductVenta (POST)
    @PostMapping
    public ResponseEntity<ProductVenta> createProductVenta(@RequestBody ProductVenta productVenta) {
        ProductVenta saved = productVentaService.saveProductoVenta(productVenta);
        return ResponseEntity.ok(saved);
    }

    // Actualizar un ProductVenta existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<ProductVenta> updateProductVenta(@PathVariable Long id, @RequestBody ProductVenta productVenta) {
        Optional<ProductVenta> optional = productVentaService.getById(id);
        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        productVenta.setId(id); // actualizar mismo ID
        ProductVenta updated = productVentaService.saveProductoVenta(productVenta);
        return ResponseEntity.ok(updated);
    }

    // Eliminar un ProductVenta por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductVenta(@PathVariable Long id) {
        Optional<ProductVenta> optional = productVentaService.getById(id);
        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        productVentaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
