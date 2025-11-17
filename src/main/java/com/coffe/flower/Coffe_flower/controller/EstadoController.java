package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.Estado;
import com.coffe.flower.Coffe_flower.service.EstadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping
    public List<Estado> listar() {
        return estadoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Estado> obtenerPorId(@PathVariable Long id) {
        return estadoService.obtenerPorId(id);
    }

    @PostMapping
    public Estado crear(@RequestBody Estado estado) {
        return estadoService.guardar(estado);
    }

    @PutMapping("/{id}")
    public Optional<Estado> actualizar(@PathVariable Long id, @RequestBody Estado estado) {
        return estadoService.actualizar(id, estado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        estadoService.eliminar(id);
    }
}
