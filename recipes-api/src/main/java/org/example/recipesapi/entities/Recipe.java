package org.example.recipesapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer difficulty;
    private String description;
    @ManyToMany
    private Set<Ingredient> ingredients = new HashSet<>();
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
}
