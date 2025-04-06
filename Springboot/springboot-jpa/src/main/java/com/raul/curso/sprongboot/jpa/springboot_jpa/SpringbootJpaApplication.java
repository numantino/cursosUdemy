package com.raul.curso.sprongboot.jpa.springboot_jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.raul.curso.sprongboot.jpa.springboot_jpa.entities.Person;
import com.raul.curso.sprongboot.jpa.springboot_jpa.repositories.PersonRepository;


@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner{

	@Autowired
	private PersonRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		update();
	}

	/**
	 * Consultas personalizadas
	 */
	@Transactional
	public void subQueris(){
		List<Object[]> personsRegs = repository.getShorterName();

		System.out.println("Consulta nombre mas corto");
		personsRegs.forEach(reg -> {
			System.out.println("nombre: " + reg[1] + "[" + reg[2] + "]");
		});
	}

	/**
	 * Consultas personalizadas
	 */
	@Transactional
	public void personalizadas(){
		List<Object[]> personsRegs = repository.findAllMix(null);

		personsRegs.forEach(reg -> {
			System.out.println("Buscamos: " + reg[1] + " " + reg[2]);
		});
	}

	/**
	 * Eliminamos datos
	 */
	@Transactional
	public void delete(){
		Scanner scaner = new Scanner(System.in);
		System.out.println("Ingrese el id de la persona");
		repository.deleteById(scaner.nextLong());
		scaner.close();
	}

	/**
	 * Para moidificar los datos
	 */
	@Transactional
	public void update(){
		Scanner scaner = new Scanner(System.in);
		System.out.println("Ingrese el id de la persona");
		Optional<Person> personOld = repository.findOne(scaner.nextLong());
		personOld.ifPresent(p -> {
			System.out.println("Nuevo programa de programacion");
			p.setProgrammingLanguage(scaner.next());
			Person pdb = repository.save(p);
			System.out.println(pdb);
		});
		scaner.close();
	}

	/**
	 * Para la creacion de registros
	 */
	@Transactional
	public void create(){
		Person person = new Person(null, "Lalo", "thor", "Python");
		Person personNew = repository.save(person);
		System.out.println(personNew);
	}

	/**
	 * Para la creacion de registros por medio de la insercion de parametros
	 */
	@Transactional
	public void createConsola(){
		System.out.println("Inserta los datos del nuevo registro");
		Scanner scaner = new Scanner(System.in);
		Person person = new Person(null, scaner.next(), scaner.next(), scaner.next());
		scaner.close();

		Person personNew = repository.save(person);
		System.out.println("Nuevo registro: " + personNew);

		repository.findOne(personNew.getId()).ifPresent(System.out::println);
	}

	/**
	 * Recuperar un solo dato
	 */
	@Transactional(readOnly = true)
	public void findOne(){
		//Optional<Person> opPersona = repository.findById(1L);
		//if (opPersona.isPresent()){
		//	System.out.println(opPersona.get());
		//}

		// Esto es de forma abreviada
		//repository.findById(1L).ifPresent(System.out::println);

		// Otra forma
		repository.findOne(1L).ifPresent(System.out::println);
	}

	/**
	 * Recuperar listas
	 */
	@Transactional(readOnly = true)
	public void list(){
		//List<Person> persons = (List<Person>) repository.findAll();
		//List<Person> persons = (List<Person>) repository.findByProgrammingLanguage("Java");
		List<Person> persons = (List<Person>) repository.buscamosByProgrammingLanguage("Java");
		persons.stream().forEach(person -> System.out.println(person));

		List<Object[]> personsData = repository.obtenerPersonData();
		personsData.stream().forEach(person -> System.out.println(person[0] + " experto en " + person[1]));
	}

}
