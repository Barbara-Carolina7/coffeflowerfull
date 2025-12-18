package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.Producto;
import com.coffe.flower.Coffe_flower.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // 🔥 ENDPOINT DE PRUEBA
    @GetMapping("/ping")
    public String ping() {
        return "API PRODUCTOS OK";
    }

    // LISTAR PRODUCTOS (opcional por categoría)
    @GetMapping
    public List<Producto> listar(
            @RequestParam(required = false) String categoria
    ) {
        return productoService.listar(categoria);
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
    public Optional<Producto> actualizar(
            @PathVariable Long id,
            @RequestBody Producto producto
    ) {
        return productoService.actualizar(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
    }
}
