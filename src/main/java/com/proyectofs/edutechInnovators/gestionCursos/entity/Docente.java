package com.proyectofs.edutechInnovators.gestionCursos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "DOCENTE", schema = "BDEDUTECH")
@Getter
@Setter
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "docente_seq_gen")
    @SequenceGenerator(name = "docente_seq_gen", sequenceName = "SEQ_DOCENTE", allocationSize = 1)
    @Column(name = "ID_DOCENTE")
    private Long id;

    @Column(name = "NOMBRE_DOCENTE")
    private String nombreDocente;
}
