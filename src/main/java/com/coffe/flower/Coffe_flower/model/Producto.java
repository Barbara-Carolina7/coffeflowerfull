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
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private Double precioBase;
    private int stock;

    // Relaciones ManyToOne
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "tipo_leche_id")
    private TipoDeLeche tipoLeche;

    @ManyToOne
    @JoinColumn(name = "tipo_grano_id")
    private TipoGrano tipoGrano;

    @ManyToOne
    @JoinColumn(name = "tipo_bebida_id")
    private TipoBebida tipoBebida;

    @ManyToOne
    @JoinColumn(name = "tamano_id")
    private Tamano tamano;

    @ManyToOne
    @JoinColumn(name = "temperatura_id")
    private Temperatura temperatura;

    @ManyToOne
    @JoinColumn(name = "endulzante_id")
    private Endulzante endulzante;

    @ManyToOne
    @JoinColumn(name = "helado_id")
    private Helado helado;

    // Relaciones ManyToMany
    @ManyToMany
    @JoinTable(
            name = "producto_etiqueta",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    )
    private List<Etiqueta> etiquetas;

    @ManyToMany
    @JoinTable(
            name = "producto_topping",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private List<Topping> toppings;
}
