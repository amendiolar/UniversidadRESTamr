package com.ibm.academia.apirest.models.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarreraDTO
{
    private Integer id;

    @NotNull(message = "No puede ser nulo")
    @NotEmpty(message = "No puede ser vacio")
    @Size(min = 5, max = 80)
    private String nombre;

    @Positive(message = "El valor debe ser mayor a 0")
    private Integer cantidadMaterias;

    @Positive(message = "El valor debe ser mayor a 0")
    private Integer cantidadAnios;
}
