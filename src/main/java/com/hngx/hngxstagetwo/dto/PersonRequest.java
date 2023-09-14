package com.hngx.hngxstagetwo.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonRequest {

    @Pattern(regexp = "^(?=.*\\s).{2,}$")
    private String name;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    private String email;
}
