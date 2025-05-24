package com.proyectofs.edutechInnovators.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "ROL")
@Getter
@Setter
public class Rol {

    @Id
    @Column(name = "ID_ROL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPCION")  // Si mantienes findByNombre(), puedes cambiar esto a name="NOMBRE" en la DB
    private String nombre;

    @ManyToMany(mappedBy = "roles")
    private Set<Usuarios> usuarios;
}