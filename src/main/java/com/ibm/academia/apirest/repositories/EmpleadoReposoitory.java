package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.enums.TipoEmpleado;
import com.ibm.academia.apirest.models.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioEmpleados")
public interface EmpleadoReposoitory extends PersonaRepository
{
    /*
        1.	Agregar método
        "Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);",
        el cual a través de anotación @Query se debe de buscar los empleados que se
        encuentren asociados a dicho tipo de empleado el cual será ingresado por
        parámetro del método.
     */

    @Query("select e from Empleado e where e.tipoEmpleado = ?1")
    Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);

}
