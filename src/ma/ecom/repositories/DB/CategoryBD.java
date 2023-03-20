package ma.ecom.repositories.DB;

import ma.ecom.entities.Category;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CategoryBD {
    public static Set<Category> categoryBD (){
        return new HashSet<Category>(
                Arrays.asList(
                        new Category(1L,"Phone"),
                        new Category(2L, "TV"),
                        new Category(3L, "Laptop")
                )
        );
    }
}
