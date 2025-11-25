package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.Categoria;
import com.coffe.flower.Coffe_flower.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("http://localhost:5173")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Obtener todas las categorías
    @GetMapping
    public List<Categoria> getCategorias() {
        return categoriaService.findAll();
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public Categoria getCategoria(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    // Crear categoría
    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    // Editar categoría
    @PutMapping("/{id}")
    public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        return categoriaService.save(categoria);
    }

    // Eliminar categoría
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoriaService.delete(id);
    }
}
