package com.zatribune.demo.loader.db.repository;

import com.zatribune.demo.loader.db.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
