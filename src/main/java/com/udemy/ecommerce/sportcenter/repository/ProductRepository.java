package com.udemy.ecommerce.sportcenter.repository;

import com.udemy.ecommerce.sportcenter.entity.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findAll(Specification<Product> spec, Pageable pageable);

    Specification<Product> searchByNameContaining(String name);

    Specification<Product> findByBrandId(Integer brandId);

    Specification<Product> findByTypeId(Integer typeId);

    Specification<Product> findByBrandIdAndTypeId(Integer brandId, Integer typeId);
}
