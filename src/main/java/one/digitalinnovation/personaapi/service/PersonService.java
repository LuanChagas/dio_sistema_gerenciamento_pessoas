package one.digitalinnovation.personaapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personaapi.dto.MessageResponseDTO;
import one.digitalinnovation.personaapi.dto.request.PersonDTO;
import one.digitalinnovation.personaapi.dto.servicesDTO.ConvertPersons;
import one.digitalinnovation.personaapi.entity.Person;
import one.digitalinnovation.personaapi.exceptions.PersonNotFoundException;
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
        return createMessageresponse(savedPerson.getId(), "Create");

    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream().map(x -> {
            PersonDTO personDTO = ConvertPersons.PersonToPersonDTO(x);
            return personDTO;
        }).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyExists(id);
        return ConvertPersons.PersonToPersonDTO(person);
    }

    public MessageResponseDTO updateById(PersonDTO personDTO) throws PersonNotFoundException {
        verifyExists(personDTO.getId());
        Person personToSave = ConvertPersons.PersonDTOToPerson(personDTO);
        personToSave.setId(personDTO.getId());
        Person UpdatedPerson = personRepository.save(personToSave);
        return createMessageresponse(UpdatedPerson.getId(), "Update");
    }

    public void deleteById(Long id) throws PersonNotFoundException {
        verifyExists(id);
        personRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageresponse(Long id, String text) {
        return MessageResponseDTO.builder().message(text + " person with ID " + id).build();
    }

    private Person verifyExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

}
