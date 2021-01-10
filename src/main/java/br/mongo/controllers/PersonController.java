package br.mongo.controllers;

import br.mongo.dto.PersonDTO;
import br.mongo.models.Person;
import br.mongo.services.PersonService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import lombok.AllArgsConstructor;

import javax.validation.Valid;

@AllArgsConstructor
@Controller("/people")
public class PersonController {

    private final PersonService personService;

    @Get("/{name}")
    public HttpResponse<PersonDTO> show(String name) {
        PersonDTO personDTO = personService.findOne(name);
        return HttpResponse.ok(personDTO);
    }

    @Get
    public HttpResponse<Iterable<Person>> findAll() {
        Iterable<Person> people = personService.findAll();
        return HttpResponse.ok(people);
    }

    @Post
    public HttpResponse<PersonDTO> save(@Body @Valid PersonDTO personDTO) {
        personService.insert(personDTO);
        return HttpResponse.created(personDTO);
    }

    @Delete("/{name}")
    public HttpResponse<Person> delete(String name) {
        personService.deletePerson(name);
        return HttpResponse.noContent();
    }

}
