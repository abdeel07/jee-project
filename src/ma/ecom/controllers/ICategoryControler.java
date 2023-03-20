package ma.ecom.controllers;

import ma.ecom.entities.Category;

public interface ICategoryControler {

    public Category findCategoryById(Long id);

    public Category findCategoryByTitle(String title);

    public void addCategory(Category category);

    public void deleteCategory(Long id);
}
