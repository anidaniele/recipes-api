package org.example.recipesapi.controllers;

import lombok.RequiredArgsConstructor;
import org.example.recipesapi.converters.RecipeConverter;
import org.example.recipesapi.dto.CreateRecipeDTO;
import org.example.recipesapi.dto.RecipeDTO;
import org.example.recipesapi.entities.Recipe;
import org.example.recipesapi.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<RecipeDTO>> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        if (recipes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(RecipeConverter.convertRecipeListToDTOList(recipes));
    }

    @GetMapping("/recipeId")
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable Long id) {
        Recipe recipe = recipeService.getRecipeById(id);
        if (recipe == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.status(HttpStatus.OK).body(RecipeConverter.convertRecipeToDTO(recipe));
    }

    @PostMapping()
    public ResponseEntity<RecipeDTO> createRecipeFromExistingIngredients(@RequestBody CreateRecipeDTO createRecipeDTO) {
        Recipe recipe = recipeService.createRecipeFromExistingIngredients(createRecipeDTO.getRecipeDTO(), createRecipeDTO.getIngredientIds());
        RecipeDTO createdRecipeDTO = RecipeConverter.convertRecipeToDTO(recipe);
        return new ResponseEntity<>(createdRecipeDTO, HttpStatus.CREATED);
    }



}
