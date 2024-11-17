package com.project1.mapper;

import com.project1.dto.ProductRequest;
import com.project1.dto.ProductResponse;
import com.project1.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .name(request.name())
                .price(request.price())
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(product.getName(), product.getPrice());
    }
}
