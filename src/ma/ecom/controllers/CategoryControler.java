package ma.ecom.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ecom.entities.Category;
import ma.ecom.services.CategoryService;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryControler implements ICategoryControler{

    CategoryService categoryService;

    public Category findCategoryById(Long id) {
        return categoryService.findById(id);
    }

    public Category findCategoryByTitle(String title) {
        return categoryService.findByTitle(title);
    }

    public void addCategory(Category category){
        categoryService.addCategory(category);
        System.out.println("Added successfully");
    }

    public void deleteCategory(Long id){
        Boolean b = categoryService.deleteCategory(id);

        if (b == true)
            System.out.println("Deleted !!");
        else
            System.out.println("Not exist !");
    }

}
