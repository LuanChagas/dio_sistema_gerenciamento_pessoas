package one.digitalinnovation.personaapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import one.digitalinnovation.personaapi.dto.request.PersonDTO;
import one.digitalinnovation.personaapi.entity.Person;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "BirthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person ToModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
