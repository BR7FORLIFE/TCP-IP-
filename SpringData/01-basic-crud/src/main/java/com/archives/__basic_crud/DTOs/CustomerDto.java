package com.archives.__basic_crud.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CustomerDto(
        @NotBlank @Size(max = 10) String name,
        @Email String email) {

}
