package com.proyectofs.edutechInnovators.estudianteCurso.services;

import com.proyectofs.edutechInnovators.gestionCursos.entity.Curso;
import com.proyectofs.edutechInnovators.estudianteCurso.entity.EstudianteCurso;
import com.proyectofs.edutechInnovators.gestionUsuario.entity.Usuarios;
import com.proyectofs.edutechInnovators.gestionCursos.repository.CursoRepository;
import com.proyectofs.edutechInnovators.estudianteCurso.repository.EstudianteCursoRepository;
import com.proyectofs.edutechInnovators.gestionUsuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstudianteCursoServiceImpl implements EstudianteCursoService {

    @Autowired
    private EstudianteCursoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    @Transactional
    public EstudianteCurso inscribirEstudiante(EstudianteCurso estudianteCurso) {
        if (estudianteCurso == null || estudianteCurso.getId() == null) {
            throw new IllegalArgumentException("El objeto de inscripción no puede ser nulo.");
        }

        Long idUsuario = estudianteCurso.getId().getIdUsuario();
        Long idCurso = estudianteCurso.getId().getIdCurso();

        if (idUsuario == null || idCurso == null) {
            throw new IllegalArgumentException("ID de usuario y curso son obligatorios.");
        }

        Usuarios usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + idUsuario));

        Curso curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + idCurso));

        estudianteCurso.setUsuario(usuario);
        estudianteCurso.setCurso(curso);

        return repository.save(estudianteCurso);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EstudianteCurso> listarInscripciones() {
        return repository.findAll();
    }
}
