package ma.ecom.repositories;

import ma.ecom.entities.Product;

public interface ProductRepository {
    public Product findById(Long id);

    public Product findByName(String name);
}
