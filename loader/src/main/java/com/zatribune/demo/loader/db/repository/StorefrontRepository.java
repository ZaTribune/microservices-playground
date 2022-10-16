package com.zatribune.demo.loader.db.repository;

import com.zatribune.demo.loader.db.entities.Storefront;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorefrontRepository extends JpaRepository<Storefront,Long> {
}
