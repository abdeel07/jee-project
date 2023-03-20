package ma.ecom.services;

import ma.ecom.entities.Category;

public interface CategoryService {

    public Category findById(Long id);

    public Category findByTitle(String title);

    public void addCategory(Category category);

    public Boolean deleteCategory(Long id);
}
