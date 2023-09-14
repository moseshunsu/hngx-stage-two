package com.hngx.hngxstagetwo.service;

import com.hngx.hngxstagetwo.dto.PersonRequest;
import com.hngx.hngxstagetwo.entity.Person;
import org.springframework.http.ResponseEntity;

public interface PersonService {
    ResponseEntity<Person> createPerson(PersonRequest request);
    ResponseEntity<Person> fetchPerson(Long id);
    ResponseEntity<Person> updatePerson(Long id, PersonRequest personRequest);
    String deletePerson(Long id);
}
