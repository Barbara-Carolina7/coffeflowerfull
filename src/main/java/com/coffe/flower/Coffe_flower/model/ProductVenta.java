package com.coffe.flower.Coffe_flower.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity
@Table(name = "product_venta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;
    private double precioUnitario; // precio final calculado

    // Relaciones ManyToOne
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    // TAMANO
    @ManyToOne
    @JoinColumn(name = "tamano_id")
    private Tamano tamano;

    // TOPPINGS
    @ManyToMany
    @JoinTable(
            name = "product_venta_topping",
            joinColumns = @JoinColumn(name = "product_venta_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private List<Topping> toppings;
}
