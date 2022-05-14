package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Aula;
import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.models.entities.Persona;

public interface EmpleadoDAO extends PersonaDAO
{
    public Iterable<Persona> buscarEmpleadoPorNombre(String nombre);
    public Persona actualizar(Persona empleadoEncontrado, Persona empleado);
    public Persona guardarEmpleado(Persona empleado);
    public Iterable<Persona> buscarTodosEmpleados(Persona empleado);
    public void eliminarEmpleadoPorId(Integer id);
}
