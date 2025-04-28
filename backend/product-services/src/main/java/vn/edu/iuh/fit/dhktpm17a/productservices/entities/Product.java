package vn.edu.iuh.fit.dhktpm17a.productservices.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Document(collection = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    private String id;
    private String nameProduct;
    private Double price;
    private String description;
    private Integer stock;
}