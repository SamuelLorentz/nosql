package br.mongo.mappers;

import br.mongo.dto.PersonDTO;
import br.mongo.models.Person;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class PersonMapper {

    public static PersonDTO toDTO(Person person) {
        return PersonDTO.builder()
                .name(person.getName())
                .city(person.getCity())
                .country(person.getCity())
                .build();
    }

    public static Person toEntity(PersonDTO personDTO) {
        return Person.builder()
                .name(personDTO.getName())
                .city(personDTO.getCity())
                .country(personDTO.getCity())
                .build();
    }
}