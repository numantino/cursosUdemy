package com.raul.curso.sprongboot.jpa.springboot_jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.raul.curso.sprongboot.jpa.springboot_jpa.dto.PersonDto;
import com.raul.curso.sprongboot.jpa.springboot_jpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{

    // personalizar una funcion
    @Query("select p.name, length(p.name) from Person p")
    public List<Object[]> getPersonNameLenght();

    // Consulta basada en nombre
    List<Person> findByProgrammingLanguage(String program);

    List<Person> findByProgrammingLanguageAndName(String program, String name);

    // Esta es al misma consulta, pero por query y con nombre que no es palabra clave
    @Query("select p from Person p where p.programmingLanguage=?1")
    List<Person> buscamosByProgrammingLanguage(String program);

    @Query("select p.name, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonData();

    @Query("select p from Person p where p.id=?1")
    Optional<Person> findOne(Long id);

    @Query("select p from Person p where p.name=?1")
    Optional<Person> findOneName(String name);

    // Otra forma de personalizar
    @Query("select p, p.programmingLanguage from Person p")
    List<Object[]> findAllMix(String program);

    // Consulta mas personalizada
    @Query("select new Person(p.name, p.lastname) from Person p")
    List<Person> findAllObjectPerson();

    // Revolvemos un dto
    @Query("select new com.raul.curso.sprongboot.jpa.springboot_jpa.dto.PersonDto(p.name, p.lastname) from Person p")
    List<PersonDto> findAllObjectPersonDto();

    // Para realizar subconsultas
    @Query("select p.name, length(p.name) from Person p where length(p.name)=(select min(length(p.name)) from Person p)")
    public List<Object[]> getShorterName();
}

  