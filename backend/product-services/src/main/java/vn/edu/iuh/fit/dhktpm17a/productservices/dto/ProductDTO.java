package vn.edu.iuh.fit.dhktpm17a.productservices.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Value;

import java.io.Serializable;

@Value
public class ProductDTO implements Serializable {
    String id;
    @NotBlank String nameProduct;
    @Positive Double price;
    @NotBlank String description;
    @PositiveOrZero Integer stock;
}