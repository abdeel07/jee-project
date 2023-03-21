package ma.ecom.repositories.impl;

import ma.ecom.entities.Category;
import ma.ecom.repositories.CategoryRepository;
import ma.ecom.repositories.DB.CategoryBD;
import org.springframework.stereotype.Component;

@Component
public class CategoryRepositoryImpl implements CategoryRepository {
    @Override
    public Category findById(Long id) {
        return CategoryBD.categoryBD()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Category findByTitle(String title) {
        return CategoryBD.categoryBD()
                .stream()
                .filter(p -> p.getTitle() == title)
                .findFirst()
                .orElse(null);
    }
}
