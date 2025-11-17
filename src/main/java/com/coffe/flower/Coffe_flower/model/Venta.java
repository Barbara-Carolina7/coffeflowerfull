package com.coffe.flower.Coffe_flower.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Usuario que realiza la compra
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Estado de la venta (pendiente, pagada, entregada, etc.)
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    // Método de pago usado
    @ManyToOne
    @JoinColumn(name = "metodo_pago_id")
    private MetodoPago metodoPago;

    private Double total;

    private LocalDateTime fecha = LocalDateTime.now();

    public Venta() {}

    public Venta(Usuario usuario, Estado estado, MetodoPago metodoPago, Double total) {
        this.usuario = usuario;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.total = total;
        this.fecha = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
