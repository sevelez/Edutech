package com.proyectofs.edutechInnovators.gestionCursos.repository;

import com.proyectofs.edutechInnovators.gestionCursos.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
