package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.Temperatura;
import com.coffe.flower.Coffe_flower.service.TemperaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/temperatura")
public class TemperaturaController {

    @Autowired
    private TemperaturaService temperaturaService;

    @GetMapping
    public List<Temperatura> getAll() {
        return temperaturaService.getAll();
    }

    @GetMapping("/{id}")
    public Temperatura getById(@PathVariable Long id) {
        return temperaturaService.getById(id);
    }

    @PostMapping
    public Temperatura create(@RequestBody Temperatura temperatura) {
        return temperaturaService.save(temperatura);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        temperaturaService.delete(id);
    }
}
