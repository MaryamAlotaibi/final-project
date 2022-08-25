package com.example.demoproject.controller;

import com.example.demoproject.DTO.ApiResponse;
import com.example.demoproject.model.Category;
import com.example.demoproject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("pi/v1/")
public class CategoryController {
    private final CategoryService categoryService;


    @GetMapping("category")
    public ResponseEntity getCategory() {
        ArrayList<Category> categoryList = categoryService.getCategoryList();
        return ResponseEntity.status(200).body(categoryList);
    }

    @PostMapping("add-category")
    public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body(new ApiResponse("New Category added!", 200));
    }


    @PutMapping("update-category/{index}")
    public ResponseEntity updateCategory(@RequestBody @Valid Category category
            , @PathVariable int index, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        categoryService.updateCategory(category, index);
        return ResponseEntity.status(200).body(new ApiResponse("Category updated!", 200));
    }

    @DeleteMapping("delete-category/{index}")
    public ResponseEntity deleteCategory(@PathVariable int index) {
        categoryService.deleteCategory(index);
        return ResponseEntity.status(200).body(new ApiResponse("Category deleted!", 200));
    }
}
