package com.example.spbootProduct.repository;

import com.example.spbootProduct.model.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<product,Integer> {
}
