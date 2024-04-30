package org.example.recipesapi.services;

import lombok.AllArgsConstructor;
import org.example.recipesapi.dto.IngredientDTO;
import org.example.recipesapi.entities.Ingredient;
import org.example.recipesapi.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@AllArgsConstructor
@Service
public class IngredientService {

    private IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient getIngredientById(long id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    public Ingredient addIngredient(IngredientDTO ingredientDTO) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDTO.getName());
        ingredient.setCategory(ingredientDTO.getCategory());
        ingredient.setRecipes(new HashSet<>());
        return ingredientRepository.saveAndFlush(ingredient);
    }

    public void deleteIngredientById(long id) {
        ingredientRepository.deleteById(id);
    }
}
