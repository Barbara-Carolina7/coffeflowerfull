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

    @GetMapping("/ping")
    public String ping() {
        return "API PRODUCTOS OK";
    }

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
}
