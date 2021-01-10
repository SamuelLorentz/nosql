package br.mongo.models;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @NotBlank
    private String name;

    @NotBlank
    private String city;

    @NotBlank
    private String country;

}
