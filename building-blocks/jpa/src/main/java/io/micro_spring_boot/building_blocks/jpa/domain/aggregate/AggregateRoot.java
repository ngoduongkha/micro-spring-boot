package io.micro_spring_boot.building_blocks.jpa.domain.aggregate;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public abstract class AggregateRoot<T extends AbstractAggregateRoot<T>> extends AbstractAggregateRoot<T> {
    public static final String SOFT_DELETED_CLAUSE = "deleted = false";

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(updatable = false)
    @CreatedBy
    private UUID createdBy;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column
    @LastModifiedBy
    private UUID modifiedBy;

    @Column
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean deleted;

    /**
     * Returns whether this aggregate root is new (meaning it has no ID) or persisted.
     */
    @Transient
    public boolean isNew() {
        return id == null;
    }
}
