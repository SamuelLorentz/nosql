package br.mongo.dto;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Introspected
public class PersonDTO {

    private String name;
    private String city;
    private String country;

}
