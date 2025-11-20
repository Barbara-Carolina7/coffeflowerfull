package com.coffe.flower.Coffe_flower.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import java.util.List;

@Entity
@Table(name = "productos")
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

    public Producto() {}

    // GETTERS y SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getPrecioBase() { return precioBase; }
    public void setPrecioBase(Double precioBase) { this.precioBase = precioBase; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public TipoDeLeche getTipoLeche() { return tipoLeche; }
    public void setTipoLeche(TipoDeLeche tipoLeche) { this.tipoLeche = tipoLeche; }

    public TipoGrano getTipoGrano() { return tipoGrano; }
    public void setTipoGrano(TipoGrano tipoGrano) { this.tipoGrano = tipoGrano; }

    public TipoBebida getTipoBebida() { return tipoBebida; }
    public void setTipoBebida(TipoBebida tipoBebida) { this.tipoBebida = tipoBebida; }

    public Tamano getTamano() { return tamano; }
    public void setTamano(Tamano tamano) { this.tamano = tamano; }

    public Temperatura getTemperatura() { return temperatura; }
    public void setTemperatura(Temperatura temperatura) { this.temperatura = temperatura; }

    public Endulzante getEndulzante() { return endulzante; }
    public void setEndulzante(Endulzante endulzante) { this.endulzante = endulzante; }

    public Helado getHelado() { return helado; }
    public void setHelado(Helado helado) { this.helado = helado; }

    public List<Etiqueta> getEtiquetas() { return etiquetas; }
    public void setEtiquetas(List<Etiqueta> etiquetas) { this.etiquetas = etiquetas; }

    public List<Topping> getToppings() { return toppings; }
    public void setToppings(List<Topping> toppings) { this.toppings = toppings; }
}
