package com.ibm.academia.apirest.controllers;

import com.ibm.academia.apirest.exceptions.BadRequestException;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.mapper.AulaMapper;
import com.ibm.academia.apirest.models.DTO.AulaDTO;
import com.ibm.academia.apirest.models.entities.Aula;
import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.services.AulaDAO;
import com.ibm.academia.apirest.services.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aula")
public class AulaController
{
    @Autowired
    private AulaDAO aulaDao;

    @GetMapping("/lista/aulas")
    public List<Aula> buscarTodas()
    {
        List<Aula> aulas = (List<Aula>) aulaDao.buscarTodos();
        if(aulas.isEmpty())
            throw new BadRequestException("No existen aulas");

        return aulas;
    }

    @GetMapping("/id/{aulaId}")
    public Aula buscarAulaPorId(@PathVariable Integer aulaId)
    {
		/*Optional<Carrera> oCarrera = carreraDao.buscarPorId(carreraId);
		if(!oCarrera.isPresent())
			throw new BadRequestException(String.format("La carrera con ID: %d no existe", carreraId));

		return oCarrera.get();*/

        Aula aula = aulaDao.buscarPorId(aulaId).orElse(null);
        if(aula == null)
            throw new BadRequestException(String.format("El aula con ID: %d no existe", aulaId));

        return aula;
    }

    @PostMapping
    public ResponseEntity<?> guardarAula(@Validated @RequestBody Aula aula, BindingResult result)
    {
        Map<String, Object> validaciones = new HashMap<String, Object>();
        if(result.hasErrors())
        {
            List<String> listaErrores = result.getFieldErrors()
                    .stream()
                    .map(errores -> "Campo: '" + errores.getField() + "' " + errores.getDefaultMessage())
                    .collect(Collectors.toList());
            validaciones.put("Lista Errores", listaErrores);
            return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
        }

        Aula aulaGuardada = aulaDao.guardar(aula);

        return new ResponseEntity<Aula>(aulaGuardada, HttpStatus.CREATED);
    }

    /**
     * Endoint para actualizar un objeto de tipo carrera
     * @param aulaId Parámetro para buscar la carrera
     * @param aula Objeto con la información a modificar
     * @return Retorna un objeto de tipo Carrera con la información actualizada
     * @NotFoundException En caso de que falle actualizando el objeto carrera
     * @author NDSC - 06/12/2021
     */
    @PutMapping("/upd/aulaId/{aulaId}")
    public ResponseEntity<?> actualizarAula(@PathVariable Integer aulaId, @RequestBody Aula aula)
    {
        Optional<Aula> oAula = aulaDao.buscarPorId(aulaId);

        if(!oAula.isPresent())
            throw new NotFoundException(String.format("El aula con ID: %d no existe", aulaId));

        Aula aulaActualizada = aulaDao.actualizarAula(oAula.get(), aula);

        return new ResponseEntity<Aula>(aulaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/aulaId/{aulaId}")
    public ResponseEntity<?> eliminarAula(@PathVariable Integer aulaId)
    {
        Map<String, Object> respuesta = new HashMap<String, Object>();

        Optional<Aula> aula = aulaDao.buscarPorId(aulaId);

        if(!aula.isPresent())
            throw new NotFoundException(String.format("El aula con ID: %d no existe", aulaId));

        aulaDao.eliminarPorId(aulaId);
        respuesta.put("OK", "Aula ID: " + aulaId + " eliminada exitosamente");
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);
    }

    /**
     * Endpoint para consultar todas las carreras
     * @return Retorna una lista de carreras en DTO
     * @NotFoundException En caso de que no encuentre ningun elemento en la base de datos
     * @author NDSC - 07-12-2021
     */
    @GetMapping("/aulas/dto")
    public ResponseEntity<?> obtenerAulasDTO()
    {
        List<Aula> aulas = (List<Aula>) aulaDao.buscarTodos();

        if(aulas.isEmpty())
            throw new NotFoundException("No existen aulas en la base de datos.");

        List<AulaDTO> listaAulas = aulas
                .stream()
                .map(AulaMapper::mapAula)
                .collect(Collectors.toList());
        return new ResponseEntity<List<AulaDTO>>(listaAulas, HttpStatus.OK);
    }
}
