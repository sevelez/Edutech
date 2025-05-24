package com.proyectofs.edutechInnovators.gestionUsuario.repository;

import com.proyectofs.edutechInnovators.gestionUsuario.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    Optional<Usuarios> findByCorreo(String correo);
}