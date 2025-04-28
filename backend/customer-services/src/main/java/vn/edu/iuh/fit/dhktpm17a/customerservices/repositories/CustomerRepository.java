package vn.edu.iuh.fit.dhktpm17a.customerservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import vn.edu.iuh.fit.dhktpm17a.customerservices.entities.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}