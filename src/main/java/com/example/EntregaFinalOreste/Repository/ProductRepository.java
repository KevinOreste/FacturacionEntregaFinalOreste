package com.example.EntregaFinalOreste.Repository;

import com.example.EntregaFinalOreste.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByCode (String code);
}
