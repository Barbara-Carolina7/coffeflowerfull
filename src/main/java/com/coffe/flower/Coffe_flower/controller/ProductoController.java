package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.Producto;
import com.coffe.flower.Coffe_flower.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
// CORS actualizado: localhost y front de Vercel
@CrossOrigin(origins = {"http://localhost:5173", "https://coffee-flower-front-99gp.vercel.app"})
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Listar productos con query params opcionales
    @GetMapping
    public List<Producto> listar(
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String tipoLeche,
            @RequestParam(required = false) String tamano
    ) {
        if (categoria != null && tipoLeche != null && tamano != null) {
            return productoService.listarFiltros(categoria, tipoLeche, tamano);
        }
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
    public Optional<Producto> actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        return productoService.actualizar(id, producto);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return "Producto eliminado correctamente";
    }
}
