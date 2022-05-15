package com.ibm.academia.apirest.mapper;

import com.ibm.academia.apirest.models.DTO.AulaDTO;
import com.ibm.academia.apirest.models.entities.Aula;
import com.ibm.academia.apirest.models.entities.Carrera;

public class AulaMapper
{
    public static AulaDTO mapAula(Aula aula)
    {
        AulaDTO aulaDTO = new AulaDTO();
        aulaDTO.setId(aula.getId());
        aulaDTO.setNumeroAula(aula.getNumeroAula());
        aulaDTO.setMedidas(aula.getMedidas());
        aulaDTO.setCantidadPupitres(aula.getCantidadPupitres());
        return aulaDTO;
    }
}
