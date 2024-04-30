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
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    @ManyToMany(mappedBy = "ingredients")
    private Set<Recipe> recipes = new HashSet<>();
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;

}
