

package io.micro_spring_boot.inventory_service.infra.repositories;

import io.micro_spring_boot.building_blocks.jpa.domain.aggregate.AggregateRepository;
import io.micro_spring_boot.inventory_service.domain.aggregates.inventory.Inventory;

import java.util.List;

public interface InventoryRepository extends AggregateRepository<Inventory> {
    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
