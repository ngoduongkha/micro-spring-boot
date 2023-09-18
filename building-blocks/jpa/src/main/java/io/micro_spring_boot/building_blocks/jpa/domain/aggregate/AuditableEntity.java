package io.micro_spring_boot.building_blocks.jpa.domain.aggregate;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.util.UUID;

@MappedSuperclass
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PROTECTED)
public abstract class AuditableEntity extends BaseEntity {
    @Column(nullable = false, updatable = false)
    @CreatedBy
    private UUID createdBy;

    @Column
    @LastModifiedBy
    private UUID modifiedBy;
}
