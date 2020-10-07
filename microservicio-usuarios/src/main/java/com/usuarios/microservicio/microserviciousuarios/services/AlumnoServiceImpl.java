package com.usuarios.microservicio.microserviciousuarios.services;

import java.util.Optional;

import com.usuarios.microservicio.microserviciousuarios.models.Alumno;
import com.usuarios.microservicio.microserviciousuarios.models.repository.AlumnoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Alumno> findAll() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Alumno> findById(Long id) {
        // TODO Auto-generated method stub
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Alumno save(Alumno alumno) {
        // TODO Auto-generated method stub
        return repository.save(alumno);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }
}
