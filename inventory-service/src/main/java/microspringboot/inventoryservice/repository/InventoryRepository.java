package microspringboot.inventoryservice.repository;

import microspringboot.inventoryservice.aggregate.inventory.Inventory;
import microspringboot.sharedkernel.repository.Repository;

import java.util.List;

public interface InventoryRepository extends Repository<Inventory> {
    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
