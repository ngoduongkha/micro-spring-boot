package microspringboot.sharedkernel.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;
import lombok.Getter;

import java.util.UUID;

@MappedSuperclass
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PROTECTED)
public abstract class AggregateRoot<T extends AbstractAggregateRoot<T>> extends AbstractAggregateRoot<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Version
    @Column(name = "version", nullable = false)
    @JsonIgnore
    private Long version;

    /**
     * Returns whether this aggregate root is new (meaning it has no ID) or persisted.
     */
    @Transient
    @JsonIgnore
    public boolean isNew() {
        return id == null;
    }
}
