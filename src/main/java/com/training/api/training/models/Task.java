package com.training.api.training.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates getters, setters, equals, hashCode, toString
@NoArgsConstructor // Required for Hibernate
@AllArgsConstructor // Optional, for convenience
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "name is mandatory")
    private String name;

    @NotNull(message = "description is mandatory")
    @Column(name = "description")
    private String description;

    @NotNull(message = "compleated is mandatory")
    private Boolean compleated;
}
