package com.ibm.academia.apirest.services;


import com.ibm.academia.apirest.models.entities.Pabellon;

import java.util.Optional;

public interface PabellonDAO extends GenericoDAO<Pabellon>
{
    public Optional<Pabellon> buscarPabellonPorId(Integer id);
    public Pabellon guardarPabellon(Pabellon pabellon);
    public Iterable<Pabellon> buscarTodosPabellones(Pabellon pabellon);
    public void eliminarPabellonPorId(Integer id);
}
