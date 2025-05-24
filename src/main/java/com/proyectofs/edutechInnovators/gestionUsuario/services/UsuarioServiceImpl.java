package com.proyectofs.edutechInnovators.gestionUsuario.services;

import com.proyectofs.edutechInnovators.gestionCursos.entity.Docente;
import com.proyectofs.edutechInnovators.gestionUsuario.entity.Rol;
import com.proyectofs.edutechInnovators.gestionUsuario.entity.Usuarios;
import com.proyectofs.edutechInnovators.gestionCursos.repository.DocenteRepository;
import com.proyectofs.edutechInnovators.gestionUsuario.repository.RolRepository;
import com.proyectofs.edutechInnovators.gestionUsuario.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final DocenteRepository docenteRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                              RolRepository rolRepository,
                              DocenteRepository docenteRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.docenteRepository = docenteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuarios> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional
    public Usuarios crearUsuario(Usuarios usuario) {
        // Validar roles antes de persistir (usando ID del rol)
        Set<Rol> rolesValidados = usuario.getRoles().stream()
                .map(r -> rolRepository.findById(r.getId())
                        .orElseThrow(() -> new RuntimeException("Rol no encontrado: ID = " + r.getId())))
                .collect(Collectors.toSet());

        usuario.setRoles(rolesValidados);

        // Guardar usuario con roles existentes (solo se insertará en ROL_USUARIOS_FK)
        Usuarios guardado = usuarioRepository.save(usuario);

        if (rolesValidados.stream().anyMatch(r -> r.getNombre().equalsIgnoreCase("DOCENTE"))) {
            Docente nuevoDocente = new Docente();
            nuevoDocente.setNombreDocente(guardado.getNombre()); // solo el nombre, el ID será autogenerado
            docenteRepository.save(nuevoDocente);
        }
        return guardado;
    }

    @Override
    @Transactional
    public Optional<Usuarios> actualizarUsuario(Long id, Usuarios usuario) {
        return usuarioRepository.findById(id).map(existente -> {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        });
    }

    @Override
    @Transactional
    public boolean eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
