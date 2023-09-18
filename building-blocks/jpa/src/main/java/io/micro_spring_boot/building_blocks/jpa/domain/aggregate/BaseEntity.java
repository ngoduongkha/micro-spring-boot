package io.micro_spring_boot.building_blocks.jpa.domain.aggregate;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PROTECTED)
public abstract class BaseEntity extends IdentifiableEntity {
    public static final String SOFT_DELETED_CLAUSE = "deleted = false";

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean deleted;
}
