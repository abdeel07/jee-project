package ma.ecom.controllers;

import ma.ecom.entities.Product;

public interface IProductControler {

    public Product findProductById(Long id);

    public Product findProductByName(String name);

    public void addProduct(Product product);

    public void deleteProduct(Long id);
}
