package org.example.recipesapi.controllers;

import lombok.RequiredArgsConstructor;
import org.example.recipesapi.converters.IngredientConverter;
import org.example.recipesapi.dto.IngredientDTO;
import org.example.recipesapi.entities.Ingredient;
import org.example.recipesapi.services.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping
    public ResponseEntity<List<IngredientDTO>> getAllIngredients() {
        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        if (ingredients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.status(HttpStatus.OK).body(IngredientConverter.convertIngredientListToDTOList(ingredients));
    }

    @GetMapping("/ingredientId")
    public ResponseEntity<IngredientDTO> getIngredientById(@PathVariable Long id) {
        Ingredient ingredient = ingredientService.getIngredientById(id);
        if (ingredient == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.status(HttpStatus.OK).body(IngredientConverter.convertIngredientToDTO(ingredient));
    }

    @PostMapping
    public ResponseEntity<IngredientDTO> createIngredient(@RequestBody IngredientDTO ingredientDTO) {
        IngredientDTO responseBody = IngredientConverter.convertIngredientToDTO(ingredientService.addIngredient(ingredientDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }


}
