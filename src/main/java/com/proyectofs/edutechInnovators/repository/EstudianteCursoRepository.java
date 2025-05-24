package com.proyectofs.edutechInnovators.repository;

import com.proyectofs.edutechInnovators.entity.EstudianteCurso;
import com.proyectofs.edutechInnovators.entity.EstudianteCursoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteCursoRepository extends JpaRepository<EstudianteCurso, EstudianteCursoId> {
}
