package com.example.demo2.resturant.Services;

import com.example.demo2.resturant.Dto.CategoryAndFoods;
import com.example.demo2.resturant.Models.CategoryModel;
import com.example.demo2.resturant.Repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryModel addCategory(CategoryModel categoryModel)
    {
        return categoryRepository.save(categoryModel);
    }

    public List<CategoryModel> getAllCategoreis(){
        return categoryRepository.findAll();
    }
    public List<CategoryAndFoods> getCategoryFoods(int id){


        return categoryRepository.findCategoryAndFoods(id);
    }

    public ResponseEntity<String> updateCategory(CategoryModel categoryModel){

        CategoryModel categoryModel1=new CategoryModel();
        categoryModel1 = categoryRepository.findById(categoryModel.getCategoryId()).get();
        categoryModel1.setCategoryName(categoryModel.getCategoryName());
        categoryRepository.save(categoryModel1);

        return new ResponseEntity<>("Category Updated....", HttpStatus.OK);
    }


    public ResponseEntity<String > deleteCategory(Integer id){

        if (categoryRepository.findById(id).isPresent()) {
            categoryRepository.deleteById(id);
       return new ResponseEntity<>("Category was Deleted...",HttpStatus.OK);
        }else
            return new ResponseEntity<>("Category was Not Found...",HttpStatus.NOT_FOUND);
    }
}
