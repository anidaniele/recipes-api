package org.example.recipesapi.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateRecipeDTO {
    private RecipeDTO recipeDTO = new RecipeDTO();
    private List<Long> ingredientIds = new ArrayList<>();
}
