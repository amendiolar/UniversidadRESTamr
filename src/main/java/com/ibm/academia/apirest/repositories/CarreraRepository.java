package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.models.entities.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Integer>
{
    //@Query("select c from Carrera c where c.cantidadAnios =?1")
    public Iterable<Carrera> findCarrerasByCantidadAnios(Integer cantidadAnios);

    //@Query("select c from Carrera c where c.nombre  like %?1%")
    public Iterable<Carrera> findCarrerasByNombreContains(String nombre);

    //@Query("select c from Carrera c where upper(c.nombre)  like upper(%?1%)")
    public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);

    //@Query("select c from Carrera c where c.cantidadAnios > ?1 ")
    public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);

    /*
    1.	Agregar método "Iterable<Carrera>
        buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);",
        el cual a través de anotación @Query se debe de buscar las carreras que se
        encuentren asociados a dicho profesor, buscando al mismo por nombre y apellido,
        los cuales serán ingresados por parámetros del método.
     */

    @Query("select c from Carrera c where c.profesores= ?1 and c.profesores = ?2 ")
    Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);

}
