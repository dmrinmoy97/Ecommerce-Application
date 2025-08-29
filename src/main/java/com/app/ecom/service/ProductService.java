package com.app.ecom.service;

import com.app.ecom.dto.ProductRequest;
import com.app.ecom.dto.ProductResponse;
import com.app.ecom.mapper.ProductMapper;
import com.app.ecom.model.Product;
import com.app.ecom.repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public ProductResponse createProduct(ProductRequest productRequest){
        Product product=ProductMapper.updateProductFromRequest(productRequest);
        return ProductMapper.mapToProductResponse(productRepository.save(product));
    }
    public List<ProductResponse> fetchAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::mapToProductResponse)
                .collect(Collectors.toList());
    }
}
