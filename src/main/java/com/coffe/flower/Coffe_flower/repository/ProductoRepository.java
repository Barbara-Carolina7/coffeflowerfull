package com.coffe.flower.Coffe_flower.repository;

import com.coffe.flower.Coffe_flower.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Filtrado por categoría (ignore case)
    List<Producto> findByCategoriaNombreIgnoreCase(String nombreCategoria);

    // Filtrado por múltiples atributos (Spring Data JPA soporta combinaciones)
    List<Producto> findByCategoriaNombreIgnoreCaseAndTipoLecheNombreIgnoreCaseAndTamanoNombreIgnoreCase(
            String categoria, String tipoLeche, String tamano
    );

    // Puedes agregar más combinaciones según necesites
}
