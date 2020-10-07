package com.usuarios.microservicio.microserviciousuarios.controllers;

import java.util.Optional;

import com.usuarios.microservicio.microserviciousuarios.models.Alumno;
import com.usuarios.microservicio.microserviciousuarios.services.AlumnoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class AlumnoController {
    @Autowired
    private AlumnoService service;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {
        Optional<Alumno> o = service.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(o.get());
    }

    @PostMapping(value = "{id}")
    public ResponseEntity<?> crear(@RequestBody Alumno alumno) {
        // TODO: process POST request
        Alumno alumnoResponse = service.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoResponse);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Alumno alumno) {
        // TODO: process PUT request
        Optional<Alumno> o = service.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Alumno alumnoResponse = o.get();
        alumnoResponse.setNombre(alumno.getNombre());
        alumnoResponse.setApellido(alumno.getApellido());
        alumnoResponse.setEmail(alumno.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
