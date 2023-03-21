package ma.ecom.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ecom.entities.Product;
import ma.ecom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductControler implements IProductControler{

    @Autowired
    ProductService productService;

    public Product findProductById(Long id){
        return productService.findById(id);
    }

    public Product findProductByName(String name){
        return productService.findByName(name);
    }

    public void addProduct(Product product){
        productService.addProduct(product);
        System.out.println("Added successfully");
    }

    public void deleteProduct(Long id){
        Boolean b = productService.deleteProduct(id);

        if (b == true)
            System.out.println("Deleted !!");
        else
            System.out.println("Not exist !");
    }
}
