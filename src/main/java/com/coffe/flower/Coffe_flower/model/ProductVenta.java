package com.coffe.flower.Coffe_flower.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Entity
@Table(name = "product_venta")
public class ProductVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;
    private double precioUnitario; // precio final calculado

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    // ✅ TAMANO
    @ManyToOne
    @JoinColumn(name = "tamano_id")
    private Tamano tamano;

    // TOPPINGS
    @ManyToMany
    private List<Topping> toppings;

    // EXTRAS
    @ManyToMany
    private List<Extra> extras;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;

    public ProductVenta() {}

    // -----------------
    // GETTERS y SETTERS
    // -----------------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    // ✅ TAMANO
    public Tamano getTamano() { return tamano; }
    public void setTamano(Tamano tamano) { this.tamano = tamano; }

    public List<Topping> getToppings() { return toppings; }
    public void setToppings(List<Topping> toppings) { this.toppings = toppings; }

    public List<Extra> getExtras() { return extras; }
    public void setExtras(List<Extra> extras) { this.extras = extras; }

    public Venta getVenta() { return venta; }
    public void setVenta(Venta venta) { this.venta = venta; }
}
