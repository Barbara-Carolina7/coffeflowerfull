package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.Producto;
import com.coffe.flower.Coffe_flower.service.ProductoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listar() {
        return productoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Producto> obtener(@PathVariable Long id) {
        return productoService.obtenerPorId(id);
    }

    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    @PutMapping("/{id}")
    public Optional<Producto> actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        return productoService.actualizar(id, producto);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return "Producto eliminado correctamente";
    }
}
