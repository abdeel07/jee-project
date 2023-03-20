package ma.ecom.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private String description;
    private Double priceP;
    private Double priceS;
    private Category category;

    @Override
    public String toString(){
        return  "Product n° " + id + "\n"
                + "name : " + name + "\n"
                + "description : " + description + "\n"
                + "purchase price : " + priceP + "\n"
                + "sell price : " + priceS + "\n"
                + "category : " + category.getTitle() + "\n";
    }
}
