package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Alumno;
import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.models.entities.Profesor;
import com.ibm.academia.apirest.repositories.AlumnoRepository;
import com.ibm.academia.apirest.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO
{
    @Autowired
    public ProfesorDAOImpl(@Qualifier("repositorioProfesores") PersonaRepository repository)
    {
        super(repository);
    }

    @Override
    @Transactional
    public Persona actualizar(Persona profesorEncontrado, Persona profesor)
    {
        Persona profesorActualizado = null;
        profesorEncontrado.setNombre(profesor.getNombre());
        profesorEncontrado.setApellido(profesor.getApellido());
        profesorEncontrado.setDireccion(profesor.getDireccion());
        profesorActualizado = repository.save(profesorEncontrado);
        return profesorActualizado;
    }

    @Override
    @Transactional
    public Profesor asociarCarreraProfesor(Persona profesor, Profesor profesor)
    {
        ((Profesor)profesor).setCarrera(carrera);
        return repository.save(profesor);
    }
}
