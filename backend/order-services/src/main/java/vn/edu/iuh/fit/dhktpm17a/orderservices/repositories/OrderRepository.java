package vn.edu.iuh.fit.dhktpm17a.orderservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import vn.edu.iuh.fit.dhktpm17a.orderservices.entities.Order;

public interface OrderRepository extends MongoRepository<Order, String> {
}