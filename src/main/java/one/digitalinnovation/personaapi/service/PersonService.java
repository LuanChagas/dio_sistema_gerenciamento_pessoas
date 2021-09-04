package one.digitalinnovation.personaapi.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personaapi.dto.MessageResponseDTO;
import one.digitalinnovation.personaapi.dto.request.PersonDTO;
import one.digitalinnovation.personaapi.entity.Person;
import one.digitalinnovation.personaapi.mapper.PersonMapper;
import one.digitalinnovation.personaapi.repository.PersonRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    // private final PersonMapper personMapper = PersonMapper.INSTANCE;

    /*
     * public MessageResponseDTO createPerson(PersonDTO personDTO) { Person
     * personToSave = personMapper.ToModel(personDTO); Person savedPerson =
     * personRepository.save(personToSave); return
     * MessageResponseDTO.builder().message("Created person with ID " +
     * savedPerson.getId()).build(); }
     */

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        LocalDate dt = personDTO.data(personDTO.getBirthDate());
        Person personToSave = Person.builder().firstName(personDTO.getFirstName()).lastName(personDTO.getLastName())
                .cpf(personDTO.getCpf()).birthDate(personDTO.getBirthDateReturn()).phones(personDTO.getPhones())
                .build();
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder().message("Created person with ID " + savedPerson.getId()).build();
    }

}
