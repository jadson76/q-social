package br.com.jadsondev.quarkussocial.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUserRequest  {
    @NotBlank(message = "Name is required")
    private String name;
    @NotNull(message = "age is required")
    private Integer age;
}
