package one.digitalinnovation.personaapi.dto.request;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personaapi.entity.Phone;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PersonDTO {
    final static DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;
    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;
    @NotEmpty
    @CPF
    private String cpf;

    private String birthDate;

    @NotEmpty
    @Valid
    private List<Phone> phones;

    public static LocalDate data(String dt) {

        LocalDate data = LocalDate.parse(dt, DATEFORMATTER);
        return data;
    }

    public static String get2BirthDate(LocalDate localdate) {
        String data = localdate.format(DATEFORMATTER);
        return data;
    }
}
