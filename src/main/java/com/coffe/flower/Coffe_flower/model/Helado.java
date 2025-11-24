package com.coffe.flower.Coffe_flower.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "helados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Helado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sabor;   // Ej: Chocolate, Vainilla, Oreo, Frutilla
    private Integer precio; // Costo extra si aplica para el milkshake
}
