package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.Categoria;
import java.util.List;

public interface CategoriaService {

    List<Categoria> findAll();

    Categoria findById(Long id);

    Categoria save(Categoria categoria);

    void delete(Long id);
}
