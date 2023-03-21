package ma.ecom.services.imlp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ecom.entities.Category;
import ma.ecom.repositories.CategoryRepository;
import ma.ecom.repositories.DB.CategoryBD;
import ma.ecom.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }

    @Override
    public void addCategory(Category category) {
        CategoryBD.categoryBD().add(category);
    }

    @Override
    public Boolean deleteCategory(Long id) {
        Category category = categoryRepository.findById(id);

        if(category != null){
            CategoryBD.categoryBD().remove(category);
            return true;
        }
        else
            return false;
    }
}
