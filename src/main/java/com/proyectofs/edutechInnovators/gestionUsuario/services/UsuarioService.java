package com.proyectofs.edutechInnovators.gestionUsuario.services;

import com.proyectofs.edutechInnovators.gestionUsuario.entity.Usuarios;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuarios> listarUsuarios();
    Optional<Usuarios> obtenerUsuarioPorId(Long id);
    Usuarios crearUsuario(Usuarios usuario);
    Optional<Usuarios> actualizarUsuario(Long id, Usuarios usuario);
    boolean eliminarUsuario(Long id);
}
