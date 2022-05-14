package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Persona;

public interface ProfesorDAO extends PersonaDAO
{
    public Iterable<Persona> buscarProfesorPorNombre(String nombre);
    public Persona actualizar(Persona profesorEncontrado, Persona profesor);
    public Persona guardarProfesor(Persona profesor);
    public Iterable<Persona> buscarTodosProfesores(Persona profesor);
    public void eliminarProfesorPorId(Integer id);
}
