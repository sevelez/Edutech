package com.proyectofs.edutechInnovators.estudianteCurso.services;

import com.proyectofs.edutechInnovators.estudianteCurso.entity.EstudianteCurso;

import java.util.List;

public interface EstudianteCursoService {
    EstudianteCurso inscribirEstudiante(EstudianteCurso estudianteCurso);
    List<EstudianteCurso> listarInscripciones();
}
