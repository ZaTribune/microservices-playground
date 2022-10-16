package com.zatribune.demo.loader.service;

import com.zatribune.demo.loader.db.entities.Storefront;
import com.zatribune.demo.loader.db.entities.Product;

import java.util.List;

public interface DataService {
    List<Storefront> getStorefrontsData();
    List<Product> getProductsData();
}
