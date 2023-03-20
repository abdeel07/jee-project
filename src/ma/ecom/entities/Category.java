package ma.ecom.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    private Long id;
    private String title;

    @Override
    public String toString(){
        return  "Category n° " + id + "\n"
                + "title : " + title + "\n";
    }
}
