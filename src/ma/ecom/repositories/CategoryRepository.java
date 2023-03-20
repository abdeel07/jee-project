package ma.ecom.repositories;

import ma.ecom.entities.Category;

public interface CategoryRepository {
    public Category findById(Long id);

    public Category findByTitle(String title);
}
