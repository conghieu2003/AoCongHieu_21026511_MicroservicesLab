package vn.edu.iuh.fit.dhktpm17a.productservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.dhktpm17a.productservices.dto.ProductDTO;
import vn.edu.iuh.fit.dhktpm17a.productservices.entities.Product;
import vn.edu.iuh.fit.dhktpm17a.productservices.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName_product(productDTO.getName_product());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setStock(productDTO.getStock());

        Product savedProduct = productRepository.save(product);
        return new ProductDTO(savedProduct.getId(), savedProduct.getName_product(), savedProduct.getPrice(), savedProduct.getDescription(), savedProduct.getStock());
    }

    public ProductDTO getProduct (String id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            return new ProductDTO(product.getId(), product.getName_product(), product.getPrice(), product.getDescription(), product.getStock());
        }
        return null;
    }
    public void updateProduct(String id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setName_product(productDTO.getName_product());
            product.setPrice(productDTO.getPrice());
            product.setDescription(productDTO.getDescription());
            product.setStock(productDTO.getStock());
            productRepository.save(product);
        }
    }
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
