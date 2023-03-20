package ma.ecom.services;

import ma.ecom.entities.Product;

public interface ProductService {

    public Product findById(Long id);

    public Product findByName(String name);

    public void addProduct(Product product);

    public Boolean deleteProduct(Long id);
}
