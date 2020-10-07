package com.usuarios.microservicio.microserviciousuarios.services;

import java.util.Optional;

import com.usuarios.microservicio.microserviciousuarios.models.Alumno;

public interface AlumnoService {
    public Iterable<Alumno> findAll();

    public Optional<Alumno> findById(Long id);

    public Alumno save(Alumno alumno);

    public void deleteById(Long id);
}
