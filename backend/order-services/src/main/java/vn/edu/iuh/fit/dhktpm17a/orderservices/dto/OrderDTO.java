package vn.edu.iuh.fit.dhktpm17a.orderservices.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Value
public class OrderDTO implements Serializable {
    String id;
    @NotBlank String customerId;
    @NotEmpty List<String> productIds;
    @Positive Double totalPrice;
    @NotBlank String status;
    LocalDateTime createdAt;
}