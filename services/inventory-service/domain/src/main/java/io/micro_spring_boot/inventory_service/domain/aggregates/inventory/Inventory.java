package io.micro_spring_boot.inventory_service.domain.aggregates.inventory;

import io.micro_spring_boot.building_blocks.jpa.domain.aggregate.AggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table
@RequiredArgsConstructor
@Getter
@Setter
public class Inventory extends AggregateRoot<Inventory> {
    private String skuCode;
    private Integer quantity;
}
