package microspringboot.inventoryservice.aggregate.inventory;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import microspringboot.sharedkernel.domain.AggregateRoot;

@Entity
@Table
@RequiredArgsConstructor
@Getter
@Setter
public class Inventory extends AggregateRoot<Inventory> {
    private String skuCode;
    private Integer quantity;
}
