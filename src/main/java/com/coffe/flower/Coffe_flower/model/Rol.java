package com.coffe.flower.Coffe_flower.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data  // Lombok genera getters, setters, toString(), equals() y hashCode() automáticamente
@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relación inversa: un rol puede tener varios usuarios
    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;

    // Lombok ya genera el constructor vacío y los getters/setters, así que no es necesario escribirlos manualmente
}
