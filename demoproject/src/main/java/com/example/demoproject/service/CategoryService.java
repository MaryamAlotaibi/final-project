package com.example.demoproject.service;

import com.example.demoproject.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@RequiredArgsConstructor
public class CategoryService {
    ArrayList<Category> categoryList=new ArrayList<Category>();
    public ArrayList<Category> getCategoryList() {
        return categoryList;
    }
    public void addCategory(Category category) {
        categoryList.add(category);
    }

    public void updateCategory(Category category, int index) {
        categoryList.set(index,category);
    }

    public void deleteCategory(int index) {
        categoryList.remove(index);
    }
}
