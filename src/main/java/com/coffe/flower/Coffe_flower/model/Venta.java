package com.coffe.flower.Coffe_flower.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "ventas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    // Constructor con parámetros (sin Lombok)
    public Venta(Usuario usuario, Estado estado, MetodoPago metodoPago, Double total) {
        this.usuario = usuario;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.total = total;
        this.fecha = LocalDateTime.now(); // Fecha actual al crear la venta
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", usuario=" + (usuario != null ? usuario.getNombre() : "null") +
                ", estado=" + (estado != null ? estado.getNombre() : "null") +
                ", metodoPago=" + (metodoPago != null ? metodoPago.getNombre() : "null") +
                ", total=" + total +
                ", fecha=" + fecha +
                '}';
    }
}
