package org.example.recipesapi.services;

import lombok.AllArgsConstructor;
import org.example.recipesapi.converters.RecipeConverter;
import org.example.recipesapi.dto.RecipeDTO;
import org.example.recipesapi.entities.Ingredient;
import org.example.recipesapi.entities.Recipe;
import org.example.recipesapi.repositories.IngredientRepository;
import org.example.recipesapi.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class RecipeService {
    private RecipeRepository recipeRepository;
    private IngredientRepository ingredientRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    public Recipe addRecipe(RecipeDTO recipeDTO) {
        Recipe recipe = new Recipe();
        recipe.setTitle(recipeDTO.getTitle());
        recipe.setDescription(recipeDTO.getDescription());
        recipe.setDifficulty(recipeDTO.getDifficulty());
        recipe.setIngredients(new HashSet<>());
        return recipeRepository.saveAndFlush(recipe);
    }

    public Recipe createRecipeFromExistingIngredients(RecipeDTO recipeDTO, List<Long> ingredientIds) {
        Set<Ingredient> ingredients = new HashSet<>();
        for (Long ingredientId : ingredientIds) {
            Optional<Ingredient> optionalIngredient = ingredientRepository.findById(ingredientId);
            if (optionalIngredient.isEmpty()) {
                throw new IllegalArgumentException("Ingredient with ID " + ingredientId + " does not exist.");
            }
            ingredients.add(optionalIngredient.get());
        }
        Recipe recipe = RecipeConverter.convertDTOToRecipe(recipeDTO);
        recipe.setIngredients(ingredients);
        return recipeRepository.saveAndFlush(recipe);
    }



}
