package vn.edu.iuh.fit.dhktpm17a.productservices.dto;

import lombok.Value;

import java.io.Serializable;


@Value
public class ProductDTO implements Serializable {
    String id;
    String name_product;
    Double price;
    String description;
    Integer stock;
}