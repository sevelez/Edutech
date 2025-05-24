package com.proyectofs.edutechInnovators.gestionCursos.repository;

import com.proyectofs.edutechInnovators.gestionCursos.entity.SeccionDocente;
import com.proyectofs.edutechInnovators.gestionCursos.entity.SeccionDocenteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeccionDocenteRepository extends JpaRepository<SeccionDocente, SeccionDocenteId> {

    // 🔧 Este método debe declararse explícitamente
    boolean existsBySeccionIdAndDocenteId(Long seccionId, Long docenteId);
}

