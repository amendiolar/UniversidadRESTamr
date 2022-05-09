package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.models.entities.Aula;
import com.ibm.academia.apirest.models.entities.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends CrudRepository<Aula, Integer>
{
    /*
    1.	Agregar método para buscar las aulas que correspondan al tipo de pizarrón ingresado
        por parámetro, el cual debe de realizarse a través de Query Method.
     */

    @Query("select a from Aula a where a.pizarron =?1")
    public Iterable<Aula> findAulasByPizarron(String pizarron);


    /*
    2. Agregar método para buscar las aulas que correspondan al nombre de cierto pabellón
        ingresado por parámetro, el cual debe de realizarse a través de Query Method.
     */

    @Query("select a from Aula a where a.pabellon =?1")
    public Iterable<Aula> findAulasByPabellon(String pabellon);


    /*
    3. Agregar método para buscar el aula que corresponda al numero de aula ingresado
        por parámetro, el cual debe de realizarse a través de Query Method.
     */




}
