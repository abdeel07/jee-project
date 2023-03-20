package ma.ecom.repositories.DB;

import ma.ecom.entities.Category;
import ma.ecom.entities.Product;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProductDB {
    public static Set<Product> productDB(){
        return new HashSet<Product>(
                Arrays.asList(
                        new Product(1L,"Samsung S22", "Samsung phone",100D, 150D,
                                new Category(1L,"Phone")),

                        new Product(2L,"Iphone 20", "Appel phone",150D, 200D,
                                new Category(1L,"Phone")),

                        new Product(3L,"Samsung TV", "Samsung TV",500D, 800D,
                                new Category(2L,"TV"))
                )
        );
    }
}
