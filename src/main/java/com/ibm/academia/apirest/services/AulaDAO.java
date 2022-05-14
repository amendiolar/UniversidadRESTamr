package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Aula;

import java.util.Optional;

public interface AulaDAO extends GenericoDAO<Aula>
{
    public Optional<Aula> buscarAulaPorId(Integer id);
    public Aula guardarAula(Aula aula);
    public Iterable<Aula> buscarTodosAulas(Aula aula);
    public void eliminarAulaPorId(Integer id);
}
