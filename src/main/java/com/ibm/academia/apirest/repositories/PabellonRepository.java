package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.models.entities.Direccion;
import com.ibm.academia.apirest.models.entities.Pabellon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PabellonRepository
{
    /*
    1.	Agregar método para buscar el/los pabellón/es que se encuentran en una localidad
        en particular la cual será ingresada por parámetro, el cual debe de realizarse
        a través de Query Method
     */

    @Query("select p from Pabellon p where p.direccion.localidad = ?1")
    Iterable<Pabellon> BuscarPabellonPorLocalidad(Direccion localidad);


    /*
    2.	Agregar método para buscar el/los pabellón/es por un nombre de pabellón en particular
        la cual será ingresada por parámetro, el cual debe de realizarse a través de Query Method.
     */

    @Query("select p from Pabellon p where p.nombre = ?1")
    Optional<Pabellon> BuscarPabellonPorNombre (Pabellon nombre);
}
