package org.example.recipesapi.dto;

import lombok.Data;

import java.util.Set;

@Data
public class RecipeDTO {
    private String title;
    private Integer difficulty;
    private String description;
    private Set<IngredientDTO> ingredients;
}
