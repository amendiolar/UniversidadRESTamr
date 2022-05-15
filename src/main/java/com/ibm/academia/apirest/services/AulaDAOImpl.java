package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Aula;
import com.ibm.academia.apirest.repositories.AulaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class AulaDAOImpl extends GenericoDAOImpl<Aula, AulaRepository> implements AulaDAO
{

    public AulaDAOImpl(AulaRepository repository)
    {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Aula> buscarAulaPorId(Integer id)
    {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Aula guardar(Aula aula)
    {
        return repository.save(aula);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Aula> buscarTodosAula()
    {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void eliminarAulaPorId(Integer id)
    {
        repository.deleteById(id);
    }
}
