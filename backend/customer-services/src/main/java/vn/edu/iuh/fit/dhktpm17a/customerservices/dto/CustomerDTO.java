package vn.edu.iuh.fit.dhktpm17a.customerservices.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;

@Value
public class CustomerDTO implements Serializable {
    String id;
    @NotBlank String name;
    @Email @NotBlank String email;
    @NotBlank String phone;
    @NotBlank String address;
}