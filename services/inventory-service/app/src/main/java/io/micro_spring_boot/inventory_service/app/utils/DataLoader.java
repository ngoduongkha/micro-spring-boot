package io.micro_spring_boot.inventory_service.app.utils;

import io.micro_spring_boot.inventory_service.domain.aggregates.inventory.Inventory;
import io.micro_spring_boot.inventory_service.infra.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final InventoryRepository inventoryRepository;

    @Override
    public void run(String... args) {
        Inventory inventory = new Inventory();
        inventory.setSkuCode("iphone_13");
        inventory.setQuantity(100);

        Inventory inventory1 = new Inventory();
        inventory1.setSkuCode("iphone_13_pro");
        inventory1.setQuantity(0);

        inventoryRepository.save(inventory);
        inventoryRepository.save(inventory1);
    }
}
