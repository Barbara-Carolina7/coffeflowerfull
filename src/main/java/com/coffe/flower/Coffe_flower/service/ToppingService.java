package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.Topping;
import com.coffe.flower.Coffe_flower.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ToppingService {

    @Autowired
    private ToppingRepository toppingRepository;

    public List<Topping> getAll() {
        return toppingRepository.findAll();
    }

    public Topping getById(Long id) {
        return toppingRepository.findById(id).orElse(null);
    }

    public Topping save(Topping topping) {
        return toppingRepository.save(topping);
    }

    public void delete(Long id) {
        toppingRepository.deleteById(id);
    }
}

