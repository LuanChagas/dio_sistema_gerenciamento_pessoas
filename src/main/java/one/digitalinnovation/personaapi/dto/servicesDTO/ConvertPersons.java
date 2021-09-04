package one.digitalinnovation.personaapi.dto.servicesDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personaapi.dto.request.PersonDTO;
import one.digitalinnovation.personaapi.entity.Person;

public class ConvertPersons {

    public static PersonDTO PersonToPersonDTO(Person person) {
        PersonDTO personDTO = PersonDTO.builder().id(person.getId()).firstName(person.getFirstName())
                .lastName(person.getLastName()).birthDate(PersonDTO.get2BirthDate(person.getBirthDate()))
                .cpf(person.getCpf()).phones(person.getPhones()).build();
        return personDTO;
    }

    public static Person PersonDTOToPerson(PersonDTO personDTO) {
        Person person = Person.builder().firstName(personDTO.getFirstName()).lastName(personDTO.getLastName())
                .cpf(personDTO.getCpf()).birthDate(PersonDTO.data(personDTO.getBirthDate()))
                .phones(personDTO.getPhones()).build();
        return person;
    }
}
