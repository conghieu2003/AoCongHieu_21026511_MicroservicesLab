package vn.edu.iuh.fit.dhktpm17a.productservices.repositories

import org.springframework.data.jpa.repository.JpaRepository
import vn.edu.iuh.fit.dhktpm17a.productservices.entities.Product

interface ProductRepository : JpaRepository<Product, String> {
}