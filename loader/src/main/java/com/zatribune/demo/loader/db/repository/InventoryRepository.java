package com.zatribune.demo.loader.db.repository;

import com.zatribune.demo.loader.db.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
