package vn.edu.iuh.fit.dhktpm17a.productservices.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.dhktpm17a.productservices.dto.ProductDTO;
import vn.edu.iuh.fit.dhktpm17a.productservices.entities.Product;
import vn.edu.iuh.fit.dhktpm17a.productservices.repositories.ProductRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setNameProduct(productDTO.getNameProduct());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setStock(productDTO.getStock());

        Product savedProduct = productRepository.save(product);
        return new ProductDTO(savedProduct.getId(), savedProduct.getNameProduct(),
                savedProduct.getPrice(), savedProduct.getDescription(),
                savedProduct.getStock());
    }

    public ProductDTO getProduct(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        return new ProductDTO(product.getId(), product.getNameProduct(),
                product.getPrice(), product.getDescription(),
                product.getStock());
    }

    public ProductDTO updateProduct(String id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        product.setNameProduct(productDTO.getNameProduct());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setStock(productDTO.getStock());
        Product updatedProduct = productRepository.save(product);
        return new ProductDTO(updatedProduct.getId(), updatedProduct.getNameProduct(),
                updatedProduct.getPrice(), updatedProduct.getDescription(),
                updatedProduct.getStock());
    }

    public void deleteProduct(String id) {
        if (!productRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        productRepository.deleteById(id);
    }
    public List<ProductDTO> getAllProducts() {
    List<Product> products = productRepository.findAll();
    return products.stream()
    .map(this::mapToDTO)
    .collect(Collectors.toList());
}

    private ProductDTO mapToDTO(Product product) {
        return new ProductDTO(product.getId(), product.getNameProduct(),
                product.getPrice(), product.getDescription(),
                product.getStock());
    }
}