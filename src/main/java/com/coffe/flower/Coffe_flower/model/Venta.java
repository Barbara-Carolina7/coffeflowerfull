package com.coffe.flower.Coffe_flower.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

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

    private Double total; // Total de la compra

    private LocalDateTime fecha; // Fecha de la venta

    // Constructor vacío
    public Venta() {}

    // Constructor con
