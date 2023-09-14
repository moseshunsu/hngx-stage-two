package com.hngx.hngxstagetwo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "persons")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;
}
