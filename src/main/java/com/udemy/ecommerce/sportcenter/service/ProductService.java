package com.udemy.ecommerce.sportcenter.service;

import com.udemy.ecommerce.sportcenter.model.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse getProductById(Integer productId);

    List<ProductResponse> getProducts();
}
