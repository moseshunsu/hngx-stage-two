package com.hngx.hngxstagetwo.repository;

import com.hngx.hngxstagetwo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    boolean existsByName(String name);

    boolean existsByEmail(String email);
}
