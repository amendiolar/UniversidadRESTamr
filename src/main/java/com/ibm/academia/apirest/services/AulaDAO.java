package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Aula;
import com.ibm.academia.apirest.models.entities.Carrera;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AulaDAO extends GenericoDAO<Aula>
{
    public Optional<Aula> buscarAulaPorId(Integer id);
    public Aula guardarAula(Aula aula);
    public Iterable<Aula> buscarTodosAulas(Aula aula);
    public void eliminarAulaPorId(Integer id);

    Aula actualizarAula(Aula aula, Aula aula1);
}
