package br.mongo.services;

import br.mongo.dto.PersonDTO;
import br.mongo.mappers.PersonMapper;
import br.mongo.models.Person;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import lombok.AllArgsConstructor;
import org.bson.conversions.Bson;

import javax.inject.Singleton;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
import static java.util.stream.StreamSupport.stream;

@Singleton
@AllArgsConstructor
public class PersonService {

    private final MongoClient mongoClient;

    private MongoCollection<Person> getCollection() {
        return mongoClient
                .getDatabase("main")
                .getCollection("people", Person.class);
    }

    public PersonDTO findOne(String name) {
        Bson filter = Filters.eq("name", name);

        Person person = getCollection().find(filter).first();

        return nonNull(person) ? PersonMapper.toDTO(person) : null;
    }

    public Iterable<Person> findAll() {
        final FindIterable<Person> iterable = getCollection().find();
        return stream(iterable.spliterator(), false).collect(Collectors.toList());
    }

    public void insert(PersonDTO personDTO) {
        Person person = PersonMapper.toEntity(personDTO);
        getCollection().insertOne(person);
    }

    public void deletePerson(String name) {
        Bson filter = Filters.eq("name", name);
        getCollection().deleteOne(filter);
    }
}
