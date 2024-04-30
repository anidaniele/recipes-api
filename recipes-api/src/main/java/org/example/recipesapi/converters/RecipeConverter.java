package org.example.recipesapi.converters;

import org.example.recipesapi.dto.IngredientDTO;
import org.example.recipesapi.dto.RecipeDTO;
import org.example.recipesapi.entities.Ingredient;
import org.example.recipesapi.entities.Recipe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecipeConverter {

    public static Recipe convertDTOToRecipe(RecipeDTO recipeDTO) {
        Recipe recipe = null;
        if (recipeDTO != null) {
            recipe = new Recipe();
            recipe.setTitle(recipeDTO.getTitle());
            recipe.setDifficulty(recipeDTO.getDifficulty());
            recipe.setDescription(recipe.getDescription());
            Set<Ingredient> ingredients = new HashSet<>();
            if (recipeDTO.getIngredients() != null) {
                for (IngredientDTO ingredientDTO : recipeDTO.getIngredients()) {
                    ingredients.add(IngredientConverter.convertDTOToIngredient(ingredientDTO));
                }
            }
            recipe.setIngredients(ingredients);
        }
        return recipe;
    }

    public static RecipeDTO convertRecipeToDTO(Recipe recipe) {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setTitle(recipe.getTitle());
        recipeDTO.setDifficulty(recipe.getDifficulty());
        recipeDTO.setDescription(recipe.getDescription());
        Set<IngredientDTO> ingredientDTO = new HashSet<>();
        if (recipe.getIngredients() != null) {
            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredientDTO.add(IngredientConverter.convertIngredientToDTO(ingredient));
            }
        }
        recipeDTO.setIngredients(ingredientDTO);
        return recipeDTO;
    }

    public static List<Recipe> convertDTOToRecipeList(List<RecipeDTO> recipeDTOList) {
        List<Recipe> recipes = new ArrayList<>();
        for (RecipeDTO recipeDTO : recipeDTOList) {
            recipes.add(convertDTOToRecipe(recipeDTO));
        }
        return recipes;
    }

    public static List<RecipeDTO> convertRecipeListToDTOList(List<Recipe> recipes) {
        List<RecipeDTO> recipeDTOs = new ArrayList<>();
        for (Recipe recipe : recipes) {
            recipeDTOs.add(convertRecipeToDTO(recipe));
        }
        return recipeDTOs;
    }


}
