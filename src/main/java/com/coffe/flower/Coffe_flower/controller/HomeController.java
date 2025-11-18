package com.coffe.flower.Coffe_flower.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/api/bienvenido")
    public String bienvenido() {
        return "Bienvenido a la cafetería Coffe Flower";
    }
}
