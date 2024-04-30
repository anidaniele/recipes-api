package org.example.recipesapi.converters;

import org.example.recipesapi.dto.IngredientDTO;
import org.example.recipesapi.entities.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class IngredientConverter {

    public static Ingredient convertDTOToIngredient(IngredientDTO ingredientDTO) {
        Ingredient ingredient = null;
        if (ingredientDTO != null) {
            ingredient = new Ingredient();
            ingredient.setName(ingredientDTO.getName());
            ingredient.setCategory(ingredientDTO.getCategory());
        }
        return ingredient;
    }

    public static List<Ingredient> convertDTOToIngredientList(List<IngredientDTO> ingredientDTOList) {
        List<Ingredient> ingredients = null;
        if (ingredientDTOList != null && !ingredientDTOList.isEmpty()) {
            ingredients = new ArrayList<>();
            for (IngredientDTO dto : ingredientDTOList) {
                Ingredient ingredient = IngredientConverter.convertDTOToIngredient(dto);
                ingredients.add(ingredient);
            }
        }
        return ingredients;
    }

    public static IngredientDTO convertIngredientToDTO(Ingredient ingredient) {
        IngredientDTO ingredientDTO = null;
        if (ingredient != null) {
            ingredientDTO = new IngredientDTO();
            ingredientDTO.setName(ingredient.getName());
            ingredientDTO.setCategory(ingredient.getCategory());

        }
        return ingredientDTO;

    }

    public static List<IngredientDTO> convertIngredientListToDTOList(List<Ingredient> ingredients) {
        List<IngredientDTO> ingredientDTOs = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            ingredientDTOs.add(convertIngredientToDTO(ingredient));
        }
        return ingredientDTOs;
    }
}
