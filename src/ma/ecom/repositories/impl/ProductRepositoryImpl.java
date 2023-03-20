package ma.ecom.repositories.impl;

import ma.ecom.entities.Product;
import ma.ecom.repositories.DB.ProductDB;
import ma.ecom.repositories.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public Product findById(Long id) {
        return ProductDB.productDB()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Product findByName(String name) {
        return ProductDB.productDB()
                .stream()
                .filter(p -> p.getName() == name)
                .findFirst()
                .orElse(null);
    }
}
