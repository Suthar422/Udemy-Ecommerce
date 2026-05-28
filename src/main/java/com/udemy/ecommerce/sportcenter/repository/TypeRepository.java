package com.udemy.ecommerce.sportcenter.repository;

import com.udemy.ecommerce.sportcenter.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
}
