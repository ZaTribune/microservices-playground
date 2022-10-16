package com.zatribune.demo.loader.db;

import com.zatribune.demo.loader.db.repository.InventoryRepository;
import com.zatribune.demo.loader.db.repository.StorefrontRepository;
import com.zatribune.demo.loader.db.entities.Inventory;
import com.zatribune.demo.loader.db.entities.Product;
import com.zatribune.demo.loader.db.entities.Storefront;
import com.zatribune.demo.loader.db.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Slf4j
@AllArgsConstructor
@Component
public class DevBootstrap implements CommandLineRunner {

    private final StorefrontRepository storefrontRepository;

    private final ProductRepository productRepository;

    private final InventoryRepository inventoryRepository;

    private static final int RECORDS=5000;

    @Override
    public void run(String... args) {

        initStorefronts();
        initProducts();
    }

    public void initStorefronts() {
        storefrontRepository.deleteAll();

        List<Storefront> list = LongStream.range(1, RECORDS).mapToObj(num -> Storefront.builder()
                        .id(num)
                        .name("Storefront " + num)
                        .info("info of Storefront " + num)
                        .logo("logo of Storefront " + num)
                        .title("title of Storefront " + num)
                        .address("address for Storefront " + num)
                        .description("description of Storefront " + num)
                        .m1("dummy data 1 for Storefront" + num)
                        .m2("dummy data 2 for Storefront" + num)
                        .m3("dummy data 3 for Storefront" + num)
                        .m4("dummy data 4 for Storefront" + num)
                        .m5("dummy data 5 for Storefront" + num)
                        .m6("dummy data 6 for Storefront" + num)
                        .m7("dummy data 7 for Storefront" + num)
                        .m8("dummy data 8 for Storefront" + num)
                        .m9("dummy data 9 for Storefront" + num)
                        .m10("dummy data 10 for Storefront" + num)
                        .build())
                .collect(Collectors.toList());

        storefrontRepository.saveAll(list);
    }

    public void initProducts() {
        //delete previous data if any
        inventoryRepository.deleteAll();
        productRepository.deleteAll();

        List<Product> list = LongStream.range(1, RECORDS).mapToObj(num -> Product.builder()
                        .id(num)
                        .name("Product " + num)
                        .info("info of Product " + num)
                        .logo("logo of Product " + num)
                        .title("title of Product " + num)
                        .description("description of Product " + num)
                        .m1("dummy data 1 for Product " + num)
                        .m2("dummy data 2 for Product " + num)
                        .m3("dummy data 3 for Product " + num)
                        .m4("dummy data 4 for Product " + num)
                        .m5("dummy data 5 for Product " + num)
                        .m6("dummy data 6 for Product " + num)
                        .m7("dummy data 7 for Product " + num)
                        .m8("dummy data 8 for Product " + num)
                        .m9("dummy data 9 for Product " + num)
                        .m10("dummy data 10 for Product " + num)
                        .build())
                .collect(Collectors.toList());

        productRepository.saveAll(list);

        final Random random = new Random(50);
        List<Inventory> inventories = LongStream.range(1, RECORDS)
                .mapToObj(num -> Inventory.builder()
                        .id(num)
                        .name("Inventory " + num)
                        .info("info of Inventory " + num)
                        .logo("logo of Inventory " + num)
                        .title("title of Inventory " + num)
                        .description("description of Inventory " + num)
                        .m1("dummy data 1 for Inventory " + num)
                        .m2("dummy data 2 for Inventory " + num)
                        .m3("dummy data 3 for Inventory " + num)
                        .m4("dummy data 4 for Inventory " + num)
                        .m5("dummy data 5 for Inventory " + num)
                        .m6("dummy data 6 for Inventory " + num)
                        .m7("dummy data 7 for Inventory " + num)
                        .m8("dummy data 8 for Inventory " + num)
                        .m9("dummy data 9 for Inventory " + num)
                        .m10("dummy data 10 for Inventory " + num)
                        .product(new Product(num))
                        .storefront(new Storefront(num))
                        .quantity(random.nextInt((1000)))
                        .build())
                .collect(Collectors.toList());

        inventoryRepository.saveAll(inventories);
    }
}
