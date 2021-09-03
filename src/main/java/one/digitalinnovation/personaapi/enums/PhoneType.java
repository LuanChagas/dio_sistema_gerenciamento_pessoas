package one.digitalinnovation.personaapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {
    HOME("Home"), MOBILE("Mobile"), COMERCIAL("Commercial");

    private final String description;

}
