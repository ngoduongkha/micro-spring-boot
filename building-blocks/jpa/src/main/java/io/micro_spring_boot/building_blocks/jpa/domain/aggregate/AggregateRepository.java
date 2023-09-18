package io.micro_spring_boot.building_blocks.jpa.domain.aggregate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AggregateRepository<T extends  AggregateRoot<T>> extends JpaRepository<T, UUID> {
}
