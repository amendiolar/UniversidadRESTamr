package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.models.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioProfesores")
public interface ProfesorRepository extends PersonaRepository
{
    /*
    1.	Agregar método "Iterable<Persona> findProfesoresByCarrera(String carrera)",
        el cual a través de anotación @Query se debe de buscar los profesores que se encuentren
        asociados a dicha carrera donde el nombre de la misma sea igual al ingresado en el
        parámetro del método.
     */

    @Query("select p from Profesor p where p.carreras = ?1")
    Iterable<Persona> findProfesoresByCarrera(String carrera);
}
