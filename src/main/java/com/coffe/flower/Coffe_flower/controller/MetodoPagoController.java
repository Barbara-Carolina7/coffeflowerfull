package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.MetodoPago;
import com.coffe.flower.Coffe_flower.service.MetodoPagoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/metodos-pago")
public class MetodoPagoController {

    private final MetodoPagoService metodoPagoService;

    public MetodoPagoController(MetodoPagoService metodoPagoService) {
        this.metodoPagoService = metodoPagoService;
    }

    @GetMapping
    public List<MetodoPago> listar() {
        return metodoPagoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<MetodoPago> obtenerPorId(@PathVariable Long id) {
        return metodoPagoService.obtenerPorId(id);
    }

    @PostMapping
    public MetodoPago crear(@RequestBody MetodoPago metodo) {
        return metodoPagoService.guardar(metodo);
    }

    @PutMapping("/{id}")
    public Optional<MetodoPago> actualizar(@PathVariable Long id, @RequestBody MetodoPago metodo) {
        return metodoPagoService.actualizar(id, metodo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        metodoPagoService.eliminar(id);
    }
}
