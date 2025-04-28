package vn.edu.iuh.fit.dhktpm17a.productservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import vn.edu.iuh.fit.dhktpm17a.productservices.entities.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}