package com.zatribune.demo.storefronts.db.repository;

import com.zatribune.demo.storefronts.db.entities.Storefront;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorefrontRepository extends JpaRepository<Storefront,Long> {
}
