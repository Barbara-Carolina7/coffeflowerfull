package com.coffe.flower.Coffe_flower.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String descripción;

    public long getId(){ return id; }
    public void setId(Long id ){ this.id = id; }

    public long getNombre(){ return nombre; }
    public void setNombre(String nombre ){ this.nombre = nombre; }

    public long getDescripción(){ return descripción; }
    public void setDescripción(String descripción ){ this.descripción = descripción; }



}
