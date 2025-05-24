package com.proyectofs.edutechInnovators.services;

import com.proyectofs.edutechInnovators.entity.EstudianteCurso;

import java.util.List;

public interface EstudianteCursoService {
    EstudianteCurso inscribirEstudiante(EstudianteCurso estudianteCurso);
    List<EstudianteCurso> listarInscripciones();
}
