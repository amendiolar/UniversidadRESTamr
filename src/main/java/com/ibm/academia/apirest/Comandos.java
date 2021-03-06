package com.ibm.academia.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Comandos implements CommandLineRunner
{
    @Autowired
    private CarreraDAO carreraDao;

    @Autowired
    private PersonaDAO personaDao;

    @Override
    public void run(String... args) throws Exception
    {
		/*Carrera finanzas = new Carrera(null, "Ingenieria en finanzas", 20, 3);
		Carrera carreraGuardada = carreraDao.guardar(finanzas);
		System.out.println(carreraGuardada.toString());*/

		/*Carrera carrera = null;

		Optional<Carrera> oCarrera = carreraDao.buscarPorId(2);
		if(oCarrera.isPresent())
		{
			carrera = oCarrera.get();
			System.out.println(carrera.toString());
		}
		else
		{
			System.out.println("Carrera no encontrada");
		}

		carrera.setCantidadAnios(7);
		carrera.setCantidadMaterias(66);
		carreraDao.guardar(carrera);

		System.out.println(carreraDao.buscarPorId(2).orElse(new Carrera()).toString());

		carreraDao.eliminarPorId(2);
		System.out.println(carreraDao.buscarPorId(2).orElse(new Carrera()).toString());*/

		/*Carrera ingSistemas = new Carrera(null, "Ingenieria en Sistemas", 60, 5);
        Carrera ingIndustrial = new Carrera(null, "Ingenieria Industrial", 55, 5);
        Carrera ingAlimentos = new Carrera(null, "Ingenieria en Alimentos", 53, 5);
        Carrera ingElectronica = new Carrera(null, "Ingenieria Electronica", 45, 5);
        Carrera licSistemas = new Carrera(null, "Licenciatura en Sistemas", 40, 4);
        Carrera licTurismo = new Carrera(null, "Licenciatura en Turismo", 42, 4);
        Carrera licYoga = new Carrera(null, "Licenciatura en Yoga", 25, 3);
        Carrera licRecursos = new Carrera(null, "Licenciatura en Recursos Humanos - RRHH", 33, 3);

        carreraDao.guardar(ingSistemas);
        carreraDao.guardar(ingIndustrial);
        carreraDao.guardar(ingAlimentos);
        carreraDao.guardar(ingElectronica);
        carreraDao.guardar(licSistemas);
        carreraDao.guardar(licTurismo);
        carreraDao.guardar(licYoga);
        carreraDao.guardar(licRecursos);*/

		/*List<Carrera> carreras = (List<Carrera>)carreraDao.findCarrerasByNombreContains("Sistemas");
        carreras.forEach(System.out::println);*/

        /*List<Carrera> carrerasIgnoreCase1 = (List<Carrera>) carreraDao.findCarrerasByNombreContainsIgnoreCase("SISTEMAS");
        List<Carrera> carrerasIgnoreCase2 = (List<Carrera>) carreraDao.findCarrerasByNombreContainsIgnoreCase("sistemas");
        carrerasIgnoreCase1.forEach(System.out::println);
        carrerasIgnoreCase2.forEach(System.out::println);*/

        /*List<Carrera> carrerasPorAnio = (List<Carrera>) carreraDao.findCarrerasByCantidadAniosAfter(3);
        carrerasPorAnio.forEach(System.out::println);*/

		/*Optional<Persona> persona = personaDao.buscarPorId(1);
		System.out.println(persona.toString());*/

    }
}
