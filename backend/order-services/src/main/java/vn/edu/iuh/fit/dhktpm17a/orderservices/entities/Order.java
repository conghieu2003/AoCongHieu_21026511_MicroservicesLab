package vn.edu.iuh.fit.dhktpm17a.orderservices.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    @Id
    private String id;
    private String customerId;
    private List<String> productIds;
    private Double totalPrice;
    private String status;
    private LocalDateTime createdAt;
}
