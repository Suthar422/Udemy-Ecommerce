package com.udemy.ecommerce.sportcenter.repository;

import com.udemy.ecommerce.sportcenter.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
