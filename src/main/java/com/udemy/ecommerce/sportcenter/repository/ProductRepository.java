package com.udemy.ecommerce.sportcenter.repository;

import com.udemy.ecommerce.sportcenter.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
