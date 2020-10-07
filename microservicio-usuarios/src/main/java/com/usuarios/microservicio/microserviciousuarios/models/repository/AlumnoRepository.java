package com.usuarios.microservicio.microserviciousuarios.models.repository;

import com.usuarios.microservicio.microserviciousuarios.models.Alumno;

import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
    
}
