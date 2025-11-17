package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.Tamano;
import com.coffe.flower.Coffe_flower.service.TamanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tamano")
public class TamanoController {

    @Autowired
    private TamanoService tamanoService;

    @GetMapping
    public List<Tamano> getAll() {
        return tamanoService.getAll();
    }

    @GetMapping("/{id}")
    public Tamano getById(@PathVariable Long id) {
        return tamanoService.getById(id);
    }

    @PostMapping
    public Tamano create(@RequestBody Tamano tamano) {
        return tamanoService.save(tamano);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tamanoService.delete(id);
    }
}
