package one.digitalinnovation.personaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.personaapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
