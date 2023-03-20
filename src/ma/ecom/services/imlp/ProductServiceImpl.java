package ma.ecom.services.imlp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ecom.entities.Product;
import ma.ecom.repositories.DB.ProductDB;
import ma.ecom.repositories.ProductRepository;
import ma.ecom.services.ProductService;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void addProduct(Product product) {
        ProductDB.productDB().add(product);
    }

    @Override
    public Boolean deleteProduct(Long id) {
        Product product = productRepository.findById(id);

        if(product != null){
            ProductDB.productDB().remove(product);
            return true;
        }
        else
            return false;
    }
}
