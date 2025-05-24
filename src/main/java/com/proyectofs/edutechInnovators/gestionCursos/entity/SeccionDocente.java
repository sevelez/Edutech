package com.proyectofs.edutechInnovators.gestionCursos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "SECCIONES_DOCENTE", schema = "BDEDUTECH")
@IdClass(SeccionDocenteId.class)
@Getter
@Setter
public class SeccionDocente {

    @Id
    @Column(name = "ID_SECCION")
    private Long seccionId;

    @Id
    @Column(name = "ID_DOCENTE")
    private Long docenteId;

    @Column(name = "FECHA_CONTRATO")
    private LocalDate fechaContrato;
}