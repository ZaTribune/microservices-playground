package com.zatribune.demo.products.db.repository;

import com.zatribune.demo.products.db.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
