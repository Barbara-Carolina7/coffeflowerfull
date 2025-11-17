package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.Etiqueta;
import com.coffe.flower.Coffe_flower.service.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/etiqueta")
public class EtiquetaController {

    @Autowired
    private EtiquetaService etiquetaService;

    @GetMapping
    public List<Etiqueta> getAll() {
        return etiquetaService.getAll();
    }

    @GetMapping("/{id}")
    public Etiqueta getById(@PathVariable Long id) {
        return etiquetaService.getById(id);
    }

    @PostMapping
    public Etiqueta create(@RequestBody Etiqueta etiqueta) {
        return etiquetaService.save(etiqueta);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        etiquetaService.delete(id);
    }
}
