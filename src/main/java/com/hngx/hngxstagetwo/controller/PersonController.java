package com.hngx.hngxstagetwo.controller;

import com.hngx.hngxstagetwo.dto.PersonRequest;
import com.hngx.hngxstagetwo.entity.Person;
import com.hngx.hngxstagetwo.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody @Valid PersonRequest request) {
        return personService.createPerson(request);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<Person> fetchPerson(@PathVariable("user_id") Long id) {
        return personService.fetchPerson(id);
    }

    @PutMapping("/{user_id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("user_id") Long id,
                                               @RequestBody @Valid PersonRequest personRequest) {
        return personService.updatePerson(id, personRequest);
    }

    @DeleteMapping("/{user_id}")
    public String deletePerson(@PathVariable("user_id") Long id) {
        return personService.deletePerson(id);
    }

}
