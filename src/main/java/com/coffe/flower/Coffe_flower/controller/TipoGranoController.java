package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.TipoGrano;
import com.coffe.flower.Coffe_flower.service.TipoGranoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tipograno")
public class TipoGranoController {

    @Autowired
    private TipoGranoService tipoGranoService;

    @GetMapping
    public List<TipoGrano> getAll() {
        return tipoGranoService.getAll();
    }

    @GetMapping("/{id}")
    public TipoGrano getById(@PathVariable Long id) {
        return tipoGranoService.getById(id);
    }

    @PostMapping
    public TipoGrano create(@RequestBody TipoGrano tipoGrano) {
        return tipoGranoService.save(tipoGrano);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tipoGranoService.delete(id);
    }
}
