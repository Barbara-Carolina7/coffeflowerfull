package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.TipoBebida;
import com.coffe.flower.Coffe_flower.service.TipoBebidaService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipos-bebida")
public class TipoBebidaController {

    private final TipoBebidaService tipoBebidaService;

    public TipoBebidaController(TipoBebidaService tipoBebidaService) {
        this.tipoBebidaService = tipoBebidaService;
    }

    @GetMapping
    public List<TipoBebida> listar() {
        return tipoBebidaService.listar();
    }

    @GetMapping("/{id}")
    public Optional<TipoBebida> obtener(@PathVariable Long id) {
        return tipoBebidaService.obtenerPorId(id);
    }

    @PostMapping
    public TipoBebida crear(@RequestBody TipoBebida tipo) {
        return tipoBebidaService.guardar(tipo);
    }

    @PutMapping("/{id}")
    public Optional<TipoBebida> actualizar(@PathVariable Long id, @RequestBody TipoBebida tipo) {
        return tipoBebidaService.actualizar(id, tipo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        tipoBebidaService.eliminar(id);
    }
}
