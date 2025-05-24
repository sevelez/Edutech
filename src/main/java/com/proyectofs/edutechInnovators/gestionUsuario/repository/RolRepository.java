package com.proyectofs.edutechInnovators.gestionUsuario.repository;

import com.proyectofs.edutechInnovators.gestionUsuario.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Rol findByNombre(String nombre);
}
