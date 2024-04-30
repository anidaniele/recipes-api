package org.example.recipesapi.dto;

import lombok.Data;

import java.util.Set;

@Data
public class IngredientDTO {
    private String name;
    private String category;
    private Set<RecipeDTO> recipes;
}
