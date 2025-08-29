package com.app.ecom.mapper;

import com.app.ecom.dto.ProductRequest;
import com.app.ecom.dto.ProductResponse;
import com.app.ecom.model.Product;

public class ProductMapper {
    public static Product updateProductFromRequest(ProductRequest productRequest){
        Product product=new Product();
        product.setName(productRequest.getName());
        product.setCategory(productRequest.getCategory());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setActive(productRequest.getActive());
        product.setImageUrl(productRequest.getImageUrl());
        return product;
    }
    public static ProductResponse mapToProductResponse(Product product){
        ProductResponse productResponse=new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setActive(product.getActive());
        productResponse.setCategory(product.getCategory());
        productResponse.setImageUrl(product.getImageUrl());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }
}
