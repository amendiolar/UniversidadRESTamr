package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Alumno;
import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.repositories.AlumnoRepository;
import com.ibm.academia.apirest.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoDAOImpl extends PersonaDAOImpl implements EmpleadoDAO
{
    @Autowired
    public EmpleadoDAOImpl(@Qualifier("repositorioEmpleados") PersonaRepository repository)
    {
        super(repository);
    }

    @Override
    @Transactional
    public Persona actualizar(Persona empleadoEncontrado, Persona empleado)
    {
        Persona empleadoActualizado = null;
        empleadoEncontrado.setNombre(empleado.getNombre());
        empleadoEncontrado.setApellido(empleado.getApellido());
        empleadoEncontrado.setDireccion(empleado.getDireccion());
        empleadoActualizado = repository.save(empleadoEncontrado);
        return empleadoActualizado;
    }



}
