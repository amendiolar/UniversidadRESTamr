package com.ibm.academia.apirest.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AulaDTO
{
    private Integer id;

    @NotNull(message = "No puede ser nulo")
    @NotEmpty(message = "No puede ser vacio")
    private Integer numeroAula;

    @Positive(message = "El valor debe ser mayor a 0")
    private String medidas;

    @Positive(message = "El valor debe ser mayor a 0")
    private Integer cantidadPupitres;
}
