package com.proyectofs.edutechInnovators.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "ESTUDIANTES_CURSOS", schema = "BDEDUTECH")
@Getter
@Setter
public class EstudianteCurso {

    @EmbeddedId
    private EstudianteCursoId id;

    @Column(name = "FECHA_INSCRIPCION")
    private LocalDate fechaInscripcion;

    @Column(name = "PROGRESO")
    private Integer progreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUsuario")
    @JoinColumn(name = "ID_USUARIO")
    private Usuarios usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idCurso")
    @JoinColumn(name = "ID_CURSO")
    private Curso curso;
}