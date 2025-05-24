package com.proyectofs.edutechInnovators.estudianteCurso.controller;

import com.proyectofs.edutechInnovators.estudianteCurso.entity.EstudianteCurso;
import com.proyectofs.edutechInnovators.estudianteCurso.services.EstudianteCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes-cursos")
public class EstudCursController {

    @Autowired
    private EstudianteCursoService service;

    @PostMapping
    public ResponseEntity<EstudianteCurso> inscribir(@RequestBody EstudianteCurso ec) {
        return new ResponseEntity<>(service.inscribirEstudiante(ec), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EstudianteCurso>> listar() {
        return ResponseEntity.ok(service.listarInscripciones());
    }
}

