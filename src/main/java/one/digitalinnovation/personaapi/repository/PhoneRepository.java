package one.digitalinnovation.personaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.personaapi.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
