package com.proyectofs.edutechInnovators.estudianteCurso.repository;

import com.proyectofs.edutechInnovators.estudianteCurso.entity.EstudianteCurso;
import com.proyectofs.edutechInnovators.estudianteCurso.entity.EstudianteCursoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteCursoRepository extends JpaRepository<EstudianteCurso, EstudianteCursoId> {
}
