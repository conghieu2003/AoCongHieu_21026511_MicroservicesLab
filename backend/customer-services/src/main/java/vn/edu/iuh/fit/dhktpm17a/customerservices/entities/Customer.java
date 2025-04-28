package vn.edu.iuh.fit.dhktpm17a.customerservices.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Document(collection = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
}