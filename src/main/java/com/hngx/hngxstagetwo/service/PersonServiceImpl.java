package com.hngx.hngxstagetwo.service;

import com.hngx.hngxstagetwo.dto.PersonRequest;
import com.hngx.hngxstagetwo.entity.Person;
import com.hngx.hngxstagetwo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
    private final PersonRepository repository;

    @Override
    public ResponseEntity<Person> createPerson(PersonRequest request) {
        boolean isNameExists = repository.existsByName(request.getName());
        boolean isEmailExists = repository.existsByEmail(request.getEmail());

        if (isNameExists) {
            return ResponseEntity.badRequest().body(
                    Person.builder().name("Name already exists").build()
            );
        }

        if (isEmailExists) {
            return ResponseEntity.badRequest().body(
                    Person.builder().email("Email already exists").build()
            );
        }

        Person person = Person.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build();
        Person savedPerson = repository.save(person);

        return ResponseEntity.ok(
                Person.builder()
                        .id(savedPerson.getId())
                        .name(savedPerson.getName())
                        .email(savedPerson.getEmail())
                        .build()
        );
    }

    @Override
    public ResponseEntity<Person> fetchPerson(Long id) {
        Person person = repository.findById(id).orElseThrow(
                () -> new NoSuchElementException("User with id: " + id + " not found")
        );

        return ResponseEntity.ok(
                Person.builder()
                        .id(person.getId())
                        .name(person.getName())
                        .email(person.getEmail())
                        .build()
        );
    }

    @Override
    public ResponseEntity<Person> updatePerson(Long id, PersonRequest personRequest) {
        Person person = repository.findById(id).orElseThrow(
                () -> new NoSuchElementException("User with id: " + id + " not found")
        );

        person.setName(personRequest.getName());
        person.setEmail(personRequest.getEmail());
        Person savedPerson = repository.save(person);

            return ResponseEntity.ok(
                    Person.builder()
                            .id(savedPerson.getId())
                            .name(savedPerson.getName())
                            .email(savedPerson.getEmail())
                            .build()
            );

    }

    @Override
    public String deletePerson(Long id) {
        Person person = repository.findById(id).orElseThrow(
                () -> new NoSuchElementException("User with id: " + id + " not found")
        );
        repository.delete(person);
        return ("User with Id: " + id + " deleted");
    }
}
