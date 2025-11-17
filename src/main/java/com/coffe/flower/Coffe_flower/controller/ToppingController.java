package com.coffe.flower.Coffe_flower.controller;

import com.coffe.flower.Coffe_flower.model.Topping;
import com.coffe.flower.Coffe_flower.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/topping")
public class ToppingController {

    @Autowired
    private ToppingService toppingService;

    @GetMapping
    public List<Topping> getAll() {
        return toppingService.getAll();
    }

    @GetMapping("/{id}")
    public Topping getById(@PathVariable Long id) {
        return toppingService.getById(id);
    }

    @PostMapping
    public Topping create(@RequestBody Topping topping) {
        return toppingService.save(topping);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        toppingService.delete(id);
    }
}
