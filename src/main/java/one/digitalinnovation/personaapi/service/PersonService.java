package one.digitalinnovation.personaapi.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personaapi.dto.MessageResponseDTO;
import one.digitalinnovation.personaapi.dto.request.PersonDTO;
import one.digitalinnovation.personaapi.dto.servicesDTO.ConvertPersons;
import one.digitalinnovation.personaapi.entity.Person;
import one.digitalinnovation.personaapi.repository.PersonRepository;

@Service
@AllArgsConstructor
public class PersonService {

    @Autowired
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
        Person personToSave = ConvertPersons.PersonDTOToPerson(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder().message("Created person with ID " + savedPerson.getId()).build();
    }

    public List<PersonDTO> listAll() {
        ConvertPersons convertPersons;
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream().map(x -> {
            PersonDTO personDTO = ConvertPersons.PersonToPersonDTO(x);
            return personDTO;
        }).collect(Collectors.toList());
    }

}
